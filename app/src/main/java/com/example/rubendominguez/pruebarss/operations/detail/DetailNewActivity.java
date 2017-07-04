package com.example.rubendominguez.pruebarss.operations.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.rubendominguez.pruebarss.R;
import com.example.rubendominguez.pruebarss.data.model.domain.NewDomain;
import com.example.rubendominguez.pruebarss.operations.detail.fragments.DetailNewFragment;
import com.example.rubendominguez.pruebarss.operations.detail.presenters.DetailNewActivityPresenterImpl;
import com.example.rubendominguez.pruebarss.operations.detail.views.DetailActivityView;
import com.example.rubendominguez.pruebarss.operations.detail.views.DetailNewActivityPresenter;

/**
 * Created by rubendominguez on 3/7/17.
 */

public class DetailNewActivity extends AppCompatActivity implements DetailActivityView{


    private DetailNewActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityt_detail_new);

        presenter = new DetailNewActivityPresenterImpl(this,getIntent().getExtras());
        presenter.init();
    }

    @Override
    public void setTitle() {
        getSupportActionBar().setTitle(getString(R.string.title_detail_activity));
    }

    @Override
    public void loadFragment(NewDomain newDomain) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.rlContent, DetailNewFragment.newInstance(newDomain), DetailNewFragment.TAG)
                .commit();
    }
}
