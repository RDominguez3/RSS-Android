package com.example.rubendominguez.pruebarss.operations.main.views;

import android.content.Context;

import com.example.rubendominguez.pruebarss.data.model.domain.NewDomain;

import java.util.ArrayList;

public interface MainFragmentView {

    void initValues();
    void updateAdapter(ArrayList<NewDomain> domains);
    void hideMessage();
    void hideList();
    void showMessage();
    void showList();

    Context getContextData();
}
