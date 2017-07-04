package com.example.rubendominguez.pruebarss.operations.detail.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rubendominguez.pruebarss.R;
import com.example.rubendominguez.pruebarss.data.model.domain.NewDomain;
import com.example.rubendominguez.pruebarss.general.Constants;
import com.example.rubendominguez.pruebarss.operations.detail.presenters.DetailNewFragmentPresenterImpl;
import com.example.rubendominguez.pruebarss.operations.detail.views.DetailNewFragmentPresenter;
import com.example.rubendominguez.pruebarss.operations.detail.views.DetailNewFragmentView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by rubendominguez on 3/7/17.
 */

public class DetailNewFragment extends Fragment implements DetailNewFragmentView {

    public static final String TAG = DetailNewFragment.class.getName();
    @BindView(R.id.iv_photo_detail)
    ImageView ivPhotoDetail;
    @BindView(R.id.tvAuthor)
    TextView tvAuthor;
    @BindView(R.id.tvDate)
    TextView tvDate;
    @BindView(R.id.tvDescription)
    TextView tvDescription;
    @BindView(R.id.buttonBrowser)
    Button buttonBrowser;
    @BindView(R.id.tvTitleDetail)
    TextView tvTitleDetail;

    private DetailNewFragmentPresenter presenter;

    public static DetailNewFragment newInstance(NewDomain newDomain) {

        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.NEW_INFO_DATA, newDomain);
        DetailNewFragment f = new DetailNewFragment();
        f.setArguments(bundle);
        return f;
    }

    /**
     * Default builder
     */
    public DetailNewFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_new, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new DetailNewFragmentPresenterImpl(this, getArguments());
        presenter.init();
    }

    @Override
    public void setPhotoDetail(String url) {
        Picasso.with(getContext()).load(url).fit().centerInside().into(ivPhotoDetail);
    }

    @Override
    public void setAuthorDetail(String value) {
        tvAuthor.setText(value);
    }

    @Override
    public void setDateDetail(String value) {
        tvDate.setText(value);
    }

    @Override
    public void setDescriptionDetail(String value) {
        tvDescription.setText(Html.fromHtml(value.replaceAll("<img.+?>", "")));
    }

    @Override
    public void setButtonLinkDetail(String value) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(value));
        startActivity(i);
    }

    @Override
    public void setTitelDetail(String value) {
        tvTitleDetail.setText(value);
    }

    @OnClick(R.id.buttonBrowser)
    public void openBrowser(){
        presenter.openBrowser();
    }
}
