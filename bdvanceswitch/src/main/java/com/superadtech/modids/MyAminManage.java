
package com.superadtech.modids;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.superadtech.modids.proxy.Const_Preference;
import com.superadtech.modids.proxy.MasterX;

public class MyAminManage {
    public static Activity activity;
    public static MyAminManage myAminManage;

    public static SharedPreferences mysharedpreferences;

    public static boolean need_internet1 = false;
    public static boolean is_retry1;
    public static Handler refreshHandler1;
    public static Runnable runnable1;


    public MyAminManage(Activity activity1) {
        activity = activity1;
    }

    public static MyAminManage getInstance(Activity activity1) {
        activity = activity1;
        if (myAminManage == null) {
            myAminManage = new MyAminManage(activity);
        }
        return myAminManage;
    }

    public void ADSinit(final Activity activity1, MasterX.MySpalshCallback mySpalshCallback, String url1, final int cversion) {
        if (!url1.isEmpty()) {
            need_internet1 = true;
        } else {
            need_internet1 = false;
        }

        final Dialog dialog = new Dialog(activity);
        dialog.setCancelable(false);
        View view = activity.getLayoutInflater().inflate(R.layout.retry_layout, null);
        dialog.setContentView(view);
        final TextView retry_buttton = view.findViewById(R.id.retry_buttton);

        if (!isNetworkAvailable(activity) && need_internet1) {
            is_retry1 = false;
            dialog.show();
        }

        dialog.dismiss();
        refreshHandler1 = new Handler();
        runnable1 = new Runnable() {
            @Override
            public void run() {
                if (isNetworkAvailable(activity)) {
                    is_retry1 = true;
                    retry_buttton.setText("Retry Again");
                } else if (need_internet1) {
                    dialog.show();
                    is_retry1 = false;
                    retry_buttton.setText("Please Connect To Internet");
                }
                refreshHandler1.postDelayed(this, 1000);
            }
        };
        refreshHandler1.postDelayed(runnable1, 1000);

        retry_buttton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_retry1) {
                    if (need_internet1) {
                        activity.startActivity(new Intent(activity, activity.getClass()));
                        activity.finish();
                    }
                } else {
                    activity.startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                }
            }
        });
        mysharedpreferences = activity.getSharedPreferences(activity.getPackageName(), Context.MODE_PRIVATE);

        Const_Preference.mySpalshCallback = mySpalshCallback;
        activity.startActivity(new Intent(activity, MasterX.class)
                .putExtra("model", url1)
                .putExtra("cversion", cversion)
                .putExtra(Const_Preference.From_Splash, true));

    }

    public static boolean isNetworkAvailable(Activity contnex) {
        ConnectivityManager manager =
                (ConnectivityManager) contnex.getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressLint("MissingPermission")
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            // Network is present and connected
            isAvailable = true;
        }
        return isAvailable;
    }
}



