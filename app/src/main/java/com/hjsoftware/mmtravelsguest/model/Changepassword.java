package com.hjsoftware.mmtravelsguest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hjsoftware on 3/1/18.
 */

public class Changepassword {

    @SerializedName("customerid")
    @Expose
    private String customerid;
    @SerializedName("pwd")
    @Expose
    private String pwd;

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
