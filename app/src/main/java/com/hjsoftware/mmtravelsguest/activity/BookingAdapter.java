package com.hjsoftware.mmtravelsguest.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget. TextView;
import com.hjsoftware.mmtravelsguest.R;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by hjsoftware on 6/1/18.
 */

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.MyViewHolder> {
    private List<BookingData>bookingDataList;
    BookingData bookingData;
    private AdapterCallback mAdapterCallback;
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");

    public class MyViewHolder extends RecyclerView.ViewHolder{

            TextView ref_number,booking_date,reporting_date,reporting_time,guest_name,vehicle_type;
            RelativeLayout rlLayout;


       // SimpleDateFormat format1 = new SimpleDateFormat("dd/mm/yyyy");


            public MyViewHolder(View itemView) {
            super(itemView);
            ref_number=( TextView)itemView.findViewById(R.id. TextView_ref);
            booking_date=( TextView)itemView.findViewById(R.id.et_booking_date);
            reporting_date=( TextView)itemView.findViewById(R.id.et_reporting_date);
            reporting_time=( TextView)itemView.findViewById(R.id.et_reporting_time);
            guest_name=( TextView)itemView.findViewById(R.id.et_guest_name);
            vehicle_type=( TextView)itemView.findViewById(R.id.et_vehicle_type);
            rlLayout=(RelativeLayout)itemView.findViewById(R.id.ll_rlayout);

           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   try {
                       String bookingId= (String) v.getTag();
                       mAdapterCallback.onMethodCallback(bookingId);

                   }
                   catch (ClassCastException e)
                   {
                       e.printStackTrace();
                   }
               }
           });
           }
      }
      public BookingAdapter(Context context, List<BookingData> bookingDataList, RecyclerView rView) {
        this.bookingDataList = bookingDataList;

        try {
            this.mAdapterCallback = ((AdapterCallback) context);
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement AdapterCallback.");
        }
    }
    @Override
    public BookingAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(BookingAdapter.MyViewHolder holder, int position) {

        // System.out.println("data is "+position+bookingDataList.size());
        //System.out.println("****"+bookingData.getBookingId());
       //System.out.println("****"+bookingData.getBooking_date());
       //System.out.println("****"+bookingData.getReporting_date());
       //System.out.println("****"+bookingData.getReporting_time());
       //System.out.println("****"+bookingData.getGuest_name());
       //holder.ref_number.setText(bookingData.getRef_no());
       //holder.booking_date.setText(bookingData.getBooking_date());
        bookingData = bookingDataList.get(position);
        String d[]=bookingData.getReporting_date().split(" ");

        try {
            SimpleDateFormat newformat = new SimpleDateFormat("dd/MM/yyyy");
            String datestring = bookingData.getReporting_date().split(" ")[0];
            SimpleDateFormat oldformat = new SimpleDateFormat("MM/dd/yyyy");
            String reformattedStr = newformat.format(oldformat.parse(datestring));

//            DecimalFormat formatter=new DecimalFormat("00.00");
//            String aFormatter=formatter.format(bookingData.getReporting_date());

            holder.reporting_date.setText(reformattedStr);
            holder.booking_date.setText(reformattedStr);
        }catch(ParseException e){e.printStackTrace();}


       // holder.reporting_date.setText(d[0]);
        holder.reporting_time.setText(bookingData.getReporting_time());
        holder.guest_name.setText(bookingData.getGuest_name());
        holder.vehicle_type.setText(bookingData.getVehicle_name());
        holder.ref_number.setText(bookingData.getBookingId());
       // holder.booking_date.setText(bookingData.getBookingDate());

        holder.rlLayout.setTag(bookingData.getBookingId());
    }

    @Override
    public int getItemCount() {
        return bookingDataList.size();
    }

    public static interface AdapterCallback {
        void onMethodCallback(String bookingId);
    }

}
