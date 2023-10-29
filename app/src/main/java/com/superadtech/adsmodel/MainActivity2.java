package com.superadtech.adsmodel;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.superadtech.modids.MyAdZOne;

public class MainActivity2 extends AppCompatActivity {
    Activity activity = MainActivity2.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MyAdZOne.getInstance(this).showBanner(findViewById(R.id.banner_container));
        MyAdZOne.getInstance(this).ads_NativeCall(findViewById(R.id.native_container));
//        CheckInternet(this, "7CAB452364AEDE88F168481C95DCF68D4B9EB84AEA401F2DF05445CF7F5CBE5239063AAE1755236B643FAEB3E545B084A34C3FE276B4BF0586798FC36F0FF1C0", new GetLoadAsds.MySpalshCallback() {
//            @Override
//            public void onSuccessSplashMethod() {
//            }
//        });
    }

    public void next_butn(View view) {
        MyAdZOne.getInstance(activity).Show_Next_InterstitialAd(activity, new MyAdZOne.MyCallback() {
            public void callbackCall() {
                Toast.makeText(activity, "Next", Toast.LENGTH_SHORT).show();
            }
        }, MyAdZOne.NextClick_inter_Ad);
    }

    public void back_butn(View view) {
        MyAdZOne.getInstance(activity).Show_Back_InterstitialAd(activity, new MyAdZOne.MyCallback() {
            public void callbackCall() {
                Toast.makeText(activity, "Back", Toast.LENGTH_SHORT).show();
            }
        }, MyAdZOne.BackClick_inter_Ad);
    }
}