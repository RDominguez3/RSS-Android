package com.example.rubendominguez.pruebarss.data.model.utils;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;

import com.example.rubendominguez.pruebarss.data.model.New;
import com.example.rubendominguez.pruebarss.data.model.domain.NewDomain;
import com.example.rubendominguez.pruebarss.general.DateUtils;

import java.util.ArrayList;

/**
 * Created by rubendominguez on 3/7/17.
 */

public class NewUtils {

    public static NewDomain modelToDomain(New newInfo, Context context){
        NewDomain newDomain = new NewDomain();
        newDomain.setTitle(newInfo.getTitle());
        newDomain.setAuthor(newInfo.getAuthor());
        newDomain.setUrlNew(newInfo.getLink());
        newDomain.setDate(DateUtils.getDate(newInfo.getPubDate(),context));

        int start = newInfo.getDescription().indexOf("src=\"") + 5;
        int end = newInfo.getDescription().indexOf("\"", start);

        String src = newInfo.getDescription().substring(start, end);
        newDomain.setUrlImage(src);

        Spanned description= Html.fromHtml(newInfo.getDescription().replace("\n","").replaceAll("<img.+?>", ""));
        newDomain.setDescription(description.toString());
        newDomain.setDescriptionUnformatted(newInfo.getDescription());

        return newDomain;

    }

    public static ArrayList<NewDomain> toDomainList(ArrayList<New> news, Context context){
        ArrayList<NewDomain> domains = new ArrayList<>();
        for(int i =0;i<news.size();i++){
            domains.add(modelToDomain(news.get(i),context));
        }
        return domains;
    }
}
