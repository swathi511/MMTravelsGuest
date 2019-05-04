package com.hjsoftware.mmtravelsguest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hjsoftware on 6/1/18.
 */

public class GetBookingPojo{


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
    @SerializedName("guestsmsstatus")
    @Expose
    private String guestsmsstatus;
    @SerializedName("guestsms")
    @Expose
    private String guestsms;
    @SerializedName("emailsendstatus")
    @Expose
    private String emailsendstatus;
    @SerializedName("emailidsend")
    @Expose
    private String emailidsend;
    @SerializedName("empno")
    @Expose
    private String empno;
    @SerializedName("refno")
    @Expose
    private Integer refno;
    @SerializedName("ftinfo")
    @Expose
    private String ftinfo;
    @SerializedName("advrec")
    @Expose
    private Integer advrec;
    @SerializedName("sno")
    @Expose
    private Integer sno;
    @SerializedName("remindertime")
    @Expose
    private String remindertime;
    @SerializedName("noofveh")
    @Expose
    private Integer noofveh;
    @SerializedName("custrefno")
    @Expose
    private String custrefno;
    @SerializedName("tripno")
    @Expose
    private String tripno;
    @SerializedName("confirmationno")
    @Expose
    private String confirmationno;
    @SerializedName("totkms1new")
    @Expose
    private Integer totkms1new;
    @SerializedName("tothrs1new")
    @Expose
    private Integer tothrs1new;
    @SerializedName("hrscrt1new")
    @Expose
    private String hrscrt1new;
    @SerializedName("nofdays1new")
    @Expose
    private Integer nofdays1new;
    @SerializedName("criteria")
    @Expose
    private String criteria;
    @SerializedName("bktype")
    @Expose
    private String bktype;
    @SerializedName("crtype")
    @Expose
    private String crtype;
    @SerializedName("crno")
    @Expose
    private String crno;
    @SerializedName("guide")
    @Expose
    private String guide;
    @SerializedName("instructions")
    @Expose
    private String instructions;
    @SerializedName("sourcetype")
    @Expose
    private String sourcetype;
    @SerializedName("sourcedet")
    @Expose
    private String sourcedet;
    @SerializedName("docname")
    @Expose
    private String docname;
    @SerializedName("stime")
    @Expose
    private Double stime;
    @SerializedName("transfer")
    @Expose
    private String transfer;
    @SerializedName("creditmnth")
    @Expose
    private String creditmnth;
    @SerializedName("credityear")
    @Expose
    private String credityear;
    @SerializedName("garagestatus")
    @Expose
    private String garagestatus;
    @SerializedName("bookerprefix")
    @Expose
    private String bookerprefix;
    @SerializedName("guestprefix")
    @Expose
    private String guestprefix;
    @SerializedName("pref")
    @Expose
    private String pref;
    @SerializedName("vendorallotstatus")
    @Expose
    private String vendorallotstatus;
    @SerializedName("vendorid")
    @Expose
    private String vendorid;
    @SerializedName("mtariffsno")
    @Expose
    private Integer mtariffsno;
    @SerializedName("routename")
    @Expose
    private String routename;
    @SerializedName("pointtopoint")
    @Expose
    private String pointtopoint;
    @SerializedName("approvalstatus")
    @Expose
    private String approvalstatus;

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

    public String getGuestsmsstatus() {
        return guestsmsstatus;
    }

    public void setGuestsmsstatus(String guestsmsstatus) {
        this.guestsmsstatus = guestsmsstatus;
    }

    public String getGuestsms() {
        return guestsms;
    }

    public void setGuestsms(String guestsms) {
        this.guestsms = guestsms;
    }

    public String getEmailsendstatus() {
        return emailsendstatus;
    }

    public void setEmailsendstatus(String emailsendstatus) {
        this.emailsendstatus = emailsendstatus;
    }

    public String getEmailidsend() {
        return emailidsend;
    }

    public void setEmailidsend(String emailidsend) {
        this.emailidsend = emailidsend;
    }

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public Integer getRefno() {
        return refno;
    }

    public void setRefno(Integer refno) {
        this.refno = refno;
    }

    public String getFtinfo() {
        return ftinfo;
    }

    public void setFtinfo(String ftinfo) {
        this.ftinfo = ftinfo;
    }

