package com.hjsoftware.mmtravelsguest.model;

public class DutyData {

    String dsno,dsdate,vehno,dname,dmobile,lat,lng;

    public DutyData(String dsno,String dsdate,String vehno,String dname,String dmobile,String lat,String lng)
    {
        this.dsno=dsno;
        this.dsdate=dsdate;
        this.vehno=vehno;
        this.dname=dname;
        this.dmobile=dmobile;
        this.lat=lat;
        this.lng=lng;
    }

    public String getDsno() {
        return dsno;
    }

    public void setDsno(String dsno) {
        this.dsno = dsno;
    }

    public String getDsdate() {
        return dsdate;
    }

    public void setDsdate(String dsdate) {
        this.dsdate = dsdate;
    }

    public String getVehno() {
        return vehno;
    }

    public void setVehno(String vehno) {
        this.vehno = vehno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDmobile() {
        return dmobile;
    }

    public void setDmobile(String dmobile) {
        this.dmobile = dmobile;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
