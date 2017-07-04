package com.example.rubendominguez.pruebarss.operations.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.rubendominguez.pruebarss.R;
import com.example.rubendominguez.pruebarss.operations.main.fragments.MainFragment;
import com.example.rubendominguez.pruebarss.operations.main.presenters.MainActivityPresenterImpl;
import com.example.rubendominguez.pruebarss.operations.main.views.MainActivityPresenter;
import com.example.rubendominguez.pruebarss.operations.main.views.MainActivityView;

public class MainActivity extends AppCompatActivity implements MainActivityView{

    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenterImpl(this);
        presenter.init();
    }

    @Override
    public void setTitle() {
        getSupportActionBar().setTitle(getString(R.string.title_main_activity));
    }

    @Override
    public void loadFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.rlContent, MainFragment.newInstance(), MainFragment.TAG)
                .commit();
    }

}
