package com.hjsoftware.mmtravelsguest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hjsoftware on 22/12/17.
 */

public class VehiclePojo {

    @SerializedName("vehcatgoryid")
    @Expose
    private String vehcatgoryid;
    @SerializedName("vehcategory")
    @Expose
    private String vehcategory;

    public String getVehcatgoryid() {
        return vehcatgoryid;
    }

    public void setVehcatgoryid(String vehcatgoryid) {
        this.vehcatgoryid = vehcatgoryid;
    }

    public String getVehcategory() {
        return vehcategory;
    }

    public void setVehcategory(String vehcategory) {
        this.vehcategory = vehcategory;
    }

}