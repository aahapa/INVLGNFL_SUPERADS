package com.superadtech.modids;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;

import com.superadtech.modids.proxy.MasterX;

public class MACT extends AppCompatActivity {
    Handler handlerr = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getCurrentVersionCode(this);
    }

    public static int getCurrentVersionCode(Activity context) {
        PackageManager manager = context.getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(
                    context.getPackageName(), 0);
            return info.versionCode;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void CheckInternet(Activity activity, String url, MasterX.MySpalshCallback mySpalshCallback) {
        MyAminManage.getInstance(activity).ADSinit(activity, mySpalshCallback, url, getCurrentVersionCode(activity));
    }

    @Override
    protected void onResume() {
        super.onResume();
        handlerr.removeCallbacksAndMessages(null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handlerr.removeCallbacksAndMessages(null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handlerr.removeCallbacksAndMessages(null);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        handlerr.removeCallbacksAndMessages(null);
    }
}