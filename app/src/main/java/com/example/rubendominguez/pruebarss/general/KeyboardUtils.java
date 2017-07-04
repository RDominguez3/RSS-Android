package com.example.rubendominguez.pruebarss.general;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class KeyboardUtils {

    /**
     *
     */
    public KeyboardUtils(){
        super();
    }

    /**
     * Call systemservice to hide virtual keyboard
     * @param context - app context
     * @param view - view root
     */
    public static void hideKeyboard(Context context, View view){

        //check context
        if(context == null){
            return;
        }

        //instance manager and hide
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
