package com.hjsoftware.mmtravelsguest.webservices;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hjsoftware on 26/12/17.
 */

public class DbAdapter {

    static final String DATABASE_NAME="user.db";
    static final  int DATABASE_VERSION=1;

    public  static final String TABLE_GUEST="create table if not exits"+"GUEST_DETAILS"+"("+"SNO  text,GUEST_NAME text,GUEST_MOBILE text,GUEST_EMAIL text,DRIVER_NAME text,DRIVER_MOBILE text,DRIVER_EMAIL text);";


    public SQLiteDatabase db;

    private DatabaseHandler dbHelper;
    private final Context context;
    public  DbAdapter(Context _context){

        context = _context;
        dbHelper = new DatabaseHandler(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public  DbAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        db.close();
    }

    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }
    public long insertEntry(String sno,String guestName,String guestMoble,String guestEmail,String driverName,String driverMoble,String driverEmail){
        db=dbHelper.getWritableDatabase();
        ContentValues newValues = new ContentValues();

        newValues.put("SNO",sno);
        newValues.put("GUEST_NAME",guestName);
        newValues.put("GUEST_MOBILE",guestMoble);
        newValues.put("GUEST_EMAIL",guestEmail);
        newValues.put("DRIVER_NAME",driverName);
        newValues.put("DRIVER_MOBILE",driverMoble);
        newValues.put("DRIVER_EMAIL",driverEmail);

        long value=db.insert("GUEST_DETAILS", null, newValues);

        return value;
    }

    public String getTodaysValues()
    {
        String st="";
        db=dbHelper.getReadableDatabase();
        String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
        //System.out.println("Todays date is "+today);
        String sql="SELECT * FROM LATLNG_DETAILS "+"WHERE strftime('%Y%m%d',TIME_UPDATED)= '"+today+"' ";
        Cursor cursor=db.rawQuery(sql,null);
        JSONObject jobj ;
        JSONArray arr = new JSONArray();

        while(cursor.moveToNext()) {
            try {
                jobj = new JSONObject();
                jobj.put("Sno",cursor.getString(0));
                jobj.put("Guest_Name", cursor.getString(1));
                jobj.put("Guest_Mobile", cursor.getString(2));
                jobj.put("Guest_Email",cursor.getString(3));
                jobj.put("Driver_Name",cursor.getString(4));
                jobj.put("Driver_Mobile", cursor.getString(5));
                jobj.put("Driver_Email", cursor.getString(6));
                arr.put(jobj);
            }
            catch (JSONException e){e.printStackTrace();}
        }
        try{
            jobj = new JSONObject();
            jobj.put("data", arr);
            st=jobj.toString();
        }catch(JSONException e){e.printStackTrace();}

        return st;
    }
    public void deleteAll(String sno)
    {
        db=dbHelper.getReadableDatabase();
        db.execSQL("delete from GUEST_DETAILS WHERE SNO ="+" '"+sno+"' ");

    }

}


