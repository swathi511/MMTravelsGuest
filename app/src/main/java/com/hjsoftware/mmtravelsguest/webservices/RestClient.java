package com.hjsoftware.mmtravelsguest.webservices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hjsoftware on 22/12/17.
 */

public class RestClient {
    private static String BASE_URL="http://192.168.1.9:1522/api/";
    private static API REST_CLIENT;
    //http://192.168.1.9:1522/api/
    //http://183.82.147.129:1353/api/
    static {
        setupRestClient();
    }

    public static API get() {
        return REST_CLIENT;
    }

    private static void setupRestClient(){

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        REST_CLIENT=retrofit.create(API.class);
    }
}
