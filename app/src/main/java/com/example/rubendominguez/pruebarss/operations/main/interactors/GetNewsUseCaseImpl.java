package com.example.rubendominguez.pruebarss.operations.main.interactors;

import com.example.rubendominguez.pruebarss.data.datastore.RetrofitNewsDataStore;


public class GetNewsUseCaseImpl implements GetNewsUseCase {

    private RetrofitNewsDataStore retrofitHeroesDataStore;


    public GetNewsUseCaseImpl() {
        retrofitHeroesDataStore = new RetrofitNewsDataStore();
    }

    @Override
    public void execute(Callback callback) {
        retrofitHeroesDataStore.getNews(callback);

    }
}
