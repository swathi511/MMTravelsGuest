package com.hjsoftware.mmtravelsguest.activity;

import java.io.Serializable;

/**
 * Created by hjsoftware on 6/1/18.
 */

public class BookingData implements Serializable{

    private  String bookingId,bookingDate,bookingTime,reporting_date,reporting_time,guest_name,vehicle_name;

    public BookingData(String bookingId,String bookingDate,String bookingTime,String bookingDataVehicletype, String guestname, String reportdate, String reporttime){

        this.bookingId=bookingId;
        this.bookingDate=bookingDate;
        this.bookingTime=bookingTime;
        this.reporting_date=reportdate;
        this.reporting_time=reporttime;
        this.guest_name=guestname;
        this.vehicle_name=bookingDataVehicletype;
    }
    public String getReporting_date() {
        return reporting_date;
    }

    public void setReporting_date(String reporting_date) {
        this.reporting_date = reporting_date;
    }
    public String getReporting_time() {
        return reporting_time;
    }

    public void setReporting_time(String reporting_time) {
        this.reporting_time = reporting_time;
    }
    public String getGuest_name() {
        return guest_name;
    }

    public void setGuest_name(String guest_name) {
        this.guest_name = guest_name;
    }
    public String getVehicle_name() {
        return vehicle_name;
    }

    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }
}
