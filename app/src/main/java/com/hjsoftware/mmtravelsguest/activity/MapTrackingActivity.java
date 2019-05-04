package com.hjsoftware.mmtravelsguest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.hjsoftware.mmtravelsguest.R;
import com.hjsoftware.mmtravelsguest.model.DutyData;

import java.util.ArrayList;

public class MapTrackingActivity extends AppCompatActivity implements OnMapReadyCallback {

    int position;
    DutyData data;
    ArrayList<DutyData> myList;
    SupportMapFragment mapFragment;
    GoogleMap mMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_map_tracking);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);





        Bundle d=getIntent().getExtras();
        position = d.getInt("position");


        myList = (ArrayList<DutyData>) getIntent().getSerializableExtra("list");
        data=myList.get(position);




    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        LatLng ll=new LatLng(Double.parseDouble(data.getLat()),Double.parseDouble(data.getLng()));



    }
}
