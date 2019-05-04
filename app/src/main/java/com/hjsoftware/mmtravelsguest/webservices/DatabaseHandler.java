package com.hjsoftware.mmtravelsguest.webservices;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hjsoftware on 26/12/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DbAdapter.TABLE_GUEST);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {



        onCreate(sqLiteDatabase);


    }
}
