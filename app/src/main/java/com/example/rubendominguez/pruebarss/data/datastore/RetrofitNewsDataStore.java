package com.example.rubendominguez.pruebarss.data.datastore;

import com.example.rubendominguez.pruebarss.data.ApiEndpointInterface;
import com.example.rubendominguez.pruebarss.data.model.RSS;
import com.example.rubendominguez.pruebarss.general.PruebaRSS;
import com.example.rubendominguez.pruebarss.operations.main.interactors.GetNewsUseCase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitNewsDataStore {

    private ApiEndpointInterface apiEndpointInterface;

    public RetrofitNewsDataStore() {
        this.apiEndpointInterface = PruebaRSS.getRestClient().create(ApiEndpointInterface.class);
    }

    public void getNews(final GetNewsUseCase.Callback callback){
        Call<RSS> call = apiEndpointInterface.getNews();
        call.enqueue(new Callback<RSS>() {
            @Override
            public void onResponse(Call<RSS> call, Response<RSS> response) {
                callback.onNewsReceived(response.body());
            }

            @Override
            public void onFailure(Call<RSS> call, Throwable t) {
                callback.onErrorReceived();
            }
        });
    }
}
