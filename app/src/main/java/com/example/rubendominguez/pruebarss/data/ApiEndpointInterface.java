package com.example.rubendominguez.pruebarss.data;

import com.example.rubendominguez.pruebarss.data.model.RSS;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpointInterface {
    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    @GET("/tag/nexus/rss2.xml")
    Call<RSS> getNews();

}