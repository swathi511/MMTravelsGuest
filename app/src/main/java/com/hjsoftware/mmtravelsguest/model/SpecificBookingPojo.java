package com.hjsoftware.mmtravelsguest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hjsoftware on 8/1/18.
 */

public class SpecificBookingPojo {


    @SerializedName("bookingid")
    @Expose
    private String bookingid;
    @SerializedName("creationdate")
    @Expose
    private String creationdate;
    @SerializedName("creationtime")
    @Expose
    private String creationtime;
    @SerializedName("branchid")
    @Expose
    private String branchid;
    @SerializedName("vehiclecategory")
    @Expose
    private String vehiclecategory;
    @SerializedName("vehicletype")
    @Expose
    private String vehicletype;
    @SerializedName("bookingtype")
    @Expose
    private String bookingtype;
    @SerializedName("tariffcategory")
    @Expose
    private String tariffcategory;
    @SerializedName("traveltype")
    @Expose
    private String traveltype;
    @SerializedName("bookedby")
    @Expose
    private String bookedby;
    @SerializedName("bookedbymobile")
    @Expose
    private String bookedbymobile;
    @SerializedName("reportdate")
    @Expose
    private String reportdate;
    @SerializedName("reporttime")
    @Expose
    private String reporttime;
    @SerializedName("guestname")
    @Expose
    private String guestname;
    @SerializedName("guestmobileno")
    @Expose
    private String guestmobileno;
    @SerializedName("guestemail")
    @Expose
    private String guestemail;
    @SerializedName("pickupfrom")
    @Expose
    private String pickupfrom;
    @SerializedName("preparedby")
    @Expose
    private String preparedby;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("NoOfDays")
    @Expose
    private String noOfDays;
    @SerializedName("routesno")
    @Expose
    private String routesno;
    @SerializedName("bbemail")
    @Expose
    private String bbemail;
    @SerializedName("OutStationName")
    @Expose
    private String outStationName;
    @SerializedName("pickuploc")
    @Expose
    private Object pickuploc;
    @SerializedName("otherplace")
    @Expose
    private String otherplace;
    @SerializedName("Spinstruct")
    @Expose
    private String spinstruct;
    @SerializedName("CostCode")
    @Expose
    private String costCode;
    @SerializedName("dropat")
    @Expose
    private String dropat;
    @SerializedName("bookedbysmsstatus")
    @Expose
    private String bookedbysmsstatus;
    @SerializedName("bookedbysms")
    @Expose
    private String bookedbysms;
    @SerializedName("bbemailstatus")
    @Expose
    private String bbemailstatus;
    @SerializedName("bbemailidsend")
    @Expose
    private String bbemailidsend;
    @SerializedName("approvalstatus")
    @Expose
    private String approvalstatus;
    @SerializedName("ftinfo")
    @Expose
    private String ftInfo;

    public String getBookingid() {
        return bookingid;
    }

    public void setBookingid(String bookingid) {
        this.bookingid = bookingid;
    }

    public String getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
    }

    public String getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(String creationtime) {
        this.creationtime = creationtime;
    }

    public String getBranchid() {
        return branchid;
    }

    public void setBranchid(String branchid) {
        this.branchid = branchid;
    }

    public String getVehiclecategory() {
        return vehiclecategory;
    }

    public void setVehiclecategory(String vehiclecategory) {
        this.vehiclecategory = vehiclecategory;
    }

    public String getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(String vehicletype) {
        this.vehicletype = vehicletype;
    }

    public String getBookingtype() {
        return bookingtype;
    }

    public void setBookingtype(String bookingtype) {
        this.bookingtype = bookingtype;
    }

    public String getTariffcategory() {
        return tariffcategory;
    }

    public void setTariffcategory(String tariffcategory) {
        this.tariffcategory = tariffcategory;
    }

    public String getTraveltype() {
        return traveltype;
    }

    public void setTraveltype(String traveltype) {
        this.traveltype = traveltype;
    }

    public String getBookedby() {
        return bookedby;
    }

    public void setBookedby(String bookedby) {
        this.bookedby = bookedby;
    }

    public String getBookedbymobile() {
        return bookedbymobile;
    }

    public void setBookedbymobile(String bookedbymobile) {
        this.bookedbymobile = bookedbymobile;
    }

    public String getReportdate() {
        return reportdate;
    }

    public void setReportdate(String reportdate) {
        this.reportdate = reportdate;
    }

    public String getReporttime() {
        return reporttime;
    }

    public void setReporttime(String reporttime) {
        this.reporttime = reporttime;
    }

    public String getGuestname() {
        return guestname;
    }

    public void setGuestname(String guestname) {
        this.guestname = guestname;
    }

    public String getGuestmobileno() {
        return guestmobileno;
    }

    public void setGuestmobileno(String guestmobileno) {
        this.guestmobileno = guestmobileno;
    }

    public String getGuestemail() {
        return guestemail;
    }

    public void setGuestemail(String guestemail) {
        this.guestemail = guestemail;
    }

    public String getPickupfrom() {
        return pickupfrom;
    }

    public void setPickupfrom(String pickupfrom) {
        this.pickupfrom = pickupfrom;
    }

    public String getPreparedby() {
        return preparedby;
    }

    public void setPreparedby(String preparedby) {
        this.preparedby = preparedby;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(String noOfDays) {
        this.noOfDays = noOfDays;
    }

    public String getRoutesno() {
        return routesno;
    }

    public void setRoutesno(String routesno) {
        this.routesno = routesno;
    }

    public String getBbemail() {
        return bbemail;
    }

    public void setBbemail(String bbemail) {
        this.bbemail = bbemail;
    }

    public String getOutStationName() {
        return outStationName;
    }

    public void setOutStationName(String outStationName) {
        this.outStationName = outStationName;
    }

    public Object getPickuploc() {
        return pickuploc;
    }

    public void setPickuploc(Object pickuploc) {
        this.pickuploc = pickuploc;
    }

    public String getOtherplace() {
        return otherplace;
    }

    public void setOtherplace(String otherplace) {
        this.otherplace = otherplace;
    }

    public String getSpinstruct() {
        return spinstruct;
    }

    public void setSpinstruct(String spinstruct) {
        this.spinstruct = spinstruct;
    }

    public String getCostCode() {
        return costCode;
    }

    public void setCostCode(String costCode) {
        this.costCode = costCode;
    }

    public String getDropat() {
        return dropat;
    }

    public void setDropat(String dropat) {
        this.dropat = dropat;
    }

    public String getBookedbysmsstatus() {
        return bookedbysmsstatus;
    }

    public void setBookedbysmsstatus(String bookedbysmsstatus) {
        this.bookedbysmsstatus = bookedbysmsstatus;
    }

    public String getBookedbysms() {
        return bookedbysms;
    }

    public void setBookedbysms(String bookedbysms) {
        this.bookedbysms = bookedbysms;
    }

    public String getBbemailstatus() {
        return bbemailstatus;
    }

    public void setBbemailstatus(String bbemailstatus) {
        this.bbemailstatus = bbemailstatus;
    }

    public String getBbemailidsend() {
        return bbemailidsend;
    }

    public void setBbemailidsend(String bbemailidsend) {
        this.bbemailidsend = bbemailidsend;
    }

    public String getApprovalstatus() {
        return approvalstatus;
    }

    public void setApprovalstatus(String approvalstatus) {
        this.approvalstatus = approvalstatus;
    }


    public String getFtInfo() {
        return ftInfo;
    }

    public void setFtInfo(String ftInfo) {
        this.ftInfo = ftInfo;
    }

}