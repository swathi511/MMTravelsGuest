package com.hjsoftware.mmtravelsguest.fragments;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.hjsoftware.mmtravelsguest.R;
import com.hjsoftware.mmtravelsguest.SessionManager;
import com.hjsoftware.mmtravelsguest.activity.BookingAdapter;
import com.hjsoftware.mmtravelsguest.activity.BookingData;
import com.hjsoftware.mmtravelsguest.model.GetBookingPojo;
import com.hjsoftware.mmtravelsguest.webservices.API;
import com.hjsoftware.mmtravelsguest.webservices.RestClient;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookinglistFragment extends Fragment {
    View v;
    EditText frmdate,toodate;
    ImageButton fdate,tdate;
    private int mYear,mMonth,mDay;
    DatePickerDialog datePickerDialog;
    TextView textView;
    BookingAdapter bAdapter;
    RecyclerView rView;
    SessionManager session;
    ArrayList<BookingData> bookingList=new ArrayList<>();
    API REST_CLIENT;
    String profileid;
    String fromdate;
    String todate;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "SharedPref";
    ImageView ivEdit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        REST_CLIENT= RestClient.get();
        pref = getActivity().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        profileid=pref.getString("preparedBy",null);
        session=new SessionManager(getContext());
        System.out.println("PROFILEIDisss"+profileid);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       v=inflater.inflate(R.layout.bookinglist, container, false);

       frmdate=(EditText)v.findViewById(R.id.edit_fromdate);
       toodate=(EditText)v.findViewById(R.id.edit_Todate);
       fdate=(ImageButton)v.findViewById(R.id.button_select);
       tdate=(ImageButton)v.findViewById(R.id.buton_select);
       textView=(TextView)v.findViewById(R.id.textview_view);
       rView=(RecyclerView)v.findViewById(R.id.recycler_view);
       rView.setVisibility(View.GONE);

        final Calendar c = Calendar.getInstance();
        final int mYear = c.get(Calendar.YEAR);
        final int mMonth = c.get(Calendar.MONTH);
        final int mDay = c.get(Calendar.DAY_OF_MONTH);

        fromdate=(mMonth+1)+"-"+mDay+"-"+mYear;
        todate=(mMonth+1)+"-"+mDay+"-"+mYear;
        SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
        frmdate.setText(mDay+"/"+(mMonth+1)+"/"+mYear);
        toodate.setText(mDay+"/"+(mMonth+1)+"/"+mYear);

        fdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                frmdate.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);
                                fromdate=(monthOfYear+1)+"-"+dayOfMonth+"-"+year;

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }


        });
        tdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                datePickerDialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                toodate.setText(dayOfMonth + "/"
                                        +(monthOfYear + 1)+ "/" + year);

                                todate=(monthOfYear+1)+"-"+dayOfMonth+"-"+year;

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
               Step 1: Get From date and to Date ... Call the Web service - API call
               Step 2: API call data has to be kept in arraylist
               Step 3: Arraylist has to be passed to RecyclerAdapter
                 */
                final ProgressDialog progressDialog = new ProgressDialog(getActivity());
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Please Wait ...");
                progressDialog.show();


                String custemorIds = pref.getString("customerId",null);

                System.out.println("!"+custemorIds+"!"+fromdate+"!"+todate+"!"+profileid+"!");

                Log.i("@@@Customer id@@",custemorIds+" nnn "+fromdate+" nnn "+todate);
                Call<List<GetBookingPojo>>getBookingPojo=REST_CLIENT.getbookingdetails(custemorIds,profileid,fromdate,todate);
                getBookingPojo.enqueue(new Callback<List<GetBookingPojo>>() {

                    List<GetBookingPojo>bookingstatus;
                    GetBookingPojo bookingData;
                    @Override
                    public void onResponse(Call<List<GetBookingPojo>> call, Response<List<GetBookingPojo>> response) {
                        bookingstatus=response.body();
                        if(response.isSuccessful()){


                            bookingList.clear();
                            for(int i=0;i<bookingstatus.size();i++){

                                bookingData=bookingstatus.get(i);
                                String bookingid=bookingData.getBookingid();
                                String vecle=bookingData.getVehiclecategory();
                                String reprtdate=bookingData.getReportdate();
                                String reporttime=bookingData.getReporttime();
                                String guestname=bookingData.getGuestname();
                                bookingList.add(new BookingData(bookingData.getBookingid(),bookingData.getCreationdate().split(" ")[0],bookingData.getCreationtime(),bookingData.getVehiclecategory(),bookingData.getGuestname(),bookingData.getReportdate(),bookingData.getReporttime()));

                            }
                            if(bookingList.size()!=0){

                                Log.i("data","OO::::"+bookingList.size());
                                rView.setVisibility(View.VISIBLE);
                             bAdapter = new BookingAdapter(getActivity(), bookingList, rView);
                                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                                rView.setLayoutManager(mLayoutManager);
                                rView.setItemAnimator(new DefaultItemAnimator());
                                rView.setAdapter(bAdapter);
                                bAdapter.notifyDataSetChanged();
                                progressDialog.dismiss();

                            }else{

                                rView.setVisibility(View.GONE);
                                Toast.makeText(getActivity(),"No Bookings!",Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }

                        }
                        else {

                            rView.setVisibility(View.GONE);
                            Toast.makeText(getActivity(),"No Bookings!",Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<GetBookingPojo>> call, Throwable t) {
                        rView.setVisibility(View.GONE);
                        progressDialog.dismiss();
                        t.printStackTrace();
                        System.out.println("msg"+t.getMessage());
                        Toast.makeText(getActivity(),"Please check Internet connection!",Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

        return v;
    }



}
