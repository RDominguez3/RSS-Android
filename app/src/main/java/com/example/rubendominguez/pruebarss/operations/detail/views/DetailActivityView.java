package com.example.rubendominguez.pruebarss.operations.detail.views;

import com.example.rubendominguez.pruebarss.data.model.domain.NewDomain;

/**
 * Created by rubendominguez on 3/7/17.
 */

public interface DetailActivityView {

    void setTitle();
    void loadFragment(NewDomain newDomain);
}
