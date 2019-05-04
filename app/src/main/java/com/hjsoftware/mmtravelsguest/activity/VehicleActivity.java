package com.hjsoftware.mmtravelsguest.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.hjsoftware.mmtravelsguest.R;
import com.hjsoftware.mmtravelsguest.SessionManager;
import com.hjsoftware.mmtravelsguest.model.LocationPojo;
import com.hjsoftware.mmtravelsguest.webservices.API;
import com.hjsoftware.mmtravelsguest.webservices.RestClient;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Callback;
import retrofit2.Response;

public class VehicleActivity extends AppCompatActivity {
     TextView textView;
     Spinner spinner;
     Button button;
     API REST_CLIENT;
     ArrayList<String> CustomerIds;
     ArrayList<String> mylist = new ArrayList<String>();
   // String[] vehicle_type={"- - - Select - - -","ALTIS--A/C","BMW 7 SERIES--A/C","Camry--A/C","DZIRE--A/C","ETIOS--A/C","HONDA ACCORD--A/C","Honda City--A/C","INDIGO--A/C","INNOVA--A/C","MANZA--A/C","SUNNY--A/C","VERITO--A/C"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        textView=(TextView)findViewById(R.id.text_view);

        button=(Button)findViewById(R.id.submit);
        REST_CLIENT= RestClient.get();



        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SessionManager s=new SessionManager(getApplicationContext());
                s.logoutUser();
                Intent l=new Intent(VehicleActivity.this,MainActivity.class);
                l.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                l.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(l);
                finish();
            }
        });





        spinner=(Spinner)findViewById(R.id.spinner_vehle);
        Bundle bundle =getIntent().getExtras();
        String custemorIds = bundle.getString("customerId",null);
        Log.i("ids",custemorIds);

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
                      loctData= locationstatus.get(i);


                       String LocationName = loctData.getLocation();


                       mylist.add(LocationName);

                        Log.i("HHHHHH","_____________@@@@@@@@@@@@@@@@@@@@@@@______________");
                       // List<String> itemList = new ArrayList<String>(Arrays.asList(items));

 //Log.i("data", vehicleName);
                   }

                       ArrayAdapter arrayAdapter2=new ArrayAdapter(VehicleActivity.this,android.R.layout.simple_spinner_item,mylist);
                       arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner.setAdapter(arrayAdapter2);

                       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                           @Override
                           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                               // Toast.makeText(MainActivity.this, "Selected Item is "
                               //       +vehicle_type[position], Toast.LENGTH_SHORT).show();


                           }

                           @Override
                           public void onNothingSelected(AdapterView<?> parent) {

                           }
                       });







                   //Log.i("Hello","----------@@@@@@@@#######$$$$$%%%%%--------");

               }
               else{

                   String vehiclee=response.message();
                   Log.i("this is vehicle data",vehiclee);
                   Toast.makeText(VehicleActivity.this, vehiclee, Toast.LENGTH_SHORT).show();
               }

            }

            @Override
            public void onFailure(retrofit2.Call<List<LocationPojo>> call, Throwable t) {

                Toast.makeText(VehicleActivity.this, "Internet Connection Error", Toast.LENGTH_SHORT).show();
            }
        });



    }

}
