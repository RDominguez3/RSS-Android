package com.example.rubendominguez.pruebarss.general;

import android.content.Context;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by rubendominguez on 3/7/17.
 */

public class DateUtils {

    private static final String DATE_RSS_FORMAT = "EEE, dd MMM yyyy HH:mm:ss z";
    private static final String DATE_RSS_FORMAT_OUTPUT = "dd-MM-yyyy HH:mm";

    public static String getDate(String dateNew, Context context){

        if (dateNew!=null && !dateNew.isEmpty()){

            Date date = null;
            DateFormat dateFormatInComponent = new SimpleDateFormat(DATE_RSS_FORMAT,Locale.UK);
            try {
                date = dateFormatInComponent.parse(dateNew);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            DateFormat dateFormatToReturn = new SimpleDateFormat(DATE_RSS_FORMAT_OUTPUT,Locale.UK);
            return dateFormatToReturn.format(date);
        } else
            return null;
    }
}
