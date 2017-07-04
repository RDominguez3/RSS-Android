package com.example.rubendominguez.pruebarss.operations.main.presenters;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;

import com.example.rubendominguez.pruebarss.R;
import com.example.rubendominguez.pruebarss.data.model.New;
import com.example.rubendominguez.pruebarss.data.model.RSS;
import com.example.rubendominguez.pruebarss.data.model.domain.NewDomain;
import com.example.rubendominguez.pruebarss.data.model.utils.NewUtils;
import com.example.rubendominguez.pruebarss.general.Constants;
import com.example.rubendominguez.pruebarss.general.ManagerDialogs;
import com.example.rubendominguez.pruebarss.operations.detail.DetailNewActivity;
import com.example.rubendominguez.pruebarss.operations.main.interactors.GetNewsUseCase;
import com.example.rubendominguez.pruebarss.operations.main.interactors.GetNewsUseCaseImpl;
import com.example.rubendominguez.pruebarss.operations.main.views.MainFragmentPresenter;
import com.example.rubendominguez.pruebarss.operations.main.views.MainFragmentView;

import java.util.ArrayList;
import java.util.regex.Pattern;


public class MainFragmentPresenterImpl implements MainFragmentPresenter, GetNewsUseCase.Callback {

    private MainFragmentView view;
    private GetNewsUseCase getNewsUseCase;
    private ArrayList<NewDomain> news;

    public MainFragmentPresenterImpl(MainFragmentView view) {
        this.view = view;
        this.getNewsUseCase = new GetNewsUseCaseImpl();
    }

    @Override
    public void init() {
        view.initValues();
        ManagerDialogs.getLoading(view.getContextData());
        getNewsUseCase.execute(this);
    }

    @Override
    public void clickNew(NewDomain newDomain, View view) {
        // Ordinary Intent for launching a new activity
        Intent intent = new Intent(this.view.getContextData(), DetailNewActivity.class);
        intent.putExtra(Constants.NEW_INFO_DATA,newDomain);

        // Get the transition name from the string
        String transitionName = this.view.getContextData().getString(R.string.transition_string);

        // Define the view that the animation will start from
        View viewStart = view.findViewById(R.id.card_view);

        ActivityOptionsCompat options =

                ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) this.view.getContextData(),
                        viewStart,   // Starting view
                        transitionName    // The String
                );
        //Start the Intent
        ActivityCompat.startActivity(this.view.getContextData(), intent, options.toBundle());
    }

    @Override
    public void searchNews(String value) {
        ArrayList<NewDomain> newsSearch = new ArrayList<>();
        for(int i = 0 ;i <news.size();i++){
            boolean find = Pattern.compile(Pattern.quote(value), Pattern.CASE_INSENSITIVE).matcher(news.get(i).getTitle()).find();
            if(find){
                newsSearch.add(news.get(i));
            }
        }

        if(newsSearch.isEmpty()){
            view.showMessage();
            view.hideList();
        }else{
            view.updateAdapter(newsSearch);
            view.hideMessage();
            view.showList();
        }


    }


    @Override
    public void onNewsReceived(RSS rss) {
        ManagerDialogs.hideLoading();
        news= NewUtils.toDomainList((ArrayList<New>)rss.getChannel().getItems(),view.getContextData());
        view.updateAdapter(news);
        view.hideMessage();
        view.showList();
    }

    @Override
    public void onErrorReceived() {
        ManagerDialogs.hideLoading();
        view.showMessage();
    }
}
