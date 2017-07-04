package com.example.rubendominguez.pruebarss.general;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.rubendominguez.pruebarss.R;

public class ManagerDialogs {

    private static Dialog dialogActual = null;

    public static void getLoading(final Context context){

        Handler mainHandler = new Handler(Looper.getMainLooper());
        mainHandler.post(new Runnable() {

            @Override
            public void run() {
                //inflate view
                final LinearLayout llLoading = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.lay_loading, null);

                ImageView imageView = (ImageView) llLoading.findViewById(R.id.ivLoading);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    imageView.setImageDrawable(context.getDrawable(R.mipmap.ic_launcher));
                }else{
                    imageView.setImageDrawable(context.getResources().getDrawable(R.mipmap.ic_launcher));
                }
                RotateAnimation anim = new RotateAnimation(355f, 8f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                anim.setInterpolator(new LinearInterpolator());
                anim.setRepeatCount(Animation.INFINITE);
                anim.setDuration(1200);

                // Start animating the image
                imageView.startAnimation(anim);

                // Configuramos el dialogo
                final Dialog dialog = new Dialog(context, R.style.LoadingTheme);
                dialog.setContentView(llLoading);
                dialog.setCancelable(false);
                dialog.setCanceledOnTouchOutside(false);

                // Mostramos la alerta
                dialogActual = dialog;
                dialogActual.show();

            }
        });

    }

    public static void hideLoading(){
        if (dialogActual != null && dialogActual.isShowing()) {
            dialogActual.dismiss();
        }
        dialogActual = null;
    }
}