    public Integer getAdvrec() {
        return advrec;
    }

    public void setAdvrec(Integer advrec) {
        this.advrec = advrec;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getRemindertime() {
        return remindertime;
    }

    public void setRemindertime(String remindertime) {
        this.remindertime = remindertime;
    }

    public Integer getNoofveh() {
        return noofveh;
    }

    public void setNoofveh(Integer noofveh) {
        this.noofveh = noofveh;
    }

    public String getCustrefno() {
        return custrefno;
    }

    public void setCustrefno(String custrefno) {
        this.custrefno = custrefno;
    }

    public String getTripno() {
        return tripno;
    }

    public void setTripno(String tripno) {
        this.tripno = tripno;
    }

    public String getConfirmationno() {
        return confirmationno;
    }

    public void setConfirmationno(String confirmationno) {
        this.confirmationno = confirmationno;
    }

    public Integer getTotkms1new() {
        return totkms1new;
    }

    public void setTotkms1new(Integer totkms1new) {
        this.totkms1new = totkms1new;
    }

    public Integer getTothrs1new() {
        return tothrs1new;
    }

    public void setTothrs1new(Integer tothrs1new) {
        this.tothrs1new = tothrs1new;
    }

    public String getHrscrt1new() {
        return hrscrt1new;
    }

    public void setHrscrt1new(String hrscrt1new) {
        this.hrscrt1new = hrscrt1new;
    }

    public Integer getNofdays1new() {
        return nofdays1new;
    }

    public void setNofdays1new(Integer nofdays1new) {
        this.nofdays1new = nofdays1new;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public String getBktype() {
        return bktype;
    }

    public void setBktype(String bktype) {
        this.bktype = bktype;
    }

    public String getCrtype() {
        return crtype;
    }

    public void setCrtype(String crtype) {
        this.crtype = crtype;
    }

    public String getCrno() {
        return crno;
    }

    public void setCrno(String crno) {
        this.crno = crno;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getSourcetype() {
        return sourcetype;
    }

    public void setSourcetype(String sourcetype) {
        this.sourcetype = sourcetype;
    }

    public String getSourcedet() {
        return sourcedet;
    }

    public void setSourcedet(String sourcedet) {
        this.sourcedet = sourcedet;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public Double getStime() {
        return stime;
    }

    public void setStime(Double stime) {
        this.stime = stime;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public String getCreditmnth() {
        return creditmnth;
    }

    public void setCreditmnth(String creditmnth) {
        this.creditmnth = creditmnth;
    }

    public String getCredityear() {
        return credityear;
    }

    public void setCredityear(String credityear) {
        this.credityear = credityear;
    }

    public String getGaragestatus() {
        return garagestatus;
    }

    public void setGaragestatus(String garagestatus) {
        this.garagestatus = garagestatus;
    }

    public String getBookerprefix() {
        return bookerprefix;
    }

    public void setBookerprefix(String bookerprefix) {
        this.bookerprefix = bookerprefix;
    }

    public String getGuestprefix() {
        return guestprefix;
    }

    public void setGuestprefix(String guestprefix) {
        this.guestprefix = guestprefix;
    }

    public String getPref() {
        return pref;
    }

    public void setPref(String pref) {
        this.pref = pref;
    }

    public String getVendorallotstatus() {
        return vendorallotstatus;
    }

    public void setVendorallotstatus(String vendorallotstatus) {
        this.vendorallotstatus = vendorallotstatus;
    }

    public String getVendorid() {
        return vendorid;
    }

    public void setVendorid(String vendorid) {
        this.vendorid = vendorid;
    }

    public Integer getMtariffsno() {
        return mtariffsno;
    }

    public void setMtariffsno(Integer mtariffsno) {
        this.mtariffsno = mtariffsno;
    }

    public String getRoutename() {
        return routename;
    }

    public void setRoutename(String routename) {
        this.routename = routename;
    }

    public String getPointtopoint() {
        return pointtopoint;
    }

    public void setPointtopoint(String pointtopoint) {
        this.pointtopoint = pointtopoint;
    }

    public String getApprovalstatus() {
        return approvalstatus;
    }

    public void setApprovalstatus(String approvalstatus) {
        this.approvalstatus = approvalstatus;
    }


}
