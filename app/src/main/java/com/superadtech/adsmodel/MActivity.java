package com.superadtech.adsmodel;

import static com.superadtech.modids.MACT.CheckInternet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.superadtech.modids.proxy.MasterX;

public class MActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);

        CheckInternet(this, "https://medzmart.com/testing_urls/myvpn_gl_fb_ads.json", new MasterX.MySpalshCallback() {
            @Override
            public void onSuccessSplashMethod() {
                    startActivity(new Intent(MActivity.this,MainActivity2.class));
            }
        });
    }
}