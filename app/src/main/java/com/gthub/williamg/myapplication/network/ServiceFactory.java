package com.gthub.williamg.myapplication.network;

import com.gthub.williamg.myapplication.restservice.ApiService;
import com.gthub.williamg.myapplication.restservice.OpenFireApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class ServiceFactory {
    private static final String BASE_URL = "https://api.cloud.wowza.com/api/v1/";
    public static final String STREAM_ID = "c9jf5cdq";

    public static ApiService createAPiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(WowzaInterceptor.buildHttpClient())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        return apiService;

    }

    public static OpenFireApiService createOpenFireAPIService(String baseUrl){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(OpenFireInterceptor.buildHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        OpenFireApiService apiService = retrofit.create(OpenFireApiService.class);

        return apiService;

    }
}