package com.example.rubendominguez.pruebarss.operations.main.views;


import android.view.View;

import com.example.rubendominguez.pruebarss.data.model.domain.NewDomain;


public interface MainFragmentPresenter {

    void init();
    void clickNew(NewDomain newDomain, View view);
    void searchNews(String value);
}
