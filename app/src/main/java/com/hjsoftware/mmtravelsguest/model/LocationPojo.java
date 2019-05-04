package com.hjsoftware.mmtravelsguest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hjsoftware on 27/12/17.
 */

public class LocationPojo {
    @SerializedName("locationid")
    @Expose
    private String locationid;
    @SerializedName("location")
    @Expose
    private String location;

    public String getLocationid() {
        return locationid;
    }

    public void setLocationid(String locationid) {
        this.locationid = locationid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
