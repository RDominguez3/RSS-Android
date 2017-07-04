package com.example.rubendominguez.pruebarss.operations.main.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.rubendominguez.pruebarss.R;
import com.example.rubendominguez.pruebarss.data.model.domain.NewDomain;
import com.example.rubendominguez.pruebarss.general.KeyboardUtils;
import com.example.rubendominguez.pruebarss.operations.main.adapters.AdapterNews;
import com.example.rubendominguez.pruebarss.operations.main.presenters.MainFragmentPresenterImpl;
import com.example.rubendominguez.pruebarss.operations.main.views.MainFragmentPresenter;
import com.example.rubendominguez.pruebarss.operations.main.views.MainFragmentView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFragment extends Fragment implements MainFragmentView {

    public static final String TAG = MainFragment.class.getName();

    private MainFragmentPresenter presenter;
    private AdapterNews adapterNews;

    @BindView(R.id.rcNews)
    RecyclerView rcNews;
    @BindView(R.id.tvMessage)
    TextView tvMessage;
    @BindView(R.id.etSearch)
    EditText etSearch;
    @BindView(R.id.iconSearch)
    ImageButton button;

    public static MainFragment newInstance(){

        MainFragment f = new MainFragment();

        return f;
    }

    /**
     * Default builder
     */
    public MainFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new MainFragmentPresenterImpl(this);
        presenter.init();
    }

    @Override
    public void initValues() {
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rcNews.setLayoutManager(llm);
        adapterNews = new AdapterNews(presenter,getContext());
        rcNews.setAdapter(adapterNews);
    }

    @Override
    public void updateAdapter(ArrayList<NewDomain> domains) {
        adapterNews.setNews(domains);
        adapterNews.notifyDataSetChanged();
    }


    @Override
    public void hideMessage() {
        tvMessage.setVisibility(View.GONE);
    }

    @Override
    public void hideList() {
        rcNews.setVisibility(View.GONE);
    }

    @Override
    public void showMessage() {
        tvMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void showList() {
        rcNews.setVisibility(View.VISIBLE);
    }


    @Override
    public Context getContextData() {
        return getContext();
    }

    @OnClick(R.id.iconSearch)
    public void searchNews(){
        KeyboardUtils.hideKeyboard(getContext(),etSearch);
        presenter.searchNews(etSearch.getText().toString());
    }

}
