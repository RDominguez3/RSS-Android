package com.example.rubendominguez.pruebarss.operations.main.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rubendominguez.pruebarss.R;
import com.example.rubendominguez.pruebarss.data.model.domain.NewDomain;
import com.example.rubendominguez.pruebarss.operations.main.views.MainFragmentPresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AdapterNews extends RecyclerView.Adapter<AdapterNews.NewViewHolder> {

    private ArrayList<NewDomain> news;
    private MainFragmentPresenter presenter;
    private Context context;

    public AdapterNews(MainFragmentPresenter presenter, Context context) {
        this.news = new ArrayList<>();
        this.presenter = presenter;
        this.context = context;
    }

    public void setNews(ArrayList<NewDomain> news) {
        this.news = news;
    }

    @Override public NewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.lay_new_row, parent, false);
        return new NewViewHolder(view);
    }

    @Override public void onBindViewHolder(NewViewHolder holder, int position) {
        NewDomain newDomain = news.get(position);
        holder.title.setText(newDomain.getTitle());
        holder.description.setText(newDomain.getDescription());
        Picasso.with(holder.itemView.getContext()).load(newDomain.getUrlImage()).fit().centerInside().into(holder.photo);
    }

    @Override public int getItemCount() {
        return news.size();
    }

    public class NewViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_photo)
        ImageView photo;
        @BindView(R.id.tv_title)
        TextView title;
        @BindView(R.id.tv_description)
        TextView description;
        @BindView(R.id.card_view)
        CardView cardView;

        public NewViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        @OnClick(R.id.card_view)
        public void clickNew(){
            presenter.clickNew(news.get(getAdapterPosition()),cardView);
        }
    }
}
