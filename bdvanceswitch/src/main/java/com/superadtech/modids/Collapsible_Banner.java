package com.superadtech.modids;

import static android.content.ContentValues.TAG;
import static com.superadtech.modids.MyAdZOne.AD_MOB_APP_ID_Collapsible_Banner;
import static com.superadtech.modids.MyAdZOne.AD_MOB_APP_ID_Collapsible_Banner_Show;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowMetrics;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

public class Collapsible_Banner {

    private static Collapsible_Banner instance;
    public static Activity activity;
    public static RelativeLayout admobBanerLayout;
    AdView mAdView = null;

    private Collapsible_Banner(Activity activityx) {
        activity = activityx;
    }

    public static Collapsible_Banner getInstance(Activity activity1) {
        activity = activity1;
        if (instance == null) {
            instance = new Collapsible_Banner(activity);
        }
        return instance;
    }
//        Collapsible_Banner.getInstance(activity).Show_Collapsible_Banner(findViewById(R.id.banner_container));
    public void Show_Collapsible_Banner(RelativeLayout ids) {
        if(AD_MOB_APP_ID_Collapsible_Banner_Show.equalsIgnoreCase("true")){
            admobBanerLayout = ids;
            mAdView = new AdView(activity);
            mAdView.setAdSize(getAdSize());
            mAdView.setAdUnitId(AD_MOB_APP_ID_Collapsible_Banner);
            Bundle bundle = new Bundle();
            bundle.putString("collapsible", "bottom");
            AdRequest adRequest = new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle).build();
            mAdView.loadAd(adRequest);
            mAdView.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    Log.e(TAG, "onAdClosedggb1: ");
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    Log.e(TAG, "onAdFailedToLoadggb1: ");
                    admobBanerLayout.removeAllViews();
                    admobBanerLayout = null;
                }

                @Override
                public void onAdOpened() {
                    Log.e(TAG, "onAdOpenedggb1: ");
                }

                @Override
                public void onAdLoaded() {
                    Log.e(TAG, "onAdLoadedggb1: ");
                    admobBanerLayout.removeAllViews();
                    admobBanerLayout.addView(mAdView);
                }

                @Override
                public void onAdClicked() {
                    Log.e(TAG, "onAdClickedggb1: ");
                }

                @Override
                public void onAdImpression() {
                    Log.e(TAG, "onAdImpressionggb1: ");
                }
            });
        }
    }

    private AdSize getAdSize() {
        WindowMetrics windowMetrics = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            windowMetrics = activity.getWindowManager().getCurrentWindowMetrics();
        }
        Rect bounds = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            bounds = windowMetrics.getBounds();
        }

        float adWidthPixels = admobBanerLayout.getWidth();

        // If the ad hasn't been laid out, default to the full screen width.
        if (adWidthPixels == 0f) {
            adWidthPixels = bounds.width();
        }

        float density = activity.getResources().getDisplayMetrics().density;
        int adWidth = (int) (adWidthPixels / density);

        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, adWidth);
    }

}
