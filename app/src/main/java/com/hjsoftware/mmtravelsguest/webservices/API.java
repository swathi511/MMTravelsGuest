package com.hjsoftware.mmtravelsguest.webservices;

import com.hjsoftware.mmtravelsguest.model.Changepassword;
import com.hjsoftware.mmtravelsguest.model.DutyData;
import com.hjsoftware.mmtravelsguest.model.DutyDataPojo;
import com.hjsoftware.mmtravelsguest.model.GetBookingPojo;
import com.hjsoftware.mmtravelsguest.model.LocationPojo;
import com.hjsoftware.mmtravelsguest.model.LoginPojo;
import com.hjsoftware.mmtravelsguest.model.MessagePojo;
import com.hjsoftware.mmtravelsguest.model.SpecificBookingPojo;
import com.hjsoftware.mmtravelsguest.model.VehiclePojo;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by hjsoftware on 22/12/17.
 */

public interface API {
    @POST("Login/Checklogin")
    Call<List<LoginPojo>> validate(@Body JsonObject v);

    @GET("VehicleCat/GetVehicleCat")
    Call<List<VehiclePojo>> getInfo(@Query("customerid") String cid);

    @GET("Locations/GetLocations")
    Call<List<LocationPojo>> getInfoo(@Query("customerid") String cid);

    @POST("Booking/AddBooking")
    Call<MessagePojo> bookinginfo(@Body JsonObject v);

    @POST("ChangePassword/update")
    Call<Changepassword> passwordinfo(@Body JsonObject v);

    @GET("CustomerBookingsBydates/GetBookings")
    Call<List<GetBookingPojo>>getbookingdetails(@Query("customerid") String cid,
                                                @Query("profileid") String pid,
                                                @Query("fromdate") String fdate,
                                                @Query("todate") String tdate);

    @GET("GetBookingDetails/GetDetails")
    Call<List<SpecificBookingPojo>> getSpecificBooking(
            @Query("customerid") String customerId,
            @Query("bookingid") String bookingId,
            @Query("profileid") String profileid
    );

    @GET("DutySlipDetails/GetDetails")
    Call<List<DutyDataPojo>> getOngoingDSlipDetails(@Query("profileid") String profileId);



}
