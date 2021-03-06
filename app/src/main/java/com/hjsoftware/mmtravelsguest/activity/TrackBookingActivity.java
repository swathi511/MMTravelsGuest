package com.hjsoftware.mmtravelsguest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.hjsoftware.mmtravelsguest.DrawerItemCustomAdapter;
import com.hjsoftware.mmtravelsguest.NavigationData;
import com.hjsoftware.mmtravelsguest.R;
import com.hjsoftware.mmtravelsguest.RecyclerAdapter;
import com.hjsoftware.mmtravelsguest.SessionManager;
import com.hjsoftware.mmtravelsguest.fragments.BookinglistFragment;
import com.hjsoftware.mmtravelsguest.fragments.TrackBookingFragment;
import com.hjsoftware.mmtravelsguest.model.DutyData;

import java.util.ArrayList;

public class TrackBookingActivity extends AppCompatActivity implements RecyclerAdapter.AdapterCallback{
    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    DrawerItemCustomAdapter adapter;
    final static int REQUEST_LOCATION = 199;
    String bookingId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        setupToolbar();

        NavigationData[] drawerItem = new NavigationData[4];

        drawerItem[0] = new NavigationData(R.drawable.arrow, "New Booking");
        drawerItem[1] = new NavigationData(R.drawable.arrow, "All Bookings");
        drawerItem[2] = new NavigationData(R.drawable.arrow,"Change Password");
        drawerItem[3] = new NavigationData(R.drawable.arrow,"Logout");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new TrackBookingActivity.DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        setupDrawerToggle();

        Fragment fragment=new TrackBookingFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.content_frame, fragment,"Booking List").commit();
        setTitle("Track your Booking");
        adapter.setSelectedItem(2);
    }

    @Override
    public void onMethodCallback(int position, ArrayList<DutyData> data) {

        ArrayList<DutyData> d=data;
        DutyData dd;

        dd=d.get(position);

        Intent i=new Intent(TrackBookingActivity.this,MapTrackingActivity.class);
        i.putExtra("position", position);
        i.putExtra("list", data);

        startActivity(i);

    }


    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {

        Fragment fragment = null;
        adapter.setSelectedItem(position);

        switch (position) {
            case 0:
                Intent k=new Intent(TrackBookingActivity.this,HomeActivity.class);
                k.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                k.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(k);
                finish();

                break;
            case 1:
                Intent i=new Intent(TrackBookingActivity.this,TrackBookingActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();

                break;

            case 2:
                Intent j=new Intent(TrackBookingActivity.this,ChangepasswordActivity.class);
                j.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                j.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(j);
                finish();

                break;
            case 3:

                SessionManager s=new SessionManager(getApplicationContext());
                s.logoutUser();
                Intent l=new Intent(this,MainActivity.class);
                l.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                l.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(l);
                finish();
                break;

            case 5:

                break;

            default:
                break;
        }

        if (fragment != null) {

            openFragment(fragment,position);

        } else {
            // Log.e("MainActivity", "Error in creating fragment");
        }
    }

    private void openFragment(Fragment fragment,int position){

        Fragment containerFragment = getSupportFragmentManager().findFragmentById(R.id.content_frame);

        if (containerFragment.getClass().getName().equalsIgnoreCase(fragment.getClass().getName())) {
            mDrawerLayout.closeDrawer(mDrawerList);
            return;
        }

        else{
            /*
           FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            */
            mDrawerLayout.closeDrawer(mDrawerList);

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        /*
        int titleId = getResources().getIdentifier("toolbar", "id", "android");
        TextView abTitle = (TextView) findViewById(titleId);
        abTitle.setTextColor(Color.parseColor("#000000"));*/
    }

    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }







    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case REQUEST_LOCATION:

                switch (resultCode) {
                    case Activity.RESULT_OK: {
                        // All required changes were successfully made
                        Toast.makeText(TrackBookingActivity.this, "Please wait.. Getting Location!", Toast.LENGTH_LONG).show();
                       /* if(sbMsg!=null) {
                            sbMsg.dismiss();
                        }*/
                        break;
                    }
                    case Activity.RESULT_CANCELED: {
                        Toast.makeText(TrackBookingActivity.this, "GPS should be enabled for the app to run!", Toast.LENGTH_LONG).show();
                        finish();
                        break;
                    }
                    default: {
                        break;
                    }
                }
                break;
        }
    }

}

