package com.hjsoftware.mmtravelsguest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DutyDataPojo {

    @SerializedName("dutyslipnumber")
    @Expose
    private String dutyslipnumber;
    @SerializedName("dsdate")
    @Expose
    private String dsdate;
    @SerializedName("vehiclenumber")
    @Expose
    private String vehiclenumber;
    @SerializedName("drivername")
    @Expose
    private String drivername;
    @SerializedName("drivermobile")
    @Expose
    private String drivermobile;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("latitude")
    @Expose
    private String latitude;

    public String getDutyslipnumber() {
        return dutyslipnumber;
    }

    public void setDutyslipnumber(String dutyslipnumber) {
        this.dutyslipnumber = dutyslipnumber;
    }

    public String getDsdate() {
        return dsdate;
    }

    public void setDsdate(String dsdate) {
        this.dsdate = dsdate;
    }

    public String getVehiclenumber() {
        return vehiclenumber;
    }

    public void setVehiclenumber(String vehiclenumber) {
        this.vehiclenumber = vehiclenumber;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public String getDrivermobile() {
        return drivermobile;
    }

    public void setDrivermobile(String drivermobile) {
        this.drivermobile = drivermobile;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

}