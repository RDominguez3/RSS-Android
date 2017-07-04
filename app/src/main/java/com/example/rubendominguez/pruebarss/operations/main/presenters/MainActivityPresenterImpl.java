package com.example.rubendominguez.pruebarss.operations.main.presenters;


import com.example.rubendominguez.pruebarss.operations.main.views.MainActivityPresenter;
import com.example.rubendominguez.pruebarss.operations.main.views.MainActivityView;


public class MainActivityPresenterImpl implements MainActivityPresenter {

    private MainActivityView view;

    public MainActivityPresenterImpl(MainActivityView mainActivityView) {

        this.view = mainActivityView;
    }


    @Override
    public void init() {
        view.setTitle();
        view.loadFragment();
    }
}
