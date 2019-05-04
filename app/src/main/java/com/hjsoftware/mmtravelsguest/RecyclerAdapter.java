package com.hjsoftware.mmtravelsguest;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.hjsoftware.mmtravelsguest.model.DutyData;
import com.hjsoftware.mmtravelsguest.webservices.API;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    ArrayList<DutyData> customArrayList;
    Context context;
    DutyData data;
    LayoutInflater inflater;
    boolean accept=false;
    API REST_CLIENT;
    Dialog dialog;
    private AdapterCallback mAdapterCallback;
    int pos;
    ArrayList<DutyData> mResultList;
    boolean status=false;

    public RecyclerAdapter(Context context, ArrayList<DutyData> customArrayList)
    {
        this.context=context;
        this.customArrayList=customArrayList;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        dialog=new Dialog(context);
        try {
            this.mAdapterCallback = ((AdapterCallback) context);
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement AdapterCallback.");
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        data=customArrayList.get(position);

        holder.tvDsno.setText(data.getDsno());
        holder.tvDsDate.setText(data.getDsdate());





    }

    @Override
    public int getItemCount() {
        return customArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvDsno,tvDsDate;
        RelativeLayout rLayout;

        public MyViewHolder(final View itemView) {
            super(itemView);

            tvDsno=(TextView)itemView.findViewById(R.id.rw_dsno);
            tvDsDate=(TextView)itemView.findViewById(R.id.rw_dsdate);

            rLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    try {
                        pos= (int) view.getTag();
                        mAdapterCallback.onMethodCallback(pos,mResultList);

                    }
                    catch (ClassCastException e)
                    {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static interface AdapterCallback {
        void onMethodCallback(int position, ArrayList<DutyData> data);
    }

}
