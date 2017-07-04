package com.example.rubendominguez.pruebarss.operations.detail.presenters;

import android.os.Bundle;

import com.example.rubendominguez.pruebarss.data.model.domain.NewDomain;
import com.example.rubendominguez.pruebarss.general.Constants;
import com.example.rubendominguez.pruebarss.operations.detail.views.DetailActivityView;
import com.example.rubendominguez.pruebarss.operations.detail.views.DetailNewActivityPresenter;

/**
 * Created by rubendominguez on 3/7/17.
 */

public class DetailNewActivityPresenterImpl implements DetailNewActivityPresenter {

    private DetailActivityView view;
    private Bundle bundle;
    private NewDomain newDomain;

    public DetailNewActivityPresenterImpl(DetailActivityView view, Bundle bundle) {
        this.view = view;
        this.bundle = bundle;
    }


    @Override
    public void init() {
        newDomain = (NewDomain)bundle.get(Constants.NEW_INFO_DATA);
        view.setTitle();
        view.loadFragment(newDomain);

    }
}
