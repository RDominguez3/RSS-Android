package com.example.rubendominguez.pruebarss.operations.detail.presenters;

import android.os.Bundle;

import com.example.rubendominguez.pruebarss.data.model.domain.NewDomain;
import com.example.rubendominguez.pruebarss.general.Constants;
import com.example.rubendominguez.pruebarss.operations.detail.views.DetailNewFragmentPresenter;
import com.example.rubendominguez.pruebarss.operations.detail.views.DetailNewFragmentView;

/**
 * Created by rubendominguez on 3/7/17.
 */

public class DetailNewFragmentPresenterImpl implements DetailNewFragmentPresenter {

    private DetailNewFragmentView view;
    private Bundle bundle;
    private NewDomain newDomain;

    public DetailNewFragmentPresenterImpl(DetailNewFragmentView view, Bundle bundle) {
        this.view = view;
        this.bundle = bundle;
    }

    @Override
    public void init() {
        newDomain = (NewDomain)bundle.get(Constants.NEW_INFO_DATA);
        view.setAuthorDetail(newDomain.getAuthor());
        view.setDateDetail(newDomain.getDate());
        view.setDescriptionDetail(newDomain.getDescriptionUnformatted());
        view.setPhotoDetail(newDomain.getUrlImage());
        view.setTitelDetail(newDomain.getTitle());
    }

    @Override
    public void openBrowser() {
        view.setButtonLinkDetail(newDomain.getUrlNew());
    }
}
