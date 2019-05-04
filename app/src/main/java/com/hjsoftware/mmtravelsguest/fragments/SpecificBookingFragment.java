package com.hjsoftware.mmtravelsguest.fragments;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.hjsoftware.mmtravelsguest.R;
import com.hjsoftware.mmtravelsguest.SessionManager;
import com.hjsoftware.mmtravelsguest.activity.BookingListActivity;
import com.hjsoftware.mmtravelsguest.model.LocationPojo;
import com.hjsoftware.mmtravelsguest.model.MessagePojo;
import com.hjsoftware.mmtravelsguest.model.SpecificBookingPojo;
import com.hjsoftware.mmtravelsguest.model.VehiclePojo;
import com.hjsoftware.mmtravelsguest.webservices.API;
import com.hjsoftware.mmtravelsguest.webservices.RestClient;
import com.google.gson.JsonObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hjsoftware on 1/12/17.
 */
public class SpecificBookingFragment extends Fragment {

    View v;
    private EditText no_days,g_name,g_number,g_mailid,b_name,b_number,bmailid,flight,train,otherloctns;
    private Button r_time,submit,back;
    String[] reporting_place={"Office","Guest House","Residence","Airport","Hyd-bad Rly Station","Sec-bad Rly Station","Kacheguda Rly Station","Other Place"};
    String[] booking_type={"Spot Rental","Point-Point"};
    String[] travel_type={"Local","Out Station"};
    private Spinner servicelocation,reportingplace,vehicletype,bookingtype,pointpoint,timeinterval;
    String vehicletypeitem, servicelocationitem1,reportingplaceitem3, bookingtypeitem4,pointpointitem5="",item6;
    private TextView display,display1,op,ft,travel,r_date,timedisplay;
    private  TimePicker timePicker;
    private TextView train1,flight1,reportingDateTime,bookngfor;
    String format;
    Button ok,cancel,timedate;
    TimePicker tp;
    DatePicker dp;
    int hr,min,day,mnth,yr;
    String stDate,stTime;
    LinearLayout linearLayout1,linearLayout,linearLayout_boking;
    SessionManager session;
    API REST_CLIENT;
    ArrayList<String> mylist = new ArrayList<String>();
    ArrayList<String> mylist4 = new ArrayList<String>();
    ArrayList<String> mylist2 = new ArrayList<String>();
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "SharedPref";
    ImageView ivEdit;
    String profileid;
    String bookingId,custemorIds;
    Bundle b;
    RadioGroup radioGroup,radioGroupbooking;
    RadioButton radioButton1,radioButton2,radio_slf,radio_othr;;
    boolean btime=false;
    ProgressDialog progressDialog;
    TextView tv_outstation;
    EditText et_outstation;
    LinearLayout ll_outstation;
    String stTravelType="",stNoDays,stOsName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.fragment_edit_booking,container,false);
        REST_CLIENT= RestClient.get();
        pref = getActivity().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        session=new SessionManager(getContext());
        g_name=(EditText)v.findViewById(R.id.edit_guest);
        g_number=(EditText)v.findViewById(R.id.edit_gmobile);
        g_mailid=(EditText)v.findViewById(R.id.edit_gemail1);
        no_days=(EditText)v.findViewById(R.id.edit_nodays);
        submit=(Button) v.findViewById(R.id.btn_submit);
        servicelocation=(Spinner)v.findViewById(R.id.spinner_servicelocation);
        reportingplace=(Spinner)v.findViewById(R.id.spinner_reportingplace);
        vehicletype=(Spinner)v.findViewById(R.id.spinner_vehicle);
        bookingtype=(Spinner)v.findViewById(R.id.spinner_bokkingtype);
        pointpoint=(Spinner)v.findViewById(R.id.spinner_pointtopoint) ;
        radioGroup=(RadioGroup)v.findViewById(R.id.radiogroup);
        radioButton1=(RadioButton)v.findViewById(R.id.radio_local);
        radioButton2=(RadioButton)v.findViewById(R.id.radio_outstation);
        flight=(EditText)v.findViewById(R.id.edit_flight);
        otherloctns=(EditText)v.findViewById(R.id.edit_otherplace);
        op=(TextView)v.findViewById(R.id.text_otherplaces);
        flight1=(TextView)v.findViewById(R.id.text_flight);
        flight1=(TextView)v.findViewById(R.id.text_flight);
        travel=(TextView)v.findViewById(R.id.textview_travel);
      //  r_date=(TextView)v.findViewById(R.id.edit_reportingdate);
        linearLayout=(LinearLayout)v.findViewById(R.id.linear_layout120);
        linearLayout1=(LinearLayout)v.findViewById(R.id.linear_110);
        reportingDateTime=(TextView)v.findViewById(R.id.edit_reportingdatetime);
        timedisplay=(TextView)v.findViewById(R.id.select_time);
        ivEdit=(ImageView)v.findViewById(R.id.fnb_iv_edit);
        ok=(Button)v.findViewById(R.id.ok);
        cancel=(Button)v.findViewById(R.id.cancel);
        tp=(TimePicker)v.findViewById(R.id.simpleTimePicker);
        dp=(DatePicker)v.findViewById(R.id.datePicker);

        tv_outstation=(TextView)v.findViewById(R.id.tv_out_staion);
        et_outstation=(EditText)v.findViewById(R.id.et_out_station);
        ll_outstation=(LinearLayout)v.findViewById(R.id.ll_out_station);

        reportingDateTime=(TextView)v.findViewById(R.id.edit_reportingdatetime);

        b=getActivity().getIntent().getExtras();
        bookingId=b.getString("bookingId",null);
        profileid=pref.getString("preparedBy",null);
        custemorIds=pref.getString("customerId",null);
        getServerData();
        getTheData();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId)
                {
                    case R.id.radio_local:

                        pointpointitem5="local";
                        ll_outstation.setVisibility(View.GONE);
                        tv_outstation.setVisibility(View.GONE);
                        et_outstation.setVisibility(View.GONE);
                        et_outstation.setText("-");
                        no_days.setText("0");
                        break;
                    case R.id.radio_outstation:
                        pointpointitem5="outstation";
                        ll_outstation.setVisibility(View.VISIBLE);
                        tv_outstation.setVisibility(View.VISIBLE);
                        et_outstation.setVisibility(View.VISIBLE);

                        if(stTravelType.equals("outstation"))
                        {
                            no_days.setText(stNoDays);
                            et_outstation.setText(stOsName);
                        }
                        else {

                            no_days.setText("");
                            et_outstation.setText("");
                        }

                        break;
                }
            }
        });

        ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());

                LayoutInflater inflater = getActivity().getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.alert_date_time, null);
                dialogBuilder.setView(dialogView);

                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.setCancelable(false);
                alertDialog.show();

                dp=(DatePicker)dialogView.findViewById(R.id.datePicker);
                tp=(TimePicker)dialogView.findViewById(R.id.simpleTimePicker);
                ok=(Button)dialogView.findViewById(R.id.ok);
                cancel=(Button)dialogView.findViewById(R.id.cancel);

                tp.setIs24HourView(true);
                hr=tp.getCurrentHour();
                min=tp.getCurrentMinute();
                long now = System.currentTimeMillis() - 1000;
                setTimePickerInterval(tp);
                dp.setMinDate(now);
                day = dp.getDayOfMonth();
                mnth = dp.getMonth() + 1;
                yr = dp.getYear();
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                dp.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

                    @Override
                    public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {

                        day=dayOfMonth;
                        mnth=month+1;
                        yr=year;

                    }
                });

                tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker timePicker, int i, int i1) {

                        System.out.println("time is "+i+"::"+i1);

                        i1=i1*15;
                        hr=i;
                        min=i1;
                        btime=true;
                        System.out.println("time is "+i+"::"+i1);

                    }
                });

                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (btime) {

                            Date d = makeDateGMT(yr, mnth - 1, day);
                            Date d1 = new Date();

                            if (d.equals(d1)) {

                                Calendar datetime = Calendar.getInstance();
                                Calendar c = Calendar.getInstance();
                                datetime.set(Calendar.HOUR_OF_DAY, hr);
                                datetime.set(Calendar.MINUTE, min);

                                if (datetime.getTimeInMillis() > c.getTimeInMillis()) {

                                    stDate =mnth+ "-" + day+ "-" + yr;
                                    stTime = hr + "." + min;
                                    reportingDateTime.setVisibility(View.VISIBLE);
                                    reportingDateTime.setText(day + "/" + mnth + "/" + yr);
                                    timedisplay.setText(stTime);
                                    timedisplay.setTextColor(Color.BLACK);
                                    reportingDateTime.setTextColor(Color.BLACK);
                                    alertDialog.dismiss();
                                } else {
                                    Toast.makeText(getActivity(), "Please Choose Time ahead of current time", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                stDate =mnth+ "-" +day + "-" + yr;
                                stTime = hr + "." + min;
                                reportingDateTime.setVisibility(View.VISIBLE);
                                reportingDateTime.setText(day + "/" + mnth + "/" + yr);
                                timedisplay.setText(stTime);
                                timedisplay.setTextColor(Color.BLACK);
                                reportingDateTime.setTextColor(Color.BLACK);
                                alertDialog.dismiss();
                            }
                        }

                        else

                        {

                            Toast.makeText(getActivity(), "Please select time!", Toast.LENGTH_SHORT).show();
                        }
                    }

                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        alertDialog.dismiss();

                    }
                });
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String sg_name= g_name.getText().toString();
                String sg_number = g_number.getText().toString();
                String sg_mailid =g_mailid.getText().toString();

                if(reportingplaceitem3.equals("Airport") &&flight.getText().toString().equals("")) {

                    flight.setError("Enter flight no");
                }
                else if(reportingplaceitem3.equals("Other Place")&&otherloctns.getText().toString().equals("")){

                    otherloctns.setError("Type the desc for place");
                }
                else if((reportingplaceitem3.equals("Hyd-bad Rly Station")||reportingplaceitem3.equals("Sec-bad Rly Station")||reportingplaceitem3.equals("Kacheguda Rly Station"))&&flight.getText().toString().equals("")){

                    flight.setError("Enter train no:");
                }
                else if(sg_name.equals("")){
                    g_name.setError("Enter Guest Name");
                }
                else if(sg_number.equals("")||sg_number.length()!=10){
                    g_number.setError("Enter valid Mobile Number");
                }
                else if(sg_mailid.equals("")){
                    g_mailid.setError("Enter Mail id");
                }
                else if(!(android.util.Patterns.EMAIL_ADDRESS.matcher(g_mailid.getText().toString()).matches()))
                {
                    Toast.makeText(getActivity(),"Enter valid Email Address",Toast.LENGTH_SHORT).show();
                    g_mailid.setText("");
                }
                else if(reportingDateTime.getText().toString().equals("select")||timedisplay.getText().toString().equals("select"))
                {
                    Toast.makeText(getActivity(),"Enter Reporting Date and Time",Toast.LENGTH_SHORT).show();

                    reportingDateTime.setTextColor(Color.RED);
                    timedisplay.setTextColor(Color.RED);
                }
                else if(pointpointitem5.equals(""))
                {
                    Toast.makeText(getActivity(),"Please select Local/Outstation!",Toast.LENGTH_SHORT).show();

                }
                else if(pointpointitem5.equals("outstation")&&(et_outstation.getText().toString().trim().equals("")))
                {
                    Toast.makeText(getActivity(),"Please enter Outstation Name!",Toast.LENGTH_SHORT).show();

                }
                else if(pointpointitem5.equals("outstation")&&no_days.getText().toString().trim().equals(""))
                {
                    Toast.makeText(getActivity(),"Please enter Outstation Days!",Toast.LENGTH_SHORT).show();

                }
                else{

                    if(bookingtypeitem4.equals("Point-Point"))
                    {
                        pointpointitem5="local";
                    }

                    String custemorIds = pref.getString("customerId",null);

//                    System.out.println("no_days"+no_days.getText().toString().trim());
//                    System.out.println("os_name"+et_outstation.getText().toString().trim());
//
//                    System.out.println(pref.getString("bookername",null)+"::"+pref.getString("mobileno",null)+"::"+pref.getString("emailid",null));
//                    System.out.println("no."+no_days.getText().toString().trim());
//                    System.out.println("@@@@"+stDate);
//                   System.out.println("bbbbb"+timedisplay.getText().toString().trim());
//                    System.out.println("bookingtype"+bookingtypeitem4);
//                    System.out.println("traveltype"+pointpointitem5);
//                    System.out.println("pointpoint"+pointpointitem5);System.out.println("guedst"+g_name.getText().toString().trim());
//                   System.out.println("profileid"+profileid);
//                    System.out.println("loc"+servicelocationitem1);
//                   System.out.println("pickup"+reportingplaceitem3);
//                     Log.i("ids2222@@@@@",pref.getString("bookername",null));


                    JsonObject v=new JsonObject();
                    v.addProperty("bookingid",bookingId);
                    v.addProperty("customerid",custemorIds);
                    v.addProperty("vehiclecategory",vehicletypeitem);
                    v.addProperty("tariffcategory",bookingtypeitem4);
                    v.addProperty("traveltype",pointpointitem5);
                    v.addProperty("bookedby",pref.getString("bookername",null));
                    v.addProperty("bookedbymobile",pref.getString("mobileno",null));
                    v.addProperty("bbemail",pref.getString("emailid",null));
                    v.addProperty("reportdate",stDate);
                    v.addProperty("reporttime",timedisplay.getText().toString().trim());
                    v.addProperty("guestname",g_name.getText().toString().trim());
                    v.addProperty("guestmobileno",g_number.getText().toString().trim());
                    v.addProperty("guestemail",g_mailid.getText().toString().trim());
                    v.addProperty("pickupfrom",reportingplaceitem3);
                    v.addProperty("preparedby",profileid);
                    v.addProperty("location",servicelocationitem1);
                    v.addProperty("NoOfDays",no_days.getText().toString().trim());
                    v.addProperty("routesno","0");
                    v.addProperty("OutStationName",et_outstation.getText().toString().trim());
                    v.addProperty("pickuploc","null");
                    v.addProperty("otherplace",otherloctns.getText().toString().trim());
                    v.addProperty("Spinstruct", "-");
                    v.addProperty("CostCode","");
                    v.addProperty("dropat","");
                    v.addProperty( "bookedbysmsstatus","Y");
                    v.addProperty("bookedbysms","999999999");
                    v.addProperty("bbemailstatus", "Y");
                    v.addProperty("bbemailidsend","testt@gmail");
                    v.addProperty( "guestsmsstatus", "");
                    v.addProperty( "guestsms", "");
                    v.addProperty( "emailsendstatus","");
                    v.addProperty("emailidsend","");
                    v.addProperty("empno","");
                    v.addProperty( "refno",1);
                    v.addProperty("ftinfo",flight.getText().toString().trim());
                    v.addProperty("advrec",0);
                    v.addProperty( "sno",1);
                    v.addProperty("remindertime","");
                    v.addProperty(  "noofveh",0);
                    v.addProperty("custrefno","");
                    v.addProperty( "tripno","");
                    v.addProperty("confirmationno","");
                    v.addProperty(  "totkms1new",10);
                    v.addProperty( "tothrs1new",10);
                    v.addProperty("hrscrt1new","10");
                    v.addProperty("nofdays1new","3");
                    v.addProperty("criteria","");
                    v.addProperty("bktype","");
                    v.addProperty(  "crtype","");
                    v.addProperty( "crno","");
                    v.addProperty("guide","");
                    v.addProperty( "instructions","");
                    v.addProperty("sourcetype","");
                    v.addProperty("sourcedet","");
                    v.addProperty( "docname","");
                    v.addProperty( "stime",timedisplay.getText().toString().trim());
                    v.addProperty( "transfer","");
                    v.addProperty("creditmnth","11");
                    v.addProperty( "credityear","2014");
                    v.addProperty("garagestatus", "Not Applicable");
                    v.addProperty("bookerprefix","+91");
                    v.addProperty("guestprefix","+91");
                    v.addProperty( "pref","No");
                    v.addProperty( "vendorallotstatus","N");
                    v.addProperty( "vendorid","-");
                    v.addProperty( "mtariffsno",0);
                    v.addProperty("routename","");
                    //v.addProperty("Flag", "update");


                    Call<MessagePojo>validatee=REST_CLIENT.bookinginfo(v);
                    validatee.enqueue(new Callback<MessagePojo>() {

                        MessagePojo validatee;
                        @Override
                        public void onResponse(Call<MessagePojo> call, Response<MessagePojo> response) {

                            if(response.isSuccessful()){

                                validatee=response.body();

                                Toast.makeText(getActivity(),"Booking successfully updated!",Toast.LENGTH_LONG).show();
                                Intent i=new Intent(getActivity(), BookingListActivity.class);
                                startActivity(i);
                                getActivity().finish();


                            }
                            else {


                            }
                        }

                        @Override
                        public void onFailure(Call<MessagePojo> call, Throwable t) {

                            Toast.makeText(getActivity(),"Please check Internet connection!",Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });


        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    private Date makeDateGMT(int year, int month, int day) {
        GregorianCalendar calendar = new GregorianCalendar();
        // calendar.setTimeZone(TimeZone.getTimeZone());
        calendar.set(year,month, day);
        return calendar.getTime();
    }


    public static String convert24To12System (int hour, int minute) {
        String time = "";
        String am_pm = "";
        if (hour < 12 ) {
            if (hour == 0) hour = 12;
            am_pm = "AM";
        }
        else {
            if (hour != 12)
                hour-=12;
            am_pm = "PM";
        }
        String h = hour+"", m = minute+"";
        if(h.length() == 1) h = "0"+h;
        if(m.length() == 1) m = "0"+m;
        time = h+":"+m+" "+am_pm;
        return time;
    }


    private void setTimePickerInterval(TimePicker timePicker) {
        try {
            int TIME_PICKER_INTERVAL = 15;
            NumberPicker minutePicker = (NumberPicker) timePicker.findViewById(Resources.getSystem().getIdentifier(
                    "minute", "id", "android"));
            minutePicker.setMinValue(0);
            minutePicker.setMaxValue((60 / TIME_PICKER_INTERVAL) - 1);
            List<String> displayedValues = new ArrayList<String>();
            for (int i = 0; i < 60; i += TIME_PICKER_INTERVAL) {
                displayedValues.add(String.format("%02d", i));
            }
            minutePicker.setDisplayedValues(displayedValues.toArray(new String[0]));
        } catch (Exception e) {
            Log.e("ada", "Exception: " + e);
        }
    }


    public void getTheData()
    {
        final String ppnames= pref.getString("ppnames",null);
        if(ppnames.equals("Not Required")){
            linearLayout.setVisibility(View.GONE);
        }
        else{
            mylist4.add(ppnames);
        }

        ArrayAdapter arrayAdapter12=new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,mylist4);
        arrayAdapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pointpoint.setAdapter(arrayAdapter12);
        pointpoint.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                pointpointitem5 = pointpoint.getItemAtPosition(position).toString();
                System.out.println("slected is spinner");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter arrayAdapter5=new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,booking_type);
        arrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bookingtype.setAdapter(arrayAdapter5);

        bookingtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                bookingtypeitem4 = bookingtype.getItemAtPosition(position).toString();


                if(bookingtypeitem4=="Point-Point"&&!(ppnames.equals("Not Required"))){
                    pointpoint.setVisibility(View.VISIBLE);
                    linearLayout.setVisibility(View.VISIBLE);
                    linearLayout1.setVisibility(View.GONE);
                    ll_outstation.setVisibility(View.GONE);
                    tv_outstation.setVisibility(View.GONE);
                    et_outstation.setVisibility(View.GONE);
                    no_days.setText("0");
                    et_outstation.setText("-");
                }
                else {
                    bookingtype.setSelection(0);
                }

                if( bookingtypeitem4=="Spot Rental"){

                    linearLayout.setVisibility(View.GONE);
                    linearLayout1.setVisibility(View.VISIBLE);
                    ll_outstation.setVisibility(View.GONE);

                    if(pointpointitem5.equals("outstation"))
                    {
                        if(stTravelType.equals("outstation"))
                        {
                            ll_outstation.setVisibility(View.VISIBLE);
                            et_outstation.setVisibility(View.VISIBLE);
                            tv_outstation.setVisibility(View.VISIBLE);
                            no_days.setText(stNoDays);
                            et_outstation.setText(stOsName);
                        }
                        else {
                            ll_outstation.setVisibility(View.VISIBLE);
                            et_outstation.setVisibility(View.VISIBLE);
                            tv_outstation.setVisibility(View.VISIBLE);
                            no_days.setText("");
                            et_outstation.setText("");
                        }
                    }
                }
                else{


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter arrayAdapter=new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,reporting_place);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reportingplace.setAdapter(arrayAdapter);


        reportingplace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            reportingplaceitem3 = reportingplace.getItemAtPosition(position).toString();

                String item = parent.getItemAtPosition(position).toString();

                if(item.equals("Airport"))
                {
                    otherloctns.setVisibility(View.GONE);
                    op.setVisibility(View.GONE);
                    flight.setVisibility(View.VISIBLE);
                    flight1.setVisibility(View.VISIBLE);
                }
                else if(item.equals("Hyd-bad Rly Station"))
                {
                    otherloctns.setVisibility(View.GONE);
                    op.setVisibility(View.GONE);
                    flight.setVisibility(View.VISIBLE);
                    flight1.setVisibility(View.VISIBLE);
                }
                else if(item.equals("Sec-bad Rly Station"))
                {
                    otherloctns.setVisibility(View.GONE);
                    op.setVisibility(View.GONE);
                    flight.setVisibility(View.VISIBLE);
                    flight1.setVisibility(View.VISIBLE);
                }
                else if(item.equals("Kacheguda Rly Station"))
                {
                    otherloctns.setVisibility(View.GONE);
                    op.setVisibility(View.GONE);
                    flight.setVisibility(View.VISIBLE);
                    flight1.setVisibility(View.VISIBLE);
                }
                else if(item.equals("Office"))
                {
                    otherloctns.setVisibility(View.GONE);
                    op.setVisibility(View.GONE);
                    flight.setVisibility(View.GONE);
                    flight1.setVisibility(View.GONE);
                }
                else
                {
                    otherloctns.setVisibility(View.VISIBLE);
                    op.setVisibility(View.VISIBLE);
                    flight.setVisibility(View.GONE);
                    flight1.setVisibility(View.GONE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter arrayAdapter8=new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,mylist2);
        arrayAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        servicelocation.setAdapter(arrayAdapter8);

        servicelocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                servicelocationitem1 = servicelocation.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter arrayAdapter2=new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,mylist);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vehicletype.setAdapter(arrayAdapter2);

        vehicletype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                vehicletypeitem =vehicletype.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void getServerData()
    {

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Please wait ...");
        progressDialog.show();

        retrofit2.Call<List<VehiclePojo>> vehicle=REST_CLIENT.getInfo(custemorIds);
        vehicle.enqueue(new Callback<List<VehiclePojo>>() {

            List<VehiclePojo> vehiclestatus;
            VehiclePojo vehData;
            @Override
            public void onResponse(retrofit2.Call<List<VehiclePojo>> call, Response<List<VehiclePojo>> response) {

                vehiclestatus = response.body();

                if(response.isSuccessful()){

                    for(int i=0;i<vehiclestatus.size();i++) {
                        vehData = vehiclestatus.get(i);
                        String vehicleName = vehData.getVehcategory();
                        mylist.add(vehicleName);
                    }

                    ArrayAdapter arrayAdapter2=new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,mylist);
                    arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    vehicletype.setAdapter(arrayAdapter2);


                    // ************** second api call

                    retrofit2.Call<List<LocationPojo>> vehiclee=REST_CLIENT.getInfoo(custemorIds);
                    vehiclee.enqueue(new Callback<List<LocationPojo>>() {

                        List<LocationPojo> locationstatus;
                        LocationPojo loctData;
                        @Override
                        public void onResponse(retrofit2.Call<List<LocationPojo>> call, Response<List<LocationPojo>> response) {

                            locationstatus = response.body();

                            // String[] items;
                            if(response.isSuccessful()){

                                for(int i=0;i<locationstatus.size();i++) {
                                    loctData = locationstatus.get(i);
                                    String LocationName = loctData.getLocation();
                                    mylist2.add(LocationName);

                                }

                                ArrayAdapter arrayAdapter8=new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,mylist2);
                                arrayAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                servicelocation.setAdapter(arrayAdapter8);

                                //************************ third api call - bookings data
                                getBookingData();
                                // **************************************
                            }
                            else{

                                String vehiclee=response.message();
                            }

                        }

                        @Override
                        public void onFailure(retrofit2.Call<List<LocationPojo>> call, Throwable t) {

                            progressDialog.dismiss();
                            Toast.makeText(getActivity(),"Please check Internet connection!",Toast.LENGTH_SHORT).show();

                        }
                    });
                    // **********************************************
                }
                else{

                    String vehicle=response.message();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<List<VehiclePojo>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(),"Please check Internet connection!",Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void getBookingData()
    {
        Call<List<SpecificBookingPojo>> call=REST_CLIENT.getSpecificBooking(custemorIds,bookingId,profileid);
        call.enqueue(new Callback<List<SpecificBookingPojo>>() {
            @Override
            public void onResponse(Call<List<SpecificBookingPojo>> call, Response<List<SpecificBookingPojo>> response) {

                SpecificBookingPojo data;
                List<SpecificBookingPojo> datalist;
                if(response.isSuccessful())
                {
                    progressDialog.dismiss();
                    datalist=response.body();
                    data=datalist.get(0);
                    g_name.setText(data.getGuestname());
                    g_mailid.setText(data.getGuestemail());
                    g_number.setText(data.getGuestmobileno());


                    if(data.getTariffcategory().equals("Spot Rental"))
                    {
                        bookingtype.setSelection(0);
                        linearLayout1.setVisibility(View.VISIBLE);
                        linearLayout.setVisibility(View.GONE);

                        if(data.getTraveltype().equals("local"))
                        {
                            radioButton1.setChecked(true);
                            no_days.setText(data.getNoOfDays());
                            pointpointitem5="local";
                            stTravelType="local";
                        }
                        else
                        {
                            stTravelType="outstation";
                            stNoDays=data.getNoOfDays();
                            stOsName=data.getOutStationName();
                            radioButton2.setChecked(true);
                            no_days.setText(data.getNoOfDays());
                            pointpointitem5="outstation";
                            ll_outstation.setVisibility(View.VISIBLE);
                            et_outstation.setText(data.getOutStationName());
                        }
                    }
                    else
                    {
                        bookingtype.setSelection(1);
                        linearLayout.setVisibility(View.VISIBLE);
                        linearLayout1.setVisibility(View.GONE);


                        if(data.getTraveltype().equals("Airport Transfer"))
                        {
                            pointpoint.setSelection(0);
                            pointpointitem5="Airport Transfer";

                        }


                    }


                    try {
                        SimpleDateFormat newformat = new SimpleDateFormat("dd/MM/yyyy");
                        String datestring = data.getReportdate().split(" ")[0];
                        SimpleDateFormat oldformat = new SimpleDateFormat("MM/dd/yyyy");
                        String reformattedStr = newformat.format(oldformat.parse(datestring));

                        reportingDateTime.setText(reformattedStr);
                        stDate=data.getReportdate().split(" ")[0];

                    }catch(ParseException e){e.printStackTrace();}

                    timedisplay.setText(data.getReporttime());
                    reportingDateTime.setTextColor(Color.BLACK);
                    timedisplay.setTextColor(Color.BLACK);

                    if(data.getLocation().equals("Hyderabad"))
                    {
                        servicelocation.setSelection(0);
                    }
                    else if(data.getLocation().equals("Vijayawada"))
                    {
                        servicelocation.setSelection(1);
                    }
                    else {
                        servicelocation.setSelection(2);
                    }

                    System.out.println("my list size... "+mylist.size());

                    for(int i=0;i<mylist.size();i++)
                    {

                        String v=(String) vehicletype.getItemAtPosition(i);

                        String y[]=v.split("--");
                        System.out.println(y[0]+":"+y[1]+":"+data.getVehiclecategory()+":"+data.getVehicletype());

                        if(y[0].equals(data.getVehiclecategory())&&y[1].equals(data.getVehicletype()))
                        {
                            vehicletype.setSelection(i);
                            break;
                        }
                    }

                    if(data.getPickupfrom().equals("Office"))
                    {
                        reportingplace.setSelection(0);
                    }
                    else if(data.getPickupfrom().equals("Guest House"))
                    {
                        reportingplace.setSelection(1);
                        otherloctns.setText(data.getOtherplace());
                        otherloctns.setVisibility(View.VISIBLE);
                    }
                    else if(data.getPickupfrom().equals("Residence"))
                    {
                        reportingplace.setSelection(2);
                        otherloctns.setText(data.getOtherplace());
                        otherloctns.setVisibility(View.VISIBLE);
                    }
                    else if(data.getPickupfrom().equals("Airport"))
                    {
                        reportingplace.setSelection(3);
                        flight.setVisibility(View.VISIBLE);
                        flight.setText(data.getFtInfo());
                    }
                    else if(data.getPickupfrom().equals("Hyd-bad Rly Station"))
                    {
                        reportingplace.setSelection(4);
                        flight.setVisibility(View.VISIBLE);
                        flight.setText(data.getFtInfo());
                    }
                    else if(data.getPickupfrom().equals("Sec-bad Rly Station"))
                    {
                        reportingplace.setSelection(5);
                        flight.setVisibility(View.VISIBLE);
                        flight.setText(data.getFtInfo());
                    }
                    else if(data.getPickupfrom().equals("Kacheguda Rly Station"))
                    {
                        reportingplace.setSelection(6);
                        flight.setVisibility(View.VISIBLE);
                        flight.setText(data.getFtInfo());
                    }
                    else {

                        reportingplace.setSelection(7);
                        otherloctns.setText(data.getOtherplace());
                        otherloctns.setVisibility(View.VISIBLE);
                    }
                    if(data.getApprovalstatus().equals("Approved"))
                    {
                        submit.setVisibility(View.GONE);
                        bookingtype.setEnabled(false);
                        pointpoint.setEnabled(false);
                        radioGroup.setEnabled(false);
                        radioButton1.setEnabled(false);
                        radioButton2.setEnabled(false);
                        ivEdit.setEnabled(false);
                        servicelocation.setEnabled(false);
                        vehicletype.setEnabled(false);
                        reportingplace.setEnabled(false);
                        g_name.setEnabled(false);
                        g_mailid.setEnabled(false);
                        g_number.setEnabled(false);
                        flight.setEnabled(false);
                        otherloctns.setEnabled(false);
                        no_days.setEnabled(false);
                        et_outstation.setEnabled(false);


                    }
                    else {
                        submit.setVisibility(View.VISIBLE);

                        //getTheData();

                    }
                }
            }

            @Override
            public void onFailure(Call<List<SpecificBookingPojo>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(),"Please check Internet connection!",Toast.LENGTH_SHORT).show();

            }
        });

    }

}
