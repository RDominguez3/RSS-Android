package com.example.rubendominguez.pruebarss.general;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.SimpleXmlConverterFactory;


/**
 * Created by rubendominguez on 2/7/17.
 */

public class PruebaRSS extends Application {

    private static Retrofit restClient;

    public static Retrofit getRestClient() {

        restClient = new Retrofit.Builder()
                .baseUrl("http://www.xatakandroid.com")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        return restClient;
    }
}
