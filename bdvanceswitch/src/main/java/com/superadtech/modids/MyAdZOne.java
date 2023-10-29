package com.superadtech.modids;

import static com.superadtech.modids.proxy.MasterX.appOpenManager;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;

import com.facebook.ads.AbstractAdListener;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AdSize;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

public class MyAdZOne {
    private static final String TAG = "ZOne";
    public static Activity activity;
    public static MyAdZOne myAdZOne;
    static MyCallback myCallback;
    static OnAdListner onAdListner;
    public Dialog dialog;
    public static String All_Ads_Show;

    public static String Install_Ref_Activate;
    public static String Install_Ref1;
    public static String Install_Ref2;
    public static String Install_Ref3;
    public static String Install_Ref4;

    public static String VPN_SHOW_AT_APP_Start;
    public static String VPN_OFF_When_App_Close;
    public static String VPN_OFF_When_App_Close_Feature;
    public static String VPN_SERVER_NAME_TO_CONNECT;
    public static String VPN_SERVER_NAME_TO_CONNECT_FEATURE;

    public static String App_Debug_Mode = "true";
    public static String Dialog_Show;
    public static String app_updateAppDialogStatus;
    public static String app_versionCode = "";
    public static String app_UpdatePackageName = "";
    public static String app_Extra_Data1 = "";
    public static String app_Extra_Data2 = "";
    public static String app_Extra_Data3 = "";
    public static String app_Extra_Data4 = "";
    public static String app_Extra_Data5 = "";
    public static String app_Extra_Data6 = "";
    public static String app_Extra_Data7 = "";
    public static String app_Extra_Data8 = "";
    public static String app_Extra_Data9 = "";
    public static String app_Extra_Data10 = "";
    public static String app_Extra_Data11 = "";
    public static String app_Extra_Data12 = "";
    public static String app_Extra_Data13 = "";
    public static String app_Extra_Data14 = "";
    public static String app_Extra_Data15 = "";
    public static String app_Extra_Data16 = "";
    public static String app_Extra_Data17 = "";
    public static String app_Extra_Data18 = "";
    public static String app_Extra_Data19 = "";
    public static String app_Extra_Data20 = "";
    public static String app_Extra_Data21 = "";
    public static String app_Extra_Data22 = "";
    public static String app_Extra_Data23 = "";
    public static String app_Extra_Data24 = "";
    public static String app_Extra_Data25 = "";
    public static String app_Extra_Data26 = "";
    public static String app_Extra_Data27 = "";
    public static String app_Extra_Data28 = "";
    public static String app_Extra_Data29 = "";
    public static String app_Extra_Data30 = "";
    public static String app_Extra_Data31 = "";
    public static String app_Extra_Data32 = "";
    public static String app_Extra_Data33 = "";
    public static String app_Extra_Data34 = "";
    public static String app_Extra_Data35 = "";
    public static String app_Extra_Data36 = "";
    public static String app_Extra_Data37 = "";
    public static String app_Extra_Data38 = "";
    public static String app_Extra_Data39 = "";
    public static String app_Extra_Data40 = "";
    public static String app_Extra_Data41 = "";
    public static String app_Extra_Data42 = "";
    public static String app_Extra_Data43 = "";
    public static String app_Extra_Data44 = "";
    public static String app_Extra_Data45 = "";
    public static String app_Extra_Data46 = "";
    public static String app_Extra_Data47 = "";
    public static String app_Extra_Data48 = "";
    public static String app_Extra_Data49 = "";
    public static String app_Extra_Data50 = "";

    public static String Activity_Parameter_1 = "";
    public static String Activity_Parameter_2 = "";
    public static String Activity_Parameter_3 = "";
    public static String Activity_Parameter_4 = "";
    public static String Activity_Parameter_5 = "";
    public static String Activity_Parameter_6 = "";
    public static String Activity_Parameter_7 = "";
    public static String Activity_Parameter_8 = "";
    public static String Activity_Parameter_9 = "";
    public static String Activity_Parameter_10 = "";
    public static String Privacy_Policy = "";
    public static String app_onesingle_appid = "";

    public static String app_AdsPriority = "";
    public static String app_Banner_AdsPriority = "";
    public static String app_Native_AdsPriority = "";
    public static String app_NativeAdCodeType = "";
    public static String app_BannerPeriority = "";

    public static String AD_MOB_STATUS = "";
    public static String AD_MOB_APP_ID_Banner1 = "";
    public static String AD_MOB_APP_ID_Banner2 = "";
    public static String AD_MOB_APP_ID_Banner3 = "";
    public static String AD_MOB_APP_ID_NativeBanner1 = "";
    public static String AD_MOB_APP_ID_NativeBanner2 = "";
    public static String AD_MOB_APP_ID_NativeBanner3 = "";

    public static String AD_MOB_APP_ID_Collapsible_Banner_Show = "";
    public static String AD_MOB_APP_ID_Collapsible_Banner = "";

    public static String AD_MOB_APP_ID_Inter1 = "";
    public static String AD_MOB_APP_ID_Inter2 = "";
    public static String AD_MOB_APP_ID_Inter3 = "";

    public static String AD_MOB_APP_ID_Native1 = "";
    public static String AD_MOB_APP_ID_Native2 = "";
    public static String AD_MOB_APP_ID_Native3 = "";
    public static String AD_MOB_APP_ID_Native4 = "";

    public static String AD_MOB_OpenAd_STATUS = "";
    public static int AD_MOB_APP_OPEN_TIMER;
    public static String AD_MOB_OpenAd_Fails_INTER_SHOW = "";
    public static String AD_MOB_SPLASH_INTER_FORCE = "";
    public static int AD_MOB_SPLASH_INTER_TIMER;
    public static String AD_MOB_APP_ID_OpenAd1 = "";

    public static String Native_Background_Color = "";
    public static String Native_Banner_Background_Color = "";

    public static String FACEBOOK_AD_STATUS = "";
    public static String FB_Banner_ID1 = "";
    public static String FB_Banner_ID2 = "";
    public static String FB_Banner_ID3 = "";

    public static String FB_BannerNative_ID1 = "";
    public static String FB_BannerNative_ID2 = "";
    public static String FB_BannerNative_ID3 = "";

    public static String FB_Inter_ID1 = "";
    public static String FB_Inter_ID2 = "";
    public static String FB_Inter_ID3 = "";

    public static String FB_Native_ID1 = "";
    public static String FB_Native_ID2 = "";
    public static String FB_Native_ID3 = "";
    public static String FB_Native_ID4 = "";

    public static String Native_Btn_Color = "";
    public static String Native_Text_Color = "";

    public static String Native_Btn_text = "";
    public static String Native_Btn_Text_Size = "";
    public static String Native_Btn_Text_Color = "";

    public static String Native_Btn_Height = "";
    public static String Native_Banner_Btn_Height = "";

    public static String Native_Ads_Btn_Corner_Radius = "";
    public static String Native_Ad_Small_Size_Lyout = "";
    public static String Native_Ad_Normal_Size_Lyout = "";

    public static String Banner_Ads_On = "";
    public static String Native_Ads_On = "";
    public static String NativeBanner_Ads_On = "";

    public static int NextClick_inter_Ad = 0;
    public static int BackClick_inter_Ad = 0;

    public static String QurekaLink = "";

    static RelativeLayout admobBanerLayout = null;
    static RelativeLayout admobBanerLayout2 = null;
    static RelativeLayout admobBanerLayout3 = null;
    static RelativeLayout fbBanerLayout = null;
    static RelativeLayout fbBanerLayout2 = null;
    static RelativeLayout fbBanerLayout3 = null;
    static RelativeLayout admobNativeBanerLayout = null;
    static RelativeLayout admobNativeBanerLayout2 = null;
    static RelativeLayout admobNativeBanerLayout3 = null;
    static RelativeLayout fbNativeBanerLayout = null;
    static RelativeLayout fbNativeBanerLayout2 = null;
    static RelativeLayout fbNativeBanerLayout3 = null;
    static LinearLayout admobNativeNewLayout = null;
    static LinearLayout admobNativeNewLayout2 = null;
    static LinearLayout admobNativeNewLayout3 = null;
    static LinearLayout admobNativeNewLayout4 = null;
    static LinearLayout fbNativeNewLayout = null;
    static LinearLayout fbNativeNewLayout2 = null;
    static LinearLayout fbNativeNewLayout3 = null;
    static LinearLayout fbNativeNewLayout4 = null;
    public static boolean preloadNative_AdStatus = true;
    public static String state_admobNative = "Start";
    public static String state_fbNative = "Start";

    public static int count_click_next = 0;

    public static int count_click_back = 0;
    public static int ad_dialog_time_in_second = 2;
    AdView mAdView = null;
    NativeAd admobNativeAd_preLoad = null;
    NativeAd admobBannerNativeAd = null;
    com.facebook.ads.NativeAd fbNativeAd_preLoad = null;
    com.facebook.ads.AdView fbadView = null;
    NativeBannerAd nativeAd1 = null;

    public InterstitialAd fbinterstitialAd1;
    public String facebook_i_pre = "";

    public com.google.android.gms.ads.interstitial.InterstitialAd mInterstitialAd;
    public String google_i_pre = "";

    public interface MyCallback {
        void callbackCall();
    }

    public interface OnAdListner {
        void OnClose();
    }

    public MyAdZOne(Activity activity1) {
        activity = activity1;
    }

    public static MyAdZOne getInstance(Activity activity1) {
        activity = activity1;
        if (myAdZOne == null) {
            myAdZOne = new MyAdZOne(activity);
        }
        return myAdZOne;
    }

    public static void appOpenFailLoadeds(OnAdListner onAdListner1) {
        onAdListner = onAdListner1;
        onAdListner1.OnClose();
    }

    public void configDatas(JSONObject jsonObject) throws JSONException {

        Log.e("trackers", "configDatas: Response init");

        All_Ads_Show = jsonObject.getString("All_Ads_Show");

        App_Debug_Mode = jsonObject.getString("App_Debug_Mode");

        Dialog_Show = jsonObject.getString("Dialog_Show");

        Install_Ref_Activate = jsonObject.getString("Install_Ref_Activate");
        Install_Ref1 = jsonObject.getString("Install_Ref1");
        Install_Ref2 = jsonObject.getString("Install_Ref2");
        Install_Ref3 = jsonObject.getString("Install_Ref3");
        Install_Ref4 = jsonObject.getString("Install_Ref4");

        VPN_SHOW_AT_APP_Start = jsonObject.getString("VPN_SHOW_AT_APP_Start");
        VPN_OFF_When_App_Close = jsonObject.getString("VPN_OFF_When_App_Close");
        VPN_OFF_When_App_Close_Feature = jsonObject.getString("VPN_OFF_When_App_Close_Feature");
        VPN_SERVER_NAME_TO_CONNECT = jsonObject.getString("VPN_SERVER_NAME_TO_CONNECT");
        VPN_SERVER_NAME_TO_CONNECT_FEATURE = jsonObject.getString("VPN_SERVER_NAME_TO_CONNECT_FEATURE");

        app_updateAppDialogStatus = jsonObject.getString("app_updateAppDialogStatus");
        app_versionCode = jsonObject.getString("app_versionCode");
        app_UpdatePackageName = jsonObject.getString("app_UpdatePackageName");

        Privacy_Policy = jsonObject.getString("Privacy_Policy");
        app_onesingle_appid = jsonObject.getString("app_OneSingleID");

        app_AdsPriority = jsonObject.getString("app_AdsPriority");
        app_Banner_AdsPriority = jsonObject.getString("app_Banner_AdsPriority");
        app_Native_AdsPriority = jsonObject.getString("app_Native_AdsPriority");
        app_NativeAdCodeType = jsonObject.getString("app_NativeAdCodeType");
        app_BannerPeriority = jsonObject.getString("app_BannerPeriority");

        AD_MOB_STATUS = jsonObject.getString("AD_MOB_STATUS");

        if (App_Debug_Mode.equalsIgnoreCase("true")) {

            AD_MOB_APP_ID_Banner1 = "/6499/example/banner";
            AD_MOB_APP_ID_Banner2 = "/6499/example/banner";
            AD_MOB_APP_ID_Banner3 = "/6499/example/banner";

            AD_MOB_APP_ID_NativeBanner1 = "/6499/example/native";
            AD_MOB_APP_ID_NativeBanner2 = "/6499/example/native";
            AD_MOB_APP_ID_NativeBanner3 = "/6499/example/native";

            AD_MOB_APP_ID_Collapsible_Banner = "ca-app-pub-3940256099942544/9214589741";

            AD_MOB_APP_ID_Inter1 = "/6499/example/interstitial";
            AD_MOB_APP_ID_Inter2 = "/6499/example/interstitial";
            AD_MOB_APP_ID_Inter3 = "/6499/example/interstitial";

            AD_MOB_APP_ID_Native1 = "/6499/example/native";
            AD_MOB_APP_ID_Native2 = "/6499/example/native";
            AD_MOB_APP_ID_Native3 = "/6499/example/native";
            AD_MOB_APP_ID_Native4 = "/6499/example/native";

            AD_MOB_APP_ID_OpenAd1 = "/6499/example/app-open";

            FB_Banner_ID1 = "IMG_16_9_APP_INSTALL#127098822385401_127102462385037";
            FB_Banner_ID2 = "IMG_16_9_APP_INSTALL#127098822385401_127102462385037";
            FB_Banner_ID3 = "IMG_16_9_APP_INSTALL#127098822385401_127102462385037";

            FB_BannerNative_ID1 = "IMG_16_9_APP_INSTALL#1156954457977643_1156959601310462";
            FB_BannerNative_ID2 = "IMG_16_9_APP_INSTALL#1156954457977643_1156959601310462";
            FB_BannerNative_ID3 = "IMG_16_9_APP_INSTALL#1156954457977643_1156959601310462";

            FB_Inter_ID1 = "IMG_16_9_APP_INSTALL#2542154492669100_2542159122668637";
            FB_Inter_ID2 = "IMG_16_9_APP_INSTALL#2542154492669100_2542159122668637";
            FB_Inter_ID3 = "IMG_16_9_APP_INSTALL#2542154492669100_2542159122668637";

            FB_Native_ID1 = "IMG_16_9_APP_INSTALL#1156954457977643_1156959601310462";
            FB_Native_ID2 = "IMG_16_9_APP_INSTALL#1156954457977643_1156959601310462";
            FB_Native_ID3 = "IMG_16_9_APP_INSTALL#1156954457977643_1156959601310462";
            FB_Native_ID4 = "IMG_16_9_APP_INSTALL#1156954457977643_1156959601310462";

            Log.d("debug", "Debug On ");

        } else {
            AD_MOB_APP_ID_Banner1 = jsonObject.getString("AD_MOB_APP_ID_Banner1");
            AD_MOB_APP_ID_Banner2 = jsonObject.getString("AD_MOB_APP_ID_Banner2");
            AD_MOB_APP_ID_Banner3 = jsonObject.getString("AD_MOB_APP_ID_Banner3");

            AD_MOB_APP_ID_NativeBanner1 = jsonObject.getString("AD_MOB_APP_ID_NativeBanner1");
            AD_MOB_APP_ID_NativeBanner2 = jsonObject.getString("AD_MOB_APP_ID_NativeBanner2");
            AD_MOB_APP_ID_NativeBanner3 = jsonObject.getString("AD_MOB_APP_ID_NativeBanner3");

            AD_MOB_APP_ID_Collapsible_Banner_Show = jsonObject.getString("AD_MOB_APP_ID_Collapsible_Banner_Show");
            AD_MOB_APP_ID_Collapsible_Banner = jsonObject.getString("AD_MOB_APP_ID_Collapsible_Banner");

            AD_MOB_APP_ID_Inter1 = jsonObject.getString("AD_MOB_APP_ID_Inter1");
            AD_MOB_APP_ID_Inter2 = jsonObject.getString("AD_MOB_APP_ID_Inter2");
            AD_MOB_APP_ID_Inter3 = jsonObject.getString("AD_MOB_APP_ID_Inter3");

            AD_MOB_APP_ID_Native1 = jsonObject.getString("AD_MOB_APP_ID_Native1");
            AD_MOB_APP_ID_Native2 = jsonObject.getString("AD_MOB_APP_ID_Native2");
            AD_MOB_APP_ID_Native3 = jsonObject.getString("AD_MOB_APP_ID_Native3");
            AD_MOB_APP_ID_Native4 = jsonObject.getString("AD_MOB_APP_ID_Native4");

            AD_MOB_APP_ID_OpenAd1 = jsonObject.getString("AD_MOB_APP_ID_OpenAd1");

            FB_Banner_ID1 = jsonObject.getString("FB_Banner_ID1");
            FB_Banner_ID2 = jsonObject.getString("FB_Banner_ID2");
            FB_Banner_ID3 = jsonObject.getString("FB_Banner_ID3");

            FB_BannerNative_ID1 = jsonObject.getString("FB_BannerNative_ID1");
            FB_BannerNative_ID2 = jsonObject.getString("FB_BannerNative_ID2");
            FB_BannerNative_ID3 = jsonObject.getString("FB_BannerNative_ID3");

            FB_Inter_ID1 = jsonObject.getString("FB_Inter_ID1");
            FB_Inter_ID2 = jsonObject.getString("FB_Inter_ID2");
            FB_Inter_ID3 = jsonObject.getString("FB_Inter_ID3");

            FB_Native_ID1 = jsonObject.getString("FB_Native_ID1");
            FB_Native_ID2 = jsonObject.getString("FB_Native_ID2");
            FB_Native_ID3 = jsonObject.getString("FB_Native_ID3");
            FB_Native_ID4 = jsonObject.getString("FB_Native_ID4");

            Log.d("debug", "Debug Off ");
        }

        AD_MOB_OpenAd_STATUS = jsonObject.getString("AD_MOB_OpenAd_STATUS");
        AD_MOB_APP_OPEN_TIMER = jsonObject.getInt("AD_MOB_APP_OPEN_TIMER");
        AD_MOB_OpenAd_Fails_INTER_SHOW = jsonObject.getString("AD_MOB_OpenAd_Fails_INTER_SHOW");
        AD_MOB_SPLASH_INTER_FORCE = jsonObject.getString("AD_MOB_SPLASH_INTER_FORCE");
        AD_MOB_SPLASH_INTER_TIMER = jsonObject.getInt("AD_MOB_SPLASH_INTER_TIMER");

        FACEBOOK_AD_STATUS = jsonObject.getString("FACEBOOK_AD_STATUS");

        Native_Background_Color = jsonObject.getString("Native_Background_Color");
        Native_Banner_Background_Color = jsonObject.getString("Native_Banner_Background_Color");

        Native_Btn_Color = jsonObject.getString("Native_Btn_Color");
        Native_Text_Color = jsonObject.getString("Native_Text_Color");
        Native_Btn_text = jsonObject.getString("Native_Btn_Ads_Text");
        Native_Btn_Text_Size = jsonObject.getString("Native_Btn_Text_Size");
        Native_Btn_Text_Color = jsonObject.getString("Native_Btn_Text_Color");
        Native_Btn_Height = jsonObject.getString("Native_Btn_Height");
        Native_Banner_Btn_Height = jsonObject.getString("Native_Banner_Btn_Height");
        Native_Ads_Btn_Corner_Radius = jsonObject.getString("Native_Ads_Btn_Corner_Radius");
        Native_Ad_Small_Size_Lyout = jsonObject.getString("Native_Ad_Small_Size_Lyout");
        Native_Ad_Normal_Size_Lyout = jsonObject.getString("Native_Ad_Normal_Size_Lyout");

        Banner_Ads_On = jsonObject.getString("Banner_Ads_On");
        Native_Ads_On = jsonObject.getString("Native_Ads_On");
        NativeBanner_Ads_On = jsonObject.getString("NativeBanner_Ads_On");

        NextClick_inter_Ad = jsonObject.getInt("NextClick_inter_Ad");
        BackClick_inter_Ad = jsonObject.getInt("BackClick_inter_Ad");

        QurekaLink = jsonObject.getString("QurekaLink");

        app_Extra_Data1 = jsonObject.getString("app_Extra_Data1");
        app_Extra_Data2 = jsonObject.getString("app_Extra_Data2");
        app_Extra_Data3 = jsonObject.getString("app_Extra_Data3");
        app_Extra_Data4 = jsonObject.getString("app_Extra_Data4");
        app_Extra_Data5 = jsonObject.getString("app_Extra_Data5");
        app_Extra_Data6 = jsonObject.getString("app_Extra_Data6");
        app_Extra_Data7 = jsonObject.getString("app_Extra_Data7");
        app_Extra_Data8 = jsonObject.getString("app_Extra_Data8");
        app_Extra_Data9 = jsonObject.getString("app_Extra_Data9");
        app_Extra_Data10 = jsonObject.getString("app_Extra_Data10");

        app_Extra_Data11 = jsonObject.getString("app_Extra_Data11");
        app_Extra_Data12 = jsonObject.getString("app_Extra_Data12");
        app_Extra_Data13 = jsonObject.getString("app_Extra_Data13");
        app_Extra_Data14 = jsonObject.getString("app_Extra_Data14");
        app_Extra_Data15 = jsonObject.getString("app_Extra_Data15");
        app_Extra_Data16 = jsonObject.getString("app_Extra_Data16");
        app_Extra_Data17 = jsonObject.getString("app_Extra_Data17");
        app_Extra_Data18 = jsonObject.getString("app_Extra_Data18");
        app_Extra_Data19 = jsonObject.getString("app_Extra_Data19");
        app_Extra_Data20 = jsonObject.getString("app_Extra_Data20");

        app_Extra_Data21 = jsonObject.getString("app_Extra_Data21");
        app_Extra_Data22 = jsonObject.getString("app_Extra_Data22");
        app_Extra_Data23 = jsonObject.getString("app_Extra_Data23");
        app_Extra_Data24 = jsonObject.getString("app_Extra_Data24");
        app_Extra_Data25 = jsonObject.getString("app_Extra_Data25");
        app_Extra_Data26 = jsonObject.getString("app_Extra_Data26");
        app_Extra_Data27 = jsonObject.getString("app_Extra_Data27");
        app_Extra_Data28 = jsonObject.getString("app_Extra_Data28");
        app_Extra_Data29 = jsonObject.getString("app_Extra_Data29");
        app_Extra_Data30 = jsonObject.getString("app_Extra_Data30");

        app_Extra_Data31 = jsonObject.getString("app_Extra_Data31");
        app_Extra_Data32 = jsonObject.getString("app_Extra_Data32");
        app_Extra_Data33 = jsonObject.getString("app_Extra_Data33");
        app_Extra_Data34 = jsonObject.getString("app_Extra_Data34");
        app_Extra_Data35 = jsonObject.getString("app_Extra_Data35");
        app_Extra_Data36 = jsonObject.getString("app_Extra_Data36");
        app_Extra_Data37 = jsonObject.getString("app_Extra_Data37");
        app_Extra_Data38 = jsonObject.getString("app_Extra_Data38");
        app_Extra_Data39 = jsonObject.getString("app_Extra_Data39");
        app_Extra_Data40 = jsonObject.getString("app_Extra_Data40");

        app_Extra_Data41 = jsonObject.getString("app_Extra_Data41");
        app_Extra_Data42 = jsonObject.getString("app_Extra_Data42");
        app_Extra_Data43 = jsonObject.getString("app_Extra_Data43");
        app_Extra_Data44 = jsonObject.getString("app_Extra_Data44");
        app_Extra_Data45 = jsonObject.getString("app_Extra_Data45");
        app_Extra_Data46 = jsonObject.getString("app_Extra_Data46");
        app_Extra_Data47 = jsonObject.getString("app_Extra_Data47");
        app_Extra_Data48 = jsonObject.getString("app_Extra_Data48");
        app_Extra_Data49 = jsonObject.getString("app_Extra_Data49");
        app_Extra_Data50 = jsonObject.getString("app_Extra_Data50");

        Activity_Parameter_1 = jsonObject.getString("Activity_Parameter_1");
        Activity_Parameter_2 = jsonObject.getString("Activity_Parameter_2");
        Activity_Parameter_3 = jsonObject.getString("Activity_Parameter_3");
        Activity_Parameter_4 = jsonObject.getString("Activity_Parameter_4");
        Activity_Parameter_5 = jsonObject.getString("Activity_Parameter_5");
        Activity_Parameter_6 = jsonObject.getString("Activity_Parameter_6");
        Activity_Parameter_7 = jsonObject.getString("Activity_Parameter_7");
        Activity_Parameter_8 = jsonObject.getString("Activity_Parameter_8");
        Activity_Parameter_9 = jsonObject.getString("Activity_Parameter_9");
        Activity_Parameter_10 = jsonObject.getString("Activity_Parameter_10");

        Log.e("trackers", "configDatas: Response  Complete");

    }

    public void Load_BannerAds() {
        if (!All_Ads_Show.equalsIgnoreCase("true")) {
            return;
        }

        if (AD_MOB_STATUS.equalsIgnoreCase("true") && FACEBOOK_AD_STATUS.equalsIgnoreCase("true")) {
            if (app_Banner_AdsPriority.equalsIgnoreCase("google")) {
                showAdmobBanner();
            } else if (app_Banner_AdsPriority.equalsIgnoreCase("facebook")) {
                showFacebookBanner();
            }
        } else if (AD_MOB_STATUS.equalsIgnoreCase("true") && app_Banner_AdsPriority.equalsIgnoreCase("google")) {
            LoadGoogleNativeSmall();
        } else if (FACEBOOK_AD_STATUS.equalsIgnoreCase("true") && app_Banner_AdsPriority.equalsIgnoreCase("facebook")) {
            showFacebookBanner();
        }
    }

    public void showBanner(RelativeLayout banner_container) {
        if (!All_Ads_Show.equalsIgnoreCase("true")) {
            return;
        }

        if ((app_BannerPeriority.equalsIgnoreCase("native") && app_Banner_AdsPriority.equalsIgnoreCase("google")) || app_Banner_AdsPriority.equalsIgnoreCase("facebook")) {
            if (NativeBanner_Ads_On.equalsIgnoreCase("true")) {
                showNativeBanner(banner_container);
            }
        } else if ((app_BannerPeriority.equalsIgnoreCase("banner") && app_Banner_AdsPriority.equalsIgnoreCase("google")) || app_Banner_AdsPriority.equalsIgnoreCase("facebook")) {
            if (Banner_Ads_On.equalsIgnoreCase("true")) {
                displayBanner(banner_container);
            }
        } else {
            banner_container.setVisibility(View.GONE);
        }
    }

    public void displayBanner(RelativeLayout Adlayout) {
        if (FACEBOOK_AD_STATUS.equalsIgnoreCase("true") && app_Banner_AdsPriority.equalsIgnoreCase("facebook")) {
            RelativeLayout relativeLayout = fbBanerLayout;
            if (relativeLayout != null) {
                if (relativeLayout.getParent() != null) {
                    ((ViewGroup) fbBanerLayout.getParent()).removeView(fbBanerLayout);
                }
                Adlayout.addView(fbBanerLayout);
                return;
            }
            RelativeLayout relativeLayout2 = fbBanerLayout2;
            if (relativeLayout2 != null) {
                if (relativeLayout2.getParent() != null) {
                    ((ViewGroup) fbBanerLayout2.getParent()).removeView(fbBanerLayout2);
                }
                Adlayout.addView(fbBanerLayout2);
                return;
            }
            RelativeLayout relativeLayout3 = fbBanerLayout3;
            if (relativeLayout3 != null) {
                if (relativeLayout3.getParent() != null) {
                    ((ViewGroup) fbBanerLayout3.getParent()).removeView(fbBanerLayout3);
                }
                Adlayout.addView(fbBanerLayout3);
                return;
            }
            RelativeLayout relativeLayout4 = admobBanerLayout;
            if (relativeLayout4 != null) {
                if (relativeLayout4.getParent() != null) {
                    ((ViewGroup) admobBanerLayout.getParent()).removeView(admobBanerLayout);
                }
                Adlayout.addView(admobBanerLayout);
                return;
            }
            RelativeLayout relativeLayout5 = admobBanerLayout2;
            if (relativeLayout5 != null) {
                if (relativeLayout5.getParent() != null) {
                    ((ViewGroup) admobBanerLayout2.getParent()).removeView(admobBanerLayout2);
                }
                Adlayout.addView(admobBanerLayout2);
                return;
            }
            RelativeLayout relativeLayout6 = admobBanerLayout3;
            if (relativeLayout6 != null) {
                if (relativeLayout6.getParent() != null) {
                    ((ViewGroup) admobBanerLayout3.getParent()).removeView(admobBanerLayout3);
                }
                Adlayout.addView(admobBanerLayout3);
                showFacebookBanner();
                return;
            }
        } else if (AD_MOB_STATUS.equalsIgnoreCase("true") && app_Banner_AdsPriority.equalsIgnoreCase("google")) {
            RelativeLayout relativeLayout7 = admobBanerLayout;
            if (relativeLayout7 != null) {
                if (relativeLayout7.getParent() != null) {
                    ((ViewGroup) admobBanerLayout.getParent()).removeView(admobBanerLayout);
                }
                Adlayout.addView(admobBanerLayout);
                return;
            }
            RelativeLayout relativeLayout8 = admobBanerLayout2;
            if (relativeLayout8 != null) {
                if (relativeLayout8.getParent() != null) {
                    ((ViewGroup) admobBanerLayout2.getParent()).removeView(admobBanerLayout2);
                }
                Adlayout.addView(admobBanerLayout2);
                return;
            }
            RelativeLayout relativeLayout9 = admobBanerLayout3;
            if (relativeLayout9 != null) {
                if (relativeLayout9.getParent() != null) {
                    ((ViewGroup) admobBanerLayout3.getParent()).removeView(admobBanerLayout3);
                }
                Adlayout.addView(admobBanerLayout3);
                return;
            }
            RelativeLayout relativeLayout10 = fbBanerLayout;
            if (relativeLayout10 != null) {
                if (relativeLayout10.getParent() != null) {
                    ((ViewGroup) fbBanerLayout.getParent()).removeView(fbBanerLayout);
                }
                Adlayout.addView(fbBanerLayout);
                return;
            }
            RelativeLayout relativeLayout11 = fbBanerLayout2;
            if (relativeLayout11 != null) {
                if (relativeLayout11.getParent() != null) {
                    ((ViewGroup) fbBanerLayout2.getParent()).removeView(fbBanerLayout2);
                }
                Adlayout.addView(fbBanerLayout2);
                return;
            }
            RelativeLayout relativeLayout12 = fbBanerLayout3;
            if (relativeLayout12 != null) {
                if (relativeLayout12.getParent() != null) {
                    ((ViewGroup) fbBanerLayout3.getParent()).removeView(fbBanerLayout3);
                }
                Adlayout.addView(fbBanerLayout3);
                showAdmobBanner();
            }
        }
    }

    public void showFacebookBanner() {
        Log.e(TAG, "showFacebookBanner1: ");
        if (FACEBOOK_AD_STATUS.equalsIgnoreCase("false")) {
            showAdmobBanner();
            return;
        }
        fbBanerLayout = new RelativeLayout(activity);
        fbadView = new com.facebook.ads.AdView(activity, FB_Banner_ID1, AdSize.BANNER_HEIGHT_50);
        fbBanerLayout.addView(fbadView);
        AdListener adListener = new AdListener() { // from class: com.superadtech.modids.1
            @Override // com.facebook.ads.AdListener
            public void onError(Ad ad, AdError adError) {
                Log.e(TAG, "onErrorbner1: ");
                fbBanerLayout.removeAllViews();
                fbBanerLayout = null;
                showFacebookBanner2();
            }

            @Override // com.facebook.ads.AdListener
            public void onAdLoaded(Ad ad) {
                Log.e(TAG, "onAdLoadedbner1: ");
            }

            @Override // com.facebook.ads.AdListener
            public void onAdClicked(Ad ad) {
                Log.e(TAG, "onAdClicked1: ");
            }

            @Override // com.facebook.ads.AdListener
            public void onLoggingImpression(Ad ad) {
                Log.e(TAG, "onLoggingImpressionbner1: ");
            }
        };
        fbadView.loadAd(fbadView.buildLoadAdConfig().withAdListener(adListener).build());
    }

    public void showFacebookBanner2() {
        Log.e(TAG, "showFacebookBanner2: ");
        if (FACEBOOK_AD_STATUS.equalsIgnoreCase("false")) {
            showAdmobBanner();
            return;
        }
        fbBanerLayout2 = new RelativeLayout(activity);
        fbadView = new com.facebook.ads.AdView(activity, FB_Banner_ID2, AdSize.BANNER_HEIGHT_50);
        fbBanerLayout2.addView(fbadView);
        AdListener adListener = new AdListener() { // from class: com.superadtech.modids.2
            @Override // com.facebook.ads.AdListener
            public void onError(Ad ad, AdError adError) {
                Log.e(TAG, "onErrorbner2: ");
                fbBanerLayout2.removeAllViews();
                fbBanerLayout2 = null;
                showFacebookBanner3();
            }

            @Override // com.facebook.ads.AdListener
            public void onAdLoaded(Ad ad) {
                Log.e(TAG, "onAdLoadedbner2: ");
            }

            @Override // com.facebook.ads.AdListener
            public void onAdClicked(Ad ad) {
                Log.e(TAG, "onAdClickedbner2: ");
            }

            @Override // com.facebook.ads.AdListener
            public void onLoggingImpression(Ad ad) {
                Log.e(TAG, "onLoggingImpressionbner2: ");
            }
        };
        fbadView.loadAd(fbadView.buildLoadAdConfig().withAdListener(adListener).build());
    }

    public void showFacebookBanner3() {
        Log.e(TAG, "showFacebookBanner3: ");
        if (FACEBOOK_AD_STATUS.equalsIgnoreCase("false")) {
            showAdmobBanner();
            return;
        }
        fbBanerLayout3 = new RelativeLayout(activity);
        fbadView = new com.facebook.ads.AdView(activity, FB_Banner_ID3, AdSize.BANNER_HEIGHT_50);
        fbBanerLayout3.addView(fbadView);
        AdListener adListener = new AdListener() { // from class: com.superadtech.modids.3
            @Override // com.facebook.ads.AdListener
            public void onError(Ad ad, AdError adError) {
                Log.e(TAG, "onErrorbner3: ");
                fbBanerLayout3.removeAllViews();
                fbBanerLayout3 = null;
                if (AD_MOB_STATUS.equalsIgnoreCase("true") && app_Banner_AdsPriority.equalsIgnoreCase("facebook")) {
                    showAdmobBanner();
                }
            }

            @Override // com.facebook.ads.AdListener
            public void onAdLoaded(Ad ad) {
                Log.e(TAG, "onAdLoadedbner3: ");
            }

            @Override // com.facebook.ads.AdListener
            public void onAdClicked(Ad ad) {
                Log.e(TAG, "onAdClickedbner3: ");
            }

            @Override // com.facebook.ads.AdListener
            public void onLoggingImpression(Ad ad) {
                Log.e(TAG, "onLoggingImpressionbner3: ");
            }
        };
        fbadView.loadAd(fbadView.buildLoadAdConfig().withAdListener(adListener).build());
    }

    public void showAdmobBanner() {
        if (AD_MOB_STATUS.equalsIgnoreCase("false")) {
            return;
        }
        admobBanerLayout = new RelativeLayout(activity);
        mAdView = new AdView(activity);
        mAdView.setAdSize(com.google.android.gms.ads.AdSize.BANNER);
        mAdView.setAdUnitId(AD_MOB_APP_ID_Banner1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new com.google.android.gms.ads.AdListener() { // from class: com.superadtech.modids.4
            @Override // com.google.android.gms.ads.AdListener
            public void onAdClosed() {
                Log.e(TAG, "onAdClosedggb1: ");
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                Log.e(TAG, "onAdFailedToLoadggb1: ");
                admobBanerLayout.removeAllViews();
                admobBanerLayout = null;
                showAdmobBanner2();
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdOpened() {
                Log.e(TAG, "onAdOpenedggb1: ");
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                Log.e(TAG, "onAdLoadedggb1: ");
                admobBanerLayout.removeAllViews();
                admobBanerLayout.addView(mAdView);
            }

            @Override
            // com.google.android.gms.ads.AdListener, com.google.android.gms.ads.internal.client.zza
            public void onAdClicked() {
                Log.e(TAG, "onAdClickedggb1: ");
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdImpression() {
                Log.e(TAG, "onAdImpressionggb1: ");
            }
        });
    }

    public void showAdmobBanner2() {
        if (AD_MOB_STATUS.equalsIgnoreCase("false")) {
            return;
        }
        admobBanerLayout2 = new RelativeLayout(activity);
        mAdView = new AdView(activity);
        mAdView.setAdSize(com.google.android.gms.ads.AdSize.BANNER);
        mAdView.setAdUnitId(AD_MOB_APP_ID_Banner2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new com.google.android.gms.ads.AdListener() { // from class: com.superadtech.modids.5
            @Override // com.google.android.gms.ads.AdListener
            public void onAdClosed() {
                Log.e(TAG, "onAdClosedggb2: ");
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                Log.e(TAG, "onAdFailedToLoadggb2: ");
                admobBanerLayout2.removeAllViews();
                admobBanerLayout2 = null;
                showAdmobBanner3();
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdOpened() {
                Log.e(TAG, "onAdOpenedggb2: ");
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                Log.e(TAG, "onAdLoadedggb2: ");
                admobBanerLayout2.removeAllViews();
                admobBanerLayout2.addView(mAdView);
            }

            @Override
            // com.google.android.gms.ads.AdListener, com.google.android.gms.ads.internal.client.zza
            public void onAdClicked() {
                Log.e(TAG, "onAdClickedggb2: ");
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdImpression() {
                Log.e(TAG, "onAdImpressionggb2: ");
            }
        });
    }

    public void showAdmobBanner3() {
        if (AD_MOB_STATUS.equalsIgnoreCase("false")) {
            return;
        }
        admobBanerLayout3 = new RelativeLayout(activity);
        mAdView = new AdView(activity);
        mAdView.setAdSize(com.google.android.gms.ads.AdSize.BANNER);
        mAdView.setAdUnitId(AD_MOB_APP_ID_Banner3);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new com.google.android.gms.ads.AdListener() { // from class: com.superadtech.modids.6
            @Override // com.google.android.gms.ads.AdListener
            public void onAdClosed() {
                Log.e(TAG, "onAdClosedggb3: ");
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                Log.e(TAG, "onAdFailedToLoadggb3: ");
                admobBanerLayout3.removeAllViews();
                admobBanerLayout3 = null;
                if (FACEBOOK_AD_STATUS.equalsIgnoreCase("true") && app_Banner_AdsPriority.equalsIgnoreCase("google")) {
                    showFacebookBanner();
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdOpened() {
                Log.e(TAG, "onAdOpenedggb3: ");
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                Log.e(TAG, "onAdLoadedggb3: ");
                admobBanerLayout3.removeAllViews();
                admobBanerLayout3.addView(mAdView);
            }

            @Override
            // com.google.android.gms.ads.AdListener, com.google.android.gms.ads.internal.client.zza
            public void onAdClicked() {
                Log.e(TAG, "onAdClickedggb3: ");
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdImpression() {
                Log.e(TAG, "onAdImpressionggb3: ");
            }
        });
    }

    public void Load_NativeBannerAds() {
        if (!All_Ads_Show.equalsIgnoreCase("true")) {
            return;
        }
        if (AD_MOB_STATUS.equalsIgnoreCase("true") && FACEBOOK_AD_STATUS.equalsIgnoreCase("true")) {
            if (app_Banner_AdsPriority.equalsIgnoreCase("google")) {
                LoadGoogleNativeSmall();
            } else if (app_Banner_AdsPriority.equalsIgnoreCase("facebook")) {
                showNativeFacebookBanner();
            }
        } else if (AD_MOB_STATUS.equalsIgnoreCase("true") && app_Banner_AdsPriority.equalsIgnoreCase("google")) {
            LoadGoogleNativeSmall();
        } else if (FACEBOOK_AD_STATUS.equalsIgnoreCase("true") && app_Banner_AdsPriority.equalsIgnoreCase("facebook")) {
            showNativeFacebookBanner();
        }
    }

    public void showNativeBanner(RelativeLayout banner_container) {
        if (All_Ads_Show.equalsIgnoreCase("true") && NativeBanner_Ads_On.equalsIgnoreCase("true")) {
            displayNativeBanner(banner_container);
        }
    }

    public void displayNativeBanner(RelativeLayout Adlayout) {
        if (FACEBOOK_AD_STATUS.equalsIgnoreCase("true") && app_Banner_AdsPriority.equalsIgnoreCase("facebook")) {
            RelativeLayout relativeLayout = fbNativeBanerLayout;
            if (relativeLayout != null) {
                if (relativeLayout.getParent() != null) {
                    ((ViewGroup) fbNativeBanerLayout.getParent()).removeView(fbNativeBanerLayout);
                }
                Adlayout.addView(fbNativeBanerLayout);
                return;
            }
            RelativeLayout relativeLayout2 = fbNativeBanerLayout2;
            if (relativeLayout2 != null) {
                if (relativeLayout2.getParent() != null) {
                    ((ViewGroup) fbNativeBanerLayout2.getParent()).removeView(fbNativeBanerLayout2);
                }
                Adlayout.addView(fbNativeBanerLayout2);
                return;
            }
            RelativeLayout relativeLayout3 = fbNativeBanerLayout3;
            if (relativeLayout3 != null) {
                if (relativeLayout3.getParent() != null) {
                    ((ViewGroup) fbNativeBanerLayout3.getParent()).removeView(fbNativeBanerLayout3);
                }
                Adlayout.addView(fbNativeBanerLayout3);
                return;
            }
            RelativeLayout relativeLayout4 = admobNativeBanerLayout;
            if (relativeLayout4 != null) {
                if (relativeLayout4.getParent() != null) {
                    ((ViewGroup) admobNativeBanerLayout.getParent()).removeView(admobNativeBanerLayout);
                }
                Adlayout.addView(admobNativeBanerLayout);
                return;
            }
            RelativeLayout relativeLayout5 = admobNativeBanerLayout2;
            if (relativeLayout5 != null) {
                if (relativeLayout5.getParent() != null) {
                    ((ViewGroup) admobNativeBanerLayout2.getParent()).removeView(admobNativeBanerLayout2);
                }
                Adlayout.addView(admobNativeBanerLayout2);
                return;
            }
            RelativeLayout relativeLayout6 = admobNativeBanerLayout3;
            if (relativeLayout6 != null) {
                if (relativeLayout6.getParent() != null) {
                    ((ViewGroup) admobNativeBanerLayout3.getParent()).removeView(admobNativeBanerLayout3);
                }
                Adlayout.addView(admobNativeBanerLayout3);
                showNativeFacebookBanner();
                return;
            }
        } else if (AD_MOB_STATUS.equalsIgnoreCase("true") && app_Banner_AdsPriority.equalsIgnoreCase("google")) {
            RelativeLayout relativeLayout7 = admobNativeBanerLayout;
            if (relativeLayout7 != null) {
                if (relativeLayout7.getParent() != null) {
                    ((ViewGroup) admobNativeBanerLayout.getParent()).removeView(admobNativeBanerLayout);
                }
                Adlayout.addView(admobNativeBanerLayout);
                return;
            }
            RelativeLayout relativeLayout8 = admobNativeBanerLayout2;
            if (relativeLayout8 != null) {
                if (relativeLayout8.getParent() != null) {
                    ((ViewGroup) admobNativeBanerLayout2.getParent()).removeView(admobNativeBanerLayout2);
                }
                Adlayout.addView(admobNativeBanerLayout2);
                return;
            }
            RelativeLayout relativeLayout9 = admobNativeBanerLayout3;
            if (relativeLayout9 != null) {
                if (relativeLayout9.getParent() != null) {
                    ((ViewGroup) admobNativeBanerLayout3.getParent()).removeView(admobNativeBanerLayout3);
                }
                Adlayout.addView(admobNativeBanerLayout3);
                return;
            }
            RelativeLayout relativeLayout10 = fbNativeBanerLayout;
            if (relativeLayout10 != null) {
                if (relativeLayout10.getParent() != null) {
                    ((ViewGroup) fbNativeBanerLayout.getParent()).removeView(fbNativeBanerLayout);
                }
                Adlayout.addView(fbNativeBanerLayout);
                return;
            }
            RelativeLayout relativeLayout11 = fbNativeBanerLayout2;
            if (relativeLayout11 != null) {
                if (relativeLayout11.getParent() != null) {
                    ((ViewGroup) fbNativeBanerLayout2.getParent()).removeView(fbNativeBanerLayout2);
                }
                Adlayout.addView(fbNativeBanerLayout2);
                return;
            }
            RelativeLayout relativeLayout12 = fbNativeBanerLayout3;
            if (relativeLayout12 != null) {
                if (relativeLayout12.getParent() != null) {
                    ((ViewGroup) fbNativeBanerLayout3.getParent()).removeView(fbNativeBanerLayout3);
                }
                Adlayout.addView(fbNativeBanerLayout3);
                LoadGoogleNativeSmall();
            }
        }
    }

    public void showNativeFacebookBanner() {
        if (FACEBOOK_AD_STATUS.equalsIgnoreCase("false")) {
            LoadGoogleNativeSmall();
            return;
        }
        fbNativeBanerLayout = new RelativeLayout(activity);
        nativeAd1 = new NativeBannerAd(activity, FB_BannerNative_ID1);

        nativeAd1.loadAd(nativeAd1.buildLoadAdConfig().withAdListener(new NativeAdListener() { // from class: com.superadtech.modids.7
            @Override
            public void onMediaDownloaded(Ad ad) {
                Log.e(TAG, "onMediaDownloadedfbnb1: ");
                fbNativeBanerLayout.removeAllViews();
                Inflate_FBNativeBannerADS(nativeAd1, fbNativeBanerLayout);
            }

            @Override // com.facebook.ads.AdListener
            public void onError(Ad ad, AdError adError) {
                Log.e(TAG, "onErrorfbnb1: ");
                fbNativeBanerLayout.removeAllViews();
                fbNativeBanerLayout = null;
                showNativeFacebookBanner2();
            }

            @Override // com.facebook.ads.AdListener
            public void onAdLoaded(Ad ad) {
                Log.e(TAG, "onAdLoadedfbnb1: ");
                if (nativeAd1 == null || nativeAd1 != ad) {
                    return;
                }
                nativeAd1.downloadMedia();
            }

            @Override // com.facebook.ads.AdListener
            public void onAdClicked(Ad ad) {
                Log.e(TAG, "onAdClickedfbnb1: ");
            }

            @Override // com.facebook.ads.AdListener
            public void onLoggingImpression(Ad ad) {
                Log.e(TAG, "onLoggingImpressionfbnb1: ");
            }
        }).build());
    }

    public void showNativeFacebookBanner2() {
        if (FACEBOOK_AD_STATUS.equalsIgnoreCase("false")) {
            LoadGoogleNativeSmall();
            return;
        }

        fbNativeBanerLayout2 = new RelativeLayout(activity);
        nativeAd1 = new NativeBannerAd(activity, FB_BannerNative_ID2);
        nativeAd1.loadAd(nativeAd1.buildLoadAdConfig().withAdListener(new NativeAdListener() { // from class: com.superadtech.modids.8
            @Override
            public void onMediaDownloaded(Ad ad) {
                Log.e(TAG, "onMediaDownloadedfbnb2: ");
                fbNativeBanerLayout2.removeAllViews();
                Inflate_FBNativeBannerADS(nativeAd1, fbNativeBanerLayout2);
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.e(TAG, "onErrorfbnb2: ");
                fbNativeBanerLayout2.removeAllViews();
                fbNativeBanerLayout2 = null;
                showNativeFacebookBanner3();
            }

            @Override // com.facebook.ads.AdListener
            public void onAdLoaded(Ad ad) {
                Log.e(TAG, "onAdLoadedfbnb2: ");
                if (nativeAd1 == null || nativeAd1 != ad) {
                    return;
                }
                nativeAd1.downloadMedia();
            }

            @Override // com.facebook.ads.AdListener
            public void onAdClicked(Ad ad) {
                Log.e(TAG, "onAdClickedfbnb2: ");
            }

            @Override // com.facebook.ads.AdListener
            public void onLoggingImpression(Ad ad) {
                Log.e(TAG, "onLoggingImpressionfbnb2: ");
            }
        }).build());
    }

    public void showNativeFacebookBanner3() {
        if (FACEBOOK_AD_STATUS.equalsIgnoreCase("false")) {
            LoadGoogleNativeSmall();
            return;
        }
        fbNativeBanerLayout3 = new RelativeLayout(activity);
        nativeAd1 = new NativeBannerAd(activity, FB_BannerNative_ID3);

        nativeAd1.loadAd(nativeAd1.buildLoadAdConfig().withAdListener(new NativeAdListener() { // from class: com.superadtech.modids.9
            @Override
            public void onMediaDownloaded(Ad ad) {
                fbNativeBanerLayout3.removeAllViews();
                Inflate_FBNativeBannerADS(nativeAd1, fbNativeBanerLayout3);
            }

            @Override // com.facebook.ads.AdListener
            public void onError(Ad ad, AdError adError) {
                Log.e(TAG, "onErrorfbnb3: ");
                fbNativeBanerLayout3.removeAllViews();
                fbNativeBanerLayout3 = null;
                if (AD_MOB_STATUS.equalsIgnoreCase("true") && app_Banner_AdsPriority.equalsIgnoreCase("facebook")) {
                    LoadGoogleNativeSmall();
                }
            }

            @Override // com.facebook.ads.AdListener
            public void onAdLoaded(Ad ad) {
                if (nativeAd1 == null || nativeAd1 != ad) {
                    return;
                }
                nativeAd1.downloadMedia();
            }

            @Override // com.facebook.ads.AdListener
            public void onAdClicked(Ad ad) {
            }

            @Override // com.facebook.ads.AdListener
            public void onLoggingImpression(Ad ad) {
            }
        }).build());
    }

    public void Inflate_FBNativeBannerADS(NativeBannerAd nativeBannerAd, ViewGroup cardView) {
        nativeBannerAd.unregisterView();
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = inflater.inflate(R.layout.ads_nb_fb, (ViewGroup) null);
        cardView.addView(view);
        NativeAdLayout nativeAdLayout = (NativeAdLayout) view.findViewById(R.id.nativview);
        LinearLayout adChoicesContainer = (LinearLayout) view.findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(activity, nativeBannerAd, nativeAdLayout);
        adChoicesContainer.removeAllViews();
        adChoicesContainer.addView(adOptionsView, 0);
        TextView nativeAdTitle = (TextView) view.findViewById(R.id.native_ad_title);
        TextView nativeAdSocialContext = (TextView) view.findViewById(R.id.native_ad_social_context);
        MediaView nativeAdIconView = (MediaView) view.findViewById(R.id.native_icon_view);
        TextView nativeAdCallToAction = (TextView) view.findViewById(R.id.b_name);
        nativeAdCallToAction.setText(nativeBannerAd.getAdCallToAction());
        nativeAdCallToAction.setVisibility(nativeBannerAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        nativeAdTitle.setText(nativeBannerAd.getAdvertiserName());
        nativeAdSocialContext.setText(nativeBannerAd.getAdBodyText());
        List<View> clickableViews = new ArrayList<>();
        clickableViews.add(nativeAdTitle);
        clickableViews.add(nativeAdCallToAction);
        clickableViews.add(nativeAdIconView);
        clickableViews.add(nativeAdSocialContext);
        nativeBannerAd.registerViewForInteraction(view, nativeAdIconView, clickableViews);
    }


    public void LoadGoogleNativeSmall() {
        if (AD_MOB_STATUS.equalsIgnoreCase("false")) {
            return;
        }
        admobNativeBanerLayout = new RelativeLayout(activity);
        AdLoader.Builder builder = new AdLoader.Builder(activity, AD_MOB_APP_ID_NativeBanner1);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
            public void onNativeAdLoaded(NativeAd NativeAd) {
                if (admobBannerNativeAd != null) {
                    admobBannerNativeAd.destroy();
                }
                admobBannerNativeAd = NativeAd;
                populateUnifiedNativeBannerAdView(NativeAd, admobNativeBanerLayout);
            }
        });
        AdLoader adLoader = builder.withAdListener(new com.google.android.gms.ads.AdListener() { // from class: com.superadtech.modids.11
            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                Log.e(TAG, "onAdFailedToLoadggnb1: ");
                admobNativeBanerLayout.removeAllViews();
                admobNativeBanerLayout = null;
                LoadGoogleNativeSmall2();
            }
        }).build();
        adLoader.loadAd(new AdRequest.Builder().build());
    }


    public void LoadGoogleNativeSmall2() {
        if (AD_MOB_STATUS.equalsIgnoreCase("false")) {
            return;
        }
        admobNativeBanerLayout2 = new RelativeLayout(activity);
        AdLoader.Builder builder = new AdLoader.Builder(activity, AD_MOB_APP_ID_NativeBanner2);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() { // from class: com.superadtech.modids.12
            @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
            public void onNativeAdLoaded(NativeAd NativeAd) {
                if (admobBannerNativeAd != null) {
                    admobBannerNativeAd.destroy();
                }
                admobBannerNativeAd = NativeAd;
                populateUnifiedNativeBannerAdView(NativeAd, admobNativeBanerLayout2);
            }
        });
        AdLoader adLoader = builder.withAdListener(new com.google.android.gms.ads.AdListener() { // from class: com.superadtech.modids.13
            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                Log.e(TAG, "onAdFailedToLoadggnb2: ");
                admobNativeBanerLayout2.removeAllViews();
                admobNativeBanerLayout2 = null;
                LoadGoogleNativeSmall3();
            }
        }).build();
        adLoader.loadAd(new AdRequest.Builder().build());
    }


    public void LoadGoogleNativeSmall3() {
        if (AD_MOB_STATUS.equalsIgnoreCase("false")) {
            return;
        }
        admobNativeBanerLayout3 = new RelativeLayout(activity);
        AdLoader.Builder builder = new AdLoader.Builder(activity, AD_MOB_APP_ID_NativeBanner3);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() { // from class: com.superadtech.modids.14
            @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
            public void onNativeAdLoaded(NativeAd NativeAd) {
                if (admobBannerNativeAd != null) {
                    admobBannerNativeAd.destroy();
                }
                admobBannerNativeAd = NativeAd;
                populateUnifiedNativeBannerAdView(NativeAd, admobNativeBanerLayout3);
            }
        });
        AdLoader adLoader = builder.withAdListener(new com.google.android.gms.ads.AdListener() { // from class: com.superadtech.modids.15
            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                admobNativeBanerLayout3.removeAllViews();
                admobNativeBanerLayout3 = null;
                if (FACEBOOK_AD_STATUS.equalsIgnoreCase("true") && app_Banner_AdsPriority.equalsIgnoreCase("google")) {
                    showNativeFacebookBanner();
                }
            }
        }).build();
        adLoader.loadAd(new AdRequest.Builder().build());
    }

    public void populateUnifiedNativeBannerAdView(NativeAd nativeAd, ViewGroup nativeAdContainer) {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = inflater.inflate(R.layout.google_small_native_banner, (ViewGroup) null);
        nativeAdContainer.removeAllViews();
        nativeAdContainer.addView(view);
        NativeAdView adView = (NativeAdView) view.findViewById(R.id.ntbnradview);
        adView.setMediaView((com.google.android.gms.ads.nativead.MediaView) adView.findViewById(R.id.ad_medianb));
        adView.setHeadlineView(adView.findViewById(R.id.ad_headlinenb));
        adView.setBodyView(adView.findViewById(R.id.ad_bodynb));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_actionnb));
        adView.setIconView(adView.findViewById(R.id.ad_app_iconnb));
        adView.setStarRatingView(adView.findViewById(R.id.ad_starsnb));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertisernb));
        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }
        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((TextView) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }
        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }
        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }
        adView.setNativeAd(nativeAd);
    }

    public void ads_NativeCall(ViewGroup native_container) {
        if (!All_Ads_Show.equalsIgnoreCase("true")) {
            return;
        }

        if (app_Native_AdsPriority.equalsIgnoreCase("google") || app_Native_AdsPriority.equalsIgnoreCase("facebook")) {
            if (app_NativeAdCodeType.equalsIgnoreCase("new")) {
                showNativeNew(native_container);
            } else {
                showNative(native_container);
            }
        } else {
            native_container.setVisibility(View.GONE);
        }
    }

    public void Load_NativeNewAds() {
        if (!All_Ads_Show.equalsIgnoreCase("true")) {
            return;
        }

        if (AD_MOB_STATUS.equalsIgnoreCase("true") && FACEBOOK_AD_STATUS.equalsIgnoreCase("true")) {
            if (app_Native_AdsPriority.equalsIgnoreCase("google")) {
                LoadAdNativeNew();
            } else if (app_Native_AdsPriority.equalsIgnoreCase("facebook")) {
                showFacebookNativeNew();
            }
        } else if (AD_MOB_STATUS.equalsIgnoreCase("true") && app_Native_AdsPriority.equalsIgnoreCase("google")) {
            LoadAdNativeNew();
        } else if (FACEBOOK_AD_STATUS.equalsIgnoreCase("true") && app_Native_AdsPriority.equalsIgnoreCase("facebook")) {
            showFacebookNativeNew();
        }
    }

    public void showNativeNew(ViewGroup banner_container) {
        if (All_Ads_Show.equalsIgnoreCase("true") && Native_Ads_On.equalsIgnoreCase("true")) {
            displayNativeNew(banner_container);
        }
    }

    public void displayNativeNew(ViewGroup Adlayout) {
        if (FACEBOOK_AD_STATUS.equalsIgnoreCase("true") && app_Native_AdsPriority.equalsIgnoreCase("facebook")) {
            LinearLayout linearLayout = fbNativeNewLayout;
            if (linearLayout != null) {
                if (linearLayout.getParent() != null) {
                    ((ViewGroup) fbNativeNewLayout.getParent()).removeView(fbNativeNewLayout);
                }
                Adlayout.addView(fbNativeNewLayout);
                return;
            }
            LinearLayout linearLayout2 = fbNativeNewLayout2;
            if (linearLayout2 != null) {
                if (linearLayout2.getParent() != null) {
                    ((ViewGroup) fbNativeNewLayout2.getParent()).removeView(fbNativeNewLayout2);
                }
                Adlayout.addView(fbNativeNewLayout2);
                return;
            }
            LinearLayout linearLayout3 = fbNativeNewLayout3;
            if (linearLayout3 != null) {
                if (linearLayout3.getParent() != null) {
                    ((ViewGroup) fbNativeNewLayout3.getParent()).removeView(fbNativeNewLayout3);
                }
                Adlayout.addView(fbNativeNewLayout3);
                return;
            }
            LinearLayout linearLayout4 = fbNativeNewLayout4;
            if (linearLayout4 != null) {
                if (linearLayout4.getParent() != null) {
                    ((ViewGroup) fbNativeNewLayout4.getParent()).removeView(fbNativeNewLayout4);
                }
                Adlayout.addView(fbNativeNewLayout4);
                return;
            }
            LinearLayout linearLayout5 = admobNativeNewLayout;
            if (linearLayout5 != null) {
                if (linearLayout5.getParent() != null) {
                    ((ViewGroup) admobNativeNewLayout.getParent()).removeView(admobNativeNewLayout);
                }
                Adlayout.addView(admobNativeNewLayout);
                return;
            }
            LinearLayout linearLayout6 = admobNativeNewLayout2;
            if (linearLayout6 != null) {
                if (linearLayout6.getParent() != null) {
                    ((ViewGroup) admobNativeNewLayout2.getParent()).removeView(admobNativeNewLayout2);
                }
                Adlayout.addView(admobNativeNewLayout2);
                return;
            }
            LinearLayout linearLayout7 = admobNativeNewLayout3;
            if (linearLayout7 != null) {
                if (linearLayout7.getParent() != null) {
                    ((ViewGroup) admobNativeNewLayout3.getParent()).removeView(admobNativeNewLayout3);
                }
                Adlayout.addView(admobNativeNewLayout3);
                return;
            }
            LinearLayout linearLayout8 = admobNativeNewLayout4;
            if (linearLayout8 != null) {
                if (linearLayout8.getParent() != null) {
                    ((ViewGroup) admobNativeNewLayout4.getParent()).removeView(admobNativeNewLayout4);
                }
                Adlayout.addView(admobNativeNewLayout4);
                showFacebookNativeNew();
                return;
            }

        } else if (AD_MOB_STATUS.equalsIgnoreCase("true") && app_Native_AdsPriority.equalsIgnoreCase("google")) {
            LinearLayout linearLayout9 = admobNativeNewLayout;
            if (linearLayout9 != null) {
                if (linearLayout9.getParent() != null) {
                    ((ViewGroup) admobNativeNewLayout.getParent()).removeView(admobNativeNewLayout);
                }
                Adlayout.addView(admobNativeNewLayout);
                return;
            }
            LinearLayout linearLayout10 = admobNativeNewLayout2;
            if (linearLayout10 != null) {
                if (linearLayout10.getParent() != null) {
                    ((ViewGroup) admobNativeNewLayout2.getParent()).removeView(admobNativeNewLayout2);
                }
                Adlayout.addView(admobNativeNewLayout2);
                return;
            }
            LinearLayout linearLayout11 = admobNativeNewLayout3;
            if (linearLayout11 != null) {
                if (linearLayout11.getParent() != null) {
                    ((ViewGroup) admobNativeNewLayout3.getParent()).removeView(admobNativeNewLayout3);
                }
                Adlayout.addView(admobNativeNewLayout3);
                return;
            }
            LinearLayout linearLayout12 = admobNativeNewLayout4;
            if (linearLayout12 != null) {
                if (linearLayout12.getParent() != null) {
                    ((ViewGroup) admobNativeNewLayout4.getParent()).removeView(admobNativeNewLayout4);
                }
                Adlayout.addView(admobNativeNewLayout4);
                return;
            }
            LinearLayout linearLayout13 = fbNativeNewLayout;
            if (linearLayout13 != null) {
                if (linearLayout13.getParent() != null) {
                    ((ViewGroup) fbNativeNewLayout.getParent()).removeView(fbNativeNewLayout);
                }
                Adlayout.addView(fbNativeNewLayout);
                return;
            }
            LinearLayout linearLayout14 = fbNativeNewLayout2;
            if (linearLayout14 != null) {
                if (linearLayout14.getParent() != null) {
                    ((ViewGroup) fbNativeNewLayout2.getParent()).removeView(fbNativeNewLayout2);
                }
                Adlayout.addView(fbNativeNewLayout2);
                return;
            }
            LinearLayout linearLayout15 = fbNativeNewLayout3;
            if (linearLayout15 != null) {
                if (linearLayout15.getParent() != null) {
                    ((ViewGroup) fbNativeNewLayout3.getParent()).removeView(fbNativeNewLayout3);
                }
                Adlayout.addView(fbNativeNewLayout3);
                return;
            }
            LinearLayout linearLayout16 = fbNativeNewLayout4;
            if (linearLayout16 != null) {
                if (linearLayout16.getParent() != null) {
                    ((ViewGroup) fbNativeNewLayout4.getParent()).removeView(fbNativeNewLayout4);
                }
                Adlayout.addView(fbNativeNewLayout4);
                LoadAdNativeNew();
            }
        } else {

        }
    }

    public void showFacebookNativeNew() {
        if (FACEBOOK_AD_STATUS.equalsIgnoreCase("false")) {
            return;
        }
        fbNativeNewLayout = new LinearLayout(activity);
        fbNativeNewLayout.setOrientation(LinearLayout.VERTICAL);
        fbNativeNewLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        final com.facebook.ads.NativeAd nativeAd = new com.facebook.ads.NativeAd(activity, FB_Native_ID1);
        NativeAdListener nativeAdListener = new NativeAdListener() { // from class: com.superadtech.modids.16
            @Override // com.facebook.ads.NativeAdListener
            public void onMediaDownloaded(Ad ad) {
            }

            @Override // com.facebook.ads.AdListener
            public void onError(Ad ad, AdError adError) {
                fbNativeNewLayout = null;
                showFacebookNativeNew2();
            }

            @Override // com.facebook.ads.AdListener
            public void onAdLoaded(Ad ad) {
                if (nativeAd == null || nativeAd != ad) {
                    return;
                }
                inflateFBNativeAd(nativeAd, fbNativeNewLayout);
            }

            @Override // com.facebook.ads.AdListener
            public void onAdClicked(Ad ad) {
            }

            @Override // com.facebook.ads.AdListener
            public void onLoggingImpression(Ad ad) {
            }
        };
        nativeAd.loadAd(nativeAd.buildLoadAdConfig().withAdListener(nativeAdListener).build());
    }

    public void showFacebookNativeNew2() {
        if (FACEBOOK_AD_STATUS.equalsIgnoreCase("false")) {
            return;
        }

        fbNativeNewLayout2 = new LinearLayout(activity);
        fbNativeNewLayout2.setOrientation(LinearLayout.VERTICAL);
        fbNativeNewLayout2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        final com.facebook.ads.NativeAd nativeAd = new com.facebook.ads.NativeAd(activity, FB_Native_ID2);
        NativeAdListener nativeAdListener = new NativeAdListener() { // from class: com.superadtech.modids.17
            @Override // com.facebook.ads.NativeAdListener
            public void onMediaDownloaded(Ad ad) {
            }

            @Override // com.facebook.ads.AdListener
            public void onError(Ad ad, AdError adError) {
                fbNativeNewLayout2 = null;
                showFacebookNativeNew3();
            }

            @Override // com.facebook.ads.AdListener
            public void onAdLoaded(Ad ad) {

                if (nativeAd == null || nativeAd != ad) {
                    return;
                }
                inflateFBNativeAd(nativeAd, fbNativeNewLayout2);
            }

            @Override // com.facebook.ads.AdListener
            public void onAdClicked(Ad ad) {
            }

            @Override // com.facebook.ads.AdListener
            public void onLoggingImpression(Ad ad) {
            }
        };
        nativeAd.loadAd(nativeAd.buildLoadAdConfig().withAdListener(nativeAdListener).build());
    }

    public void showFacebookNativeNew3() {
        if (FACEBOOK_AD_STATUS.equalsIgnoreCase("false")) {
            return;
        }

        fbNativeNewLayout3 = new LinearLayout(activity);
        fbNativeNewLayout3.setOrientation(LinearLayout.VERTICAL);
        fbNativeNewLayout3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        final com.facebook.ads.NativeAd nativeAd = new com.facebook.ads.NativeAd(activity, FB_Native_ID3);
        NativeAdListener nativeAdListener = new NativeAdListener() { // from class: com.superadtech.modids.18
            @Override // com.facebook.ads.NativeAdListener
            public void onMediaDownloaded(Ad ad) {
            }

            @Override // com.facebook.ads.AdListener
            public void onError(Ad ad, AdError adError) {
                fbNativeNewLayout3 = null;
                showFacebookNativeNew4();
            }

            @Override // com.facebook.ads.AdListener
            public void onAdLoaded(Ad ad) {
                if (nativeAd == null || nativeAd != ad) {
                    return;
                }
                inflateFBNativeAd(nativeAd, fbNativeNewLayout3);
            }

            @Override // com.facebook.ads.AdListener
            public void onAdClicked(Ad ad) {
            }

            @Override // com.facebook.ads.AdListener
            public void onLoggingImpression(Ad ad) {
            }
        };
        nativeAd.loadAd(nativeAd.buildLoadAdConfig().withAdListener(nativeAdListener).build());
    }

    public void showFacebookNativeNew4() {
        if (FACEBOOK_AD_STATUS.equalsIgnoreCase("false")) {
            return;
        }

        fbNativeNewLayout4 = new LinearLayout(activity);
        fbNativeNewLayout4.setOrientation(LinearLayout.VERTICAL);
        fbNativeNewLayout4.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        final com.facebook.ads.NativeAd nativeAd = new com.facebook.ads.NativeAd(activity, FB_Native_ID4);
        NativeAdListener nativeAdListener = new NativeAdListener() { // from class: com.superadtech.modids.19
            @Override
            public void onMediaDownloaded(Ad ad) {
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                fbNativeNewLayout4 = null;
                if (AD_MOB_STATUS.equalsIgnoreCase("true") && app_Native_AdsPriority.equalsIgnoreCase("facebook")) {
                    LoadAdNativeNew();
                }
            }

            @Override
            public void onAdLoaded(Ad ad) {

                if (nativeAd == null || nativeAd != ad) {
                    return;
                }
                inflateFBNativeAd(nativeAd, fbNativeNewLayout4);
            }

            @Override // com.facebook.ads.AdListener
            public void onAdClicked(Ad ad) {
            }

            @Override // com.facebook.ads.AdListener
            public void onLoggingImpression(Ad ad) {
            }
        };
        nativeAd.loadAd(nativeAd.buildLoadAdConfig().withAdListener(nativeAdListener).build());
    }

    public void inflateFBNativeAd(com.facebook.ads.NativeAd nativeAd, ViewGroup card) {
        nativeAd.unregisterView();
        LayoutInflater inflater = LayoutInflater.from(activity);
        View adView = inflater.inflate(R.layout.fb_native_layout, (ViewGroup) null);
        card.removeAllViews();
        card.addView(adView);
        NativeAdLayout nativeAdLayout = (NativeAdLayout) adView.findViewById(R.id.nativview);
        LinearLayout adChoicesContainer = (LinearLayout) adView.findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(activity, nativeAd, nativeAdLayout);
        adChoicesContainer.removeAllViews();
        adChoicesContainer.addView(adOptionsView, 0);
        MediaView nativeAdIcon = (MediaView) adView.findViewById(R.id.native_ad_icon);
        TextView nativeAdTitle = (TextView) adView.findViewById(R.id.native_ad_title);
        MediaView nativeAdMedia = (MediaView) adView.findViewById(R.id.native_ad_media);
        TextView nativeAdSocialContext = (TextView) adView.findViewById(R.id.native_ad_social_context);
        TextView nativeAdBody = (TextView) adView.findViewById(R.id.native_ad_body);
        TextView sponsoredLabel = (TextView) adView.findViewById(R.id.native_ad_sponsored_label);
        TextView nativeAdCallToAction = (TextView) adView.findViewById(R.id.native_ad_call_to_action);
        nativeAdTitle.setText(nativeAd.getAdvertiserName());
        nativeAdBody.setText(nativeAd.getAdBodyText());
        nativeAdSocialContext.setText(nativeAd.getAdSocialContext());
        nativeAdCallToAction.setVisibility(nativeAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        if (!Native_Btn_Text_Size.isEmpty()) {
            nativeAdCallToAction.setTextSize(Float.parseFloat(Native_Btn_Text_Size));
        }
        if (!Native_Btn_text.isEmpty()) {
            nativeAdCallToAction.setText(Native_Btn_text);
        } else {
            nativeAdCallToAction.setText(nativeAd.getAdCallToAction());
        }
        if (!Native_Btn_Text_Color.isEmpty()) {
            nativeAdCallToAction.setTextColor(Color.parseColor(Native_Btn_Text_Color));
        }
        if (!Native_Btn_Color.isEmpty()) {
            nativeAdCallToAction.setBackgroundColor(Color.parseColor(Native_Btn_Color));
        }
        sponsoredLabel.setText(nativeAd.getSponsoredTranslation());
        List<View> clickableViews = new ArrayList<>();
        clickableViews.add(nativeAdTitle);
        clickableViews.add(nativeAdBody);
        clickableViews.add(nativeAdCallToAction);
        clickableViews.add(nativeAdIcon);
        clickableViews.add(nativeAdSocialContext);
        nativeAd.registerViewForInteraction(adView, nativeAdMedia, nativeAdIcon, clickableViews);
    }

    public void LoadAdNativeNew() {
        if (AD_MOB_STATUS.equalsIgnoreCase("false")) {
            return;
        }
        admobNativeNewLayout = new LinearLayout(activity);
        admobNativeNewLayout.setOrientation(LinearLayout.VERTICAL);
        admobNativeNewLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        AdLoader.Builder builder = new AdLoader.Builder(activity, AD_MOB_APP_ID_Native1);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() { // from class: com.superadtech.modids.20
            @Override
            public void onNativeAdLoaded(NativeAd NativeAd) {
                if (admobNativeAd_preLoad != null) {
                    admobNativeAd_preLoad.destroy();
                }
                admobNativeAd_preLoad = NativeAd;
                populateUnifiedNativeAdView(NativeAd, admobNativeNewLayout);
            }
        });
        AdLoader adLoader = builder.withAdListener(new com.google.android.gms.ads.AdListener() { // from class: com.superadtech.modids.21
            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                admobNativeNewLayout.removeAllViews();
                admobNativeNewLayout = null;
                LoadAdNativeNew2();
            }
        }).build();
        adLoader.loadAd(new AdRequest.Builder().build());
    }

    public void LoadAdNativeNew2() {
        if (AD_MOB_STATUS.equalsIgnoreCase("false")) {

            return;
        }
        admobNativeNewLayout2 = new LinearLayout(activity);
        admobNativeNewLayout2.setOrientation(LinearLayout.VERTICAL);
        admobNativeNewLayout2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        AdLoader.Builder builder = new AdLoader.Builder(activity, AD_MOB_APP_ID_Native2);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() { // from class: com.superadtech.modids.22
            @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
            public void onNativeAdLoaded(NativeAd NativeAd) {
                if (admobNativeAd_preLoad != null) {
                    admobNativeAd_preLoad.destroy();
                }
                admobNativeAd_preLoad = NativeAd;
                populateUnifiedNativeAdView(NativeAd, admobNativeNewLayout2);
            }
        });
        AdLoader adLoader = builder.withAdListener(new com.google.android.gms.ads.AdListener() { // from class: com.superadtech.modids.23
            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                admobNativeNewLayout2.removeAllViews();
                admobNativeNewLayout2 = null;
                LoadAdNativeNew3();
            }
        }).build();
        adLoader.loadAd(new AdRequest.Builder().build());
    }

    public void LoadAdNativeNew3() {
        if (AD_MOB_STATUS.equalsIgnoreCase("false")) {
            return;
        }
        admobNativeNewLayout3 = new LinearLayout(activity);
        admobNativeNewLayout3.setOrientation(LinearLayout.VERTICAL);
        admobNativeNewLayout3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        AdLoader.Builder builder = new AdLoader.Builder(activity, AD_MOB_APP_ID_Native3);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            @Override
            public void onNativeAdLoaded(NativeAd NativeAd) {
                if (admobNativeAd_preLoad != null) {
                    admobNativeAd_preLoad.destroy();
                }
                admobNativeAd_preLoad = NativeAd;
                populateUnifiedNativeAdView(NativeAd, admobNativeNewLayout3);
            }
        });
        AdLoader adLoader = builder.withAdListener(new com.google.android.gms.ads.AdListener() { // from class: com.superadtech.modids.25
            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                admobNativeNewLayout3.removeAllViews();
                admobNativeNewLayout3 = null;
                LoadAdNativeNew4();
            }
        }).build();
        adLoader.loadAd(new AdRequest.Builder().build());
    }

    public void LoadAdNativeNew4() {
        if (AD_MOB_STATUS.equalsIgnoreCase("false")) {

            return;
        }
        admobNativeNewLayout4 = new LinearLayout(activity);
        admobNativeNewLayout4.setOrientation(LinearLayout.VERTICAL);
        admobNativeNewLayout4.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        AdLoader.Builder builder = new AdLoader.Builder(activity, AD_MOB_APP_ID_Native4);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() { // from class: com.superadtech.modids.26
            @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
            public void onNativeAdLoaded(NativeAd NativeAd) {
                if (admobNativeAd_preLoad != null) {
                    admobNativeAd_preLoad.destroy();
                }
                admobNativeAd_preLoad = NativeAd;
                populateUnifiedNativeAdView(NativeAd, admobNativeNewLayout4);
            }
        });
        AdLoader adLoader = builder.withAdListener(new com.google.android.gms.ads.AdListener() { // from class: com.superadtech.modids.27
            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                admobNativeNewLayout4.removeAllViews();
                admobNativeNewLayout4 = null;
                if (FACEBOOK_AD_STATUS.equalsIgnoreCase("true") && app_Native_AdsPriority.equalsIgnoreCase("google")) {
                    showFacebookNativeNew();
                }
            }
        }).build();
        adLoader.loadAd(new AdRequest.Builder().build());
    }

    public void populateUnifiedNativeAdView(NativeAd nativeAd, ViewGroup nativeAdContainer) {

        View view;
        nativeAdContainer.setVisibility(View.VISIBLE);
        LayoutInflater inflater = LayoutInflater.from(activity);

        if (Native_Ad_Normal_Size_Lyout.equals("true")) {
            view = inflater.inflate(R.layout.native_admob_normal_size, (ViewGroup) null);
        } else if (Native_Ad_Small_Size_Lyout.equals("true")) {
            view = inflater.inflate(R.layout.native_admob_small_size, (ViewGroup) null);
        } else {
            view = inflater.inflate(R.layout.native_admob_normal_size, (ViewGroup) null);
        }

        nativeAdContainer.removeAllViews();
        nativeAdContainer.addView(view);
        NativeAdView adView = (NativeAdView) view.findViewById(R.id.uadview);
        adView.setMediaView((com.google.android.gms.ads.nativead.MediaView) adView.findViewById(R.id.ad_media));
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        if (!Native_Btn_Color.isEmpty()) {
            adView.findViewById(R.id.ad_call_to_action).setBackgroundColor(Color.parseColor(Native_Btn_Color));
        }
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        adView.setPriceView(adView.findViewById(R.id.ad_price));
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
        adView.setStoreView(adView.findViewById(R.id.ad_store));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));
        Objects.requireNonNull(adView.getMediaView()).setMediaContent(nativeAd.getMediaContent());

        if (!Native_Background_Color.isEmpty()) {
            adView.findViewById(R.id.nativebackground).setBackgroundColor(Color.parseColor(Native_Background_Color));
        }

        if (!Native_Text_Color.isEmpty()) {
            TextView headlineTextView = adView.findViewById(R.id.ad_headline);
            if (headlineTextView != null) {
                headlineTextView.setTextColor(Color.parseColor(Native_Text_Color));
            }
            TextView ad_bodyz = adView.findViewById(R.id.ad_body);
            if (ad_bodyz != null) {
                ad_bodyz.setTextColor(Color.parseColor(Native_Text_Color));
            }
        }

        if (!Native_Btn_Height.isEmpty()) {
            ViewGroup.LayoutParams layoutParams = adView.findViewById(R.id.ad_call_to_action).getLayoutParams();
            layoutParams.height = Integer.parseInt(Native_Btn_Height);
            adView.findViewById(R.id.ad_call_to_action).setLayoutParams(layoutParams);
        }

        if (!Native_Ads_Btn_Corner_Radius.isEmpty()) {
            GradientDrawable drawable = (GradientDrawable) Objects.requireNonNull(ContextCompat.getDrawable(activity, R.drawable.dynamic_round_corner_native_lyt)).mutate();
            drawable.setCornerRadius(Float.parseFloat(Native_Ads_Btn_Corner_Radius));
            drawable.setColor(Color.parseColor(Native_Btn_Color));
            adView.findViewById(R.id.ad_call_to_action).setBackground(drawable);
        }

        ((TextView) Objects.requireNonNull(adView.getHeadlineView())).setText(nativeAd.getHeadline());
        if (nativeAd.getBody() != null) {
            Objects.requireNonNull(adView.getBodyView()).setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        } else {
            Objects.requireNonNull(adView.getBodyView()).setVisibility(View.INVISIBLE);
        }

        if (!Native_Btn_Text_Size.isEmpty()) {
            ((TextView) Objects.requireNonNull(adView.getCallToActionView())).setTextSize(Float.parseFloat(Native_Btn_Text_Size));
        }
        if (!Native_Btn_Text_Color.isEmpty()) {
            ((TextView) Objects.requireNonNull(adView.getCallToActionView())).setTextColor(Color.parseColor(Native_Btn_Text_Color));
        }

        if (nativeAd.getCallToAction() != null) {
            Objects.requireNonNull(adView.getCallToActionView()).setVisibility(View.VISIBLE);
            if (!Native_Btn_text.isEmpty()) {
                ((TextView) adView.getCallToActionView()).setText(Native_Btn_text);
            } else {
                ((TextView) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
            }
        } else {
            Objects.requireNonNull(adView.getCallToActionView()).setVisibility(View.INVISIBLE);
        }
        if (nativeAd.getIcon() == null) {
            Objects.requireNonNull(adView.getIconView()).setVisibility(View.GONE);
        } else {
            ((ImageView) Objects.requireNonNull(adView.getIconView())).setImageDrawable(nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }
        if (nativeAd.getStarRating() == null) {
            Objects.requireNonNull(adView.getStarRatingView()).setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) Objects.requireNonNull(adView.getStarRatingView())).setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }
        adView.setNativeAd(nativeAd);
    }

    public void showNative(ViewGroup nativeAdContainer) {
        if (All_Ads_Show.equalsIgnoreCase("true") && Native_Ads_On.equalsIgnoreCase("true")) {
            displayNative(nativeAdContainer);
        }
    }

    public void displayNative(ViewGroup nativeAdContainer) {
        if (AD_MOB_STATUS.equalsIgnoreCase("true") && FACEBOOK_AD_STATUS.equalsIgnoreCase("true")) {
            if (app_Native_AdsPriority.equalsIgnoreCase("google")) {
                showAdmobNative(nativeAdContainer, AD_MOB_APP_ID_Native1);
            } else if (app_Native_AdsPriority.equalsIgnoreCase("facebook")) {
                showFacebookNative(nativeAdContainer, FB_Native_ID1);
            }
        } else if (AD_MOB_STATUS.equalsIgnoreCase("true") && app_Native_AdsPriority.equalsIgnoreCase("google")) {
            showAdmobNative(nativeAdContainer, AD_MOB_APP_ID_Native1);
        } else if (FACEBOOK_AD_STATUS.equalsIgnoreCase("true") && app_Native_AdsPriority.equalsIgnoreCase("facebook")) {
            showFacebookNative(nativeAdContainer, FB_Native_ID1);
        }
    }

    public void showFacebookNative(final ViewGroup nativeAdContainer, final String facebook_n1) {
        if (FACEBOOK_AD_STATUS.equalsIgnoreCase("false")) {
            showAdmobNative(nativeAdContainer, AD_MOB_APP_ID_Native1);
            return;
        }

        if (fbNativeAd_preLoad == null) {
            final com.facebook.ads.NativeAd nativeAd2 = new com.facebook.ads.NativeAd(activity, facebook_n1);
            nativeAd2.loadAd(nativeAd2.buildLoadAdConfig().withAdListener(new NativeAdListener() { // from class: com.superadtech.modids.28
                @Override // com.facebook.ads.NativeAdListener
                public void onMediaDownloaded(Ad ad) {
                }

                @Override // com.facebook.ads.AdListener
                public void onError(Ad ad, AdError adError) {
                    showFacebookNative2(nativeAdContainer, FB_Native_ID2);
                }

                @Override // com.facebook.ads.AdListener
                public void onAdLoaded(Ad ad) {
                    if (nativeAd2 == null || nativeAd2 != ad) {
                        return;
                    }
                    inflate_NATIV_FB(nativeAd2, nativeAdContainer, facebook_n1);
                }

                @Override // com.facebook.ads.AdListener
                public void onAdClicked(Ad ad) {
                }

                @Override // com.facebook.ads.AdListener
                public void onLoggingImpression(Ad ad) {
                }
            }).build());
            return;
        }
        state_fbNative = "Start";
        inflate_NATIV_FB(fbNativeAd_preLoad, nativeAdContainer, facebook_n1);
    }

    public void showFacebookNative2(final ViewGroup nativeAdContainer, final String facebook_n2) {
        if (FACEBOOK_AD_STATUS.equalsIgnoreCase("false")) {
            showAdmobNative(nativeAdContainer, AD_MOB_APP_ID_Native1);
            return;
        }

        if (fbNativeAd_preLoad == null) {
            final com.facebook.ads.NativeAd nativeAd2 = new com.facebook.ads.NativeAd(activity, facebook_n2);
            nativeAd2.loadAd(nativeAd2.buildLoadAdConfig().withAdListener(new NativeAdListener() {
                @Override // com.facebook.ads.NativeAdListener
                public void onMediaDownloaded(Ad ad) {
                }

                @Override // com.facebook.ads.AdListener
                public void onError(Ad ad, AdError adError) {
                    showFacebookNative3(nativeAdContainer, FB_Native_ID3);
                }

                @Override // com.facebook.ads.AdListener
                public void onAdLoaded(Ad ad) {
                    if (nativeAd2 == null || nativeAd2 != ad) {
                        return;
                    }
                    inflate_NATIV_FB(nativeAd2, nativeAdContainer, facebook_n2);
                }

                @Override // com.facebook.ads.AdListener
                public void onAdClicked(Ad ad) {
                }

                @Override // com.facebook.ads.AdListener
                public void onLoggingImpression(Ad ad) {
                }
            }).build());
            return;
        }
        state_fbNative = "Start";
        inflate_NATIV_FB(fbNativeAd_preLoad, nativeAdContainer, facebook_n2);
    }

    public void showFacebookNative3(final ViewGroup nativeAdContainer, final String facebook_n3) {
        if (FACEBOOK_AD_STATUS.equalsIgnoreCase("false")) {
            showAdmobNative(nativeAdContainer, AD_MOB_APP_ID_Native1);
            return;
        }

        if (fbNativeAd_preLoad == null) {
            final com.facebook.ads.NativeAd nativeAd2 = new com.facebook.ads.NativeAd(activity, facebook_n3);
            nativeAd2.loadAd(nativeAd2.buildLoadAdConfig().withAdListener(new NativeAdListener() { // from class: com.superadtech.modids.30
                @Override // com.facebook.ads.NativeAdListener
                public void onMediaDownloaded(Ad ad) {
                    Log.e(TAG, "onMediaDownloaded: ");
                }

                @Override // com.facebook.ads.AdListener
                public void onError(Ad ad, AdError adError) {
                    Log.e(TAG, "onError: ");
                    showFacebookNative4(nativeAdContainer, FB_Native_ID4);
                }

                @Override // com.facebook.ads.AdListener
                public void onAdLoaded(Ad ad) {
                    Log.e(TAG, "onAdLoaded: ");
                    if (nativeAd2 == null || nativeAd2 != ad) {
                        return;
                    }
                    inflate_NATIV_FB(nativeAd2, nativeAdContainer, facebook_n3);
                }

                @Override // com.facebook.ads.AdListener
                public void onAdClicked(Ad ad) {
                    Log.e(TAG, "onAdClicked: ");
                }

                @Override // com.facebook.ads.AdListener
                public void onLoggingImpression(Ad ad) {
                    Log.e(TAG, "onLoggingImpression: ");
                }
            }).build());
        } else {
            state_fbNative = "Start";
            inflate_NATIV_FB(fbNativeAd_preLoad, nativeAdContainer, facebook_n3);
        }
    }

    public void showFacebookNative4(final ViewGroup nativeAdContainer, final String facebook_n4) {

        if (FACEBOOK_AD_STATUS.equalsIgnoreCase("false")) {
            showAdmobNative(nativeAdContainer, AD_MOB_APP_ID_Native1);
            return;
        }


        if (fbNativeAd_preLoad == null) {
            final com.facebook.ads.NativeAd nativeAd2 = new com.facebook.ads.NativeAd(activity, facebook_n4);
            nativeAd2.loadAd(nativeAd2.buildLoadAdConfig().withAdListener(new NativeAdListener() { // from class: com.superadtech.modids.31
                @Override // com.facebook.ads.NativeAdListener
                public void onMediaDownloaded(Ad ad) {
                }

                @Override // com.facebook.ads.AdListener
                public void onError(Ad ad, AdError adError) {
                    if (AD_MOB_STATUS.equalsIgnoreCase("true") && app_Native_AdsPriority.equalsIgnoreCase("facebook")) {
                        showAdmobNative(nativeAdContainer, AD_MOB_APP_ID_Native1);
                    }
                }

                @Override // com.facebook.ads.AdListener
                public void onAdLoaded(Ad ad) {
                    if (nativeAd2 == null || nativeAd2 != ad) {
                        return;
                    }
                    inflate_NATIV_FB(nativeAd2, nativeAdContainer, facebook_n4);
                }

                @Override // com.facebook.ads.AdListener
                public void onAdClicked(Ad ad) {
                }

                @Override // com.facebook.ads.AdListener
                public void onLoggingImpression(Ad ad) {
                }
            }).build());
            return;
        }
        state_fbNative = "Start";
        inflate_NATIV_FB(fbNativeAd_preLoad, nativeAdContainer, facebook_n4);
    }

    public void inflate_NATIV_FB(com.facebook.ads.NativeAd nativeAd, final ViewGroup card, final String facebook_n) {
        nativeAd.unregisterView();
        LayoutInflater inflater = LayoutInflater.from(activity);
        View adView = inflater.inflate(R.layout.fb_native_layout, (ViewGroup) null);
        card.removeAllViews();
        card.addView(adView);
        NativeAdLayout nativeAdLayout = (NativeAdLayout) adView.findViewById(R.id.nativview);
        LinearLayout adChoicesContainer = (LinearLayout) adView.findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(activity, nativeAd, nativeAdLayout);
        adChoicesContainer.removeAllViews();
        adChoicesContainer.addView(adOptionsView, 0);
        MediaView nativeAdIcon = (MediaView) adView.findViewById(R.id.native_ad_icon);
        TextView nativeAdTitle = (TextView) adView.findViewById(R.id.native_ad_title);
        MediaView nativeAdMedia = (MediaView) adView.findViewById(R.id.native_ad_media);
        TextView nativeAdSocialContext = (TextView) adView.findViewById(R.id.native_ad_social_context);
        TextView nativeAdBody = (TextView) adView.findViewById(R.id.native_ad_body);
        TextView sponsoredLabel = (TextView) adView.findViewById(R.id.native_ad_sponsored_label);
        TextView nativeAdCallToAction = (TextView) adView.findViewById(R.id.native_ad_call_to_action);
        nativeAdTitle.setText(nativeAd.getAdvertiserName());
        nativeAdBody.setText(nativeAd.getAdBodyText());
        nativeAdSocialContext.setText(nativeAd.getAdSocialContext());
        nativeAdCallToAction.setVisibility(nativeAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        if (!Native_Btn_Text_Size.isEmpty()) {
            nativeAdCallToAction.setTextSize(Float.parseFloat(Native_Btn_Text_Size));
        }
        if (!Native_Btn_text.isEmpty()) {
            nativeAdCallToAction.setText(Native_Btn_text);
        } else {
            nativeAdCallToAction.setText(nativeAd.getAdCallToAction());
        }
        if (!Native_Btn_Text_Color.isEmpty()) {
            nativeAdCallToAction.setTextColor(Color.parseColor(Native_Btn_Text_Color));
        }
        if (!Native_Btn_Color.isEmpty()) {
            nativeAdCallToAction.setBackgroundColor(Color.parseColor(Native_Btn_Color));
        }
        sponsoredLabel.setText(nativeAd.getSponsoredTranslation());
        List<View> clickableViews = new ArrayList<>();
        clickableViews.add(nativeAdTitle);
        clickableViews.add(nativeAdBody);
        clickableViews.add(nativeAdCallToAction);
        clickableViews.add(nativeAdIcon);
        clickableViews.add(nativeAdSocialContext);
        nativeAd.registerViewForInteraction(adView, nativeAdMedia, nativeAdIcon, clickableViews);
        if ((preloadNative_AdStatus && state_fbNative.equals("Start")) || state_fbNative.equals("Fail")) {
            if (facebook_n.isEmpty()) {
                return;
            }
            state_fbNative = "Loading";
            final com.facebook.ads.NativeAd nativeAd1 = new com.facebook.ads.NativeAd(activity, facebook_n);
            nativeAd1.loadAd(nativeAd1.buildLoadAdConfig().withAdListener(new NativeAdListener() { // from class: com.superadtech.modids.32
                @Override // com.facebook.ads.NativeAdListener
                public void onMediaDownloaded(Ad ad) {
                    Log.e(TAG, "onMediaDownloadedinflate: ");
                }

                @Override // com.facebook.ads.AdListener
                public void onError(Ad ad, AdError adError) {
                    Log.e(TAG, "onErrorinflate: ");
                    state_fbNative = "Fail";
                    fbNativeAd_preLoad = null;
                    showFacebookNative(card, facebook_n);
                }

                @Override // com.facebook.ads.AdListener
                public void onAdLoaded(Ad ad) {
                    Log.e(TAG, "onAdLoadedinflate: ");
                    if (nativeAd1 == null || nativeAd1 != ad) {
                        Log.e(TAG, "onAdLoadedIFinflate: ");
                        return;
                    }
                    fbNativeAd_preLoad = null;
                    fbNativeAd_preLoad = nativeAd1;
                    state_fbNative = "Loaded";
                }

                @Override // com.facebook.ads.AdListener
                public void onAdClicked(Ad ad) {
                    Log.e(TAG, "onAdClickedinflate: ");
                }

                @Override // com.facebook.ads.AdListener
                public void onLoggingImpression(Ad ad) {
                    Log.e(TAG, "onLoggingImpressioninflate: ");
                }
            }).build());
            return;
        }
        Log.e("fb_stateinflate", "proccess");
    }

    public void showAdmobNative(final ViewGroup nativeAdContainer, final String admob_native1) {
        if (AD_MOB_STATUS.equalsIgnoreCase("false")) {
            return;
        }

        if (admobNativeAd_preLoad == null) {
            Log.e(TAG, "showAdmobNativePreloadIF: ");
            AdLoader adLoader = new AdLoader.Builder(activity, admob_native1).forNativeAd(new NativeAd.OnNativeAdLoadedListener() { // from class: com.superadtech.modids.34
                @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
                public void onNativeAdLoaded(NativeAd nativeAd2) {
                    Log.e(TAG, "onNativeAdLoaded0condition::");
                    inflate_NATIV_ADMOB(nativeAd2, nativeAdContainer, admob_native1);
                }
            }).withAdListener(new com.google.android.gms.ads.AdListener() { // from class: com.superadtech.modids.33
                @Override // com.google.android.gms.ads.AdListener
                public void onAdFailedToLoad(LoadAdError adError) {
                    Log.e(TAG, "onAdFailedToLoad0condition:: ");
                    showAdmobNative2(nativeAdContainer, AD_MOB_APP_ID_Native2);
                }
            }).withNativeAdOptions(new NativeAdOptions.Builder().build()).build();
            adLoader.loadAd(new AdRequest.Builder().build());
            return;
        }
        state_admobNative = "Start";
        inflate_NATIV_ADMOB(admobNativeAd_preLoad, nativeAdContainer, admob_native1);
    }

    public void showAdmobNative2(final ViewGroup nativeAdContainer, final String admob_native2) {
        Log.e(TAG, "showAdmobNative2: ");
        if (AD_MOB_STATUS.equalsIgnoreCase("false")) {
            return;
        }

        if (admobNativeAd_preLoad == null) {
            AdLoader adLoader = new AdLoader.Builder(activity, admob_native2).forNativeAd(new NativeAd.OnNativeAdLoadedListener() { // from class: com.superadtech.modids.36
                @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
                public void onNativeAdLoaded(NativeAd nativeAd2) {
                    Log.e(TAG, "onNativeAdLoaded0condition2::");
                    inflate_NATIV_ADMOB(nativeAd2, nativeAdContainer, admob_native2);
                }
            }).withAdListener(new com.google.android.gms.ads.AdListener() { // from class: com.superadtech.modids.35
                @Override // com.google.android.gms.ads.AdListener
                public void onAdFailedToLoad(LoadAdError adError) {
                    Log.e(TAG, "onAdFailedToLoad0condition2:: ");
                    showAdmobNative3(nativeAdContainer, AD_MOB_APP_ID_Native3);
                }
            }).withNativeAdOptions(new NativeAdOptions.Builder().build()).build();
            adLoader.loadAd(new AdRequest.Builder().build());
            return;
        }
        state_admobNative = "Start";
        inflate_NATIV_ADMOB(admobNativeAd_preLoad, nativeAdContainer, admob_native2);
    }

    public void showAdmobNative3(final ViewGroup nativeAdContainer, final String admob_native3) {
        if (AD_MOB_STATUS.equalsIgnoreCase("false")) {
            return;
        }

        if (admobNativeAd_preLoad == null) {
            Log.e(TAG, "showAdmobNative3PreloadIF3: ");
            AdLoader adLoader = new AdLoader.Builder(activity, admob_native3).forNativeAd(new NativeAd.OnNativeAdLoadedListener() { // from class: com.superadtech.modids.38
                @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
                public void onNativeAdLoaded(NativeAd nativeAd2) {
                    Log.e(TAG, "onNativeAdLoaded0condition3::");
                    inflate_NATIV_ADMOB(nativeAd2, nativeAdContainer, admob_native3);
                }
            }).withAdListener(new com.google.android.gms.ads.AdListener() { // from class: com.superadtech.modids.37
                @Override // com.google.android.gms.ads.AdListener
                public void onAdFailedToLoad(LoadAdError adError) {
                    Log.e(TAG, "onAdFailedToLoad0condition3:: ");
                    showAdmobNative4(nativeAdContainer, AD_MOB_APP_ID_Native4);
                }
            }).withNativeAdOptions(new NativeAdOptions.Builder().build()).build();
            adLoader.loadAd(new AdRequest.Builder().build());
            return;
        }
        state_admobNative = "Start";
        inflate_NATIV_ADMOB(admobNativeAd_preLoad, nativeAdContainer, admob_native3);
    }

    public void showAdmobNative4(final ViewGroup nativeAdContainer, final String admob_native4) {
        if (AD_MOB_STATUS.equalsIgnoreCase("false")) {
            return;
        }

        if (admobNativeAd_preLoad == null) {
            Log.e(TAG, "showAdmobNative4PreloadIF4: ");
            AdLoader adLoader = new AdLoader.Builder(activity, admob_native4).forNativeAd(new NativeAd.OnNativeAdLoadedListener() { // from class: com.superadtech.modids.40
                @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
                public void onNativeAdLoaded(NativeAd nativeAd2) {
                    Log.e(TAG, "3onNativeAdLoaded0condition4::");
                    inflate_NATIV_ADMOB(nativeAd2, nativeAdContainer, admob_native4);
                }
            }).withAdListener(new com.google.android.gms.ads.AdListener() { // from class: com.superadtech.modids.39
                @Override // com.google.android.gms.ads.AdListener
                public void onAdFailedToLoad(LoadAdError adError) {
                    Log.e(TAG, "onAdFailedToLoad0condition4:: ");
                    if (FACEBOOK_AD_STATUS.equalsIgnoreCase("true") && app_Native_AdsPriority.equalsIgnoreCase("google")) {
                        showFacebookNative(nativeAdContainer, FB_Native_ID1);
                    }
                }
            }).withNativeAdOptions(new NativeAdOptions.Builder().build()).build();
            adLoader.loadAd(new AdRequest.Builder().build());
            return;
        }
        state_admobNative = "Start";
        inflate_NATIV_ADMOB(admobNativeAd_preLoad, nativeAdContainer, admob_native4);
    }

    public void inflate_NATIV_ADMOB(NativeAd nativeAd, final ViewGroup nativeAdContainer, final String admob_native) {
        View view;
        nativeAdContainer.setVisibility(View.VISIBLE);
        LayoutInflater inflater = LayoutInflater.from(activity);

        if (Native_Ad_Normal_Size_Lyout.equals("true")) {
            view = inflater.inflate(R.layout.native_admob_normal_size, null);
        } else if (Native_Ad_Small_Size_Lyout.equals("true")) {
            view = inflater.inflate(R.layout.native_admob_small_size, null);
        } else {
            view = inflater.inflate(R.layout.native_admob_normal_size, null);
        }

        nativeAdContainer.removeAllViews();
        nativeAdContainer.addView(view);
        NativeAdView adView = view.findViewById(R.id.uadview);
        adView.setMediaView(adView.findViewById(R.id.ad_media));
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));

        if (!Native_Text_Color.isEmpty()) {
            TextView headlineTextView = adView.findViewById(R.id.ad_headline);
            if (headlineTextView != null) {
                headlineTextView.setTextColor(Color.parseColor(Native_Text_Color));
            }
            TextView ad_bodyz = adView.findViewById(R.id.ad_body);
            if (ad_bodyz != null) {
                ad_bodyz.setTextColor(Color.parseColor(Native_Text_Color));
            }
        }

        if (!Native_Btn_Color.isEmpty()) {
            adView.findViewById(R.id.ad_call_to_action).setBackgroundColor(Color.parseColor(Native_Btn_Color));
        }

        if (!Native_Ads_Btn_Corner_Radius.isEmpty()) {
            GradientDrawable drawable = (GradientDrawable) Objects.requireNonNull(ContextCompat.getDrawable(activity, R.drawable.dynamic_round_corner_native_lyt)).mutate();
            drawable.setCornerRadius(Float.parseFloat(Native_Ads_Btn_Corner_Radius));
            drawable.setColor(Color.parseColor(Native_Btn_Color));
            adView.findViewById(R.id.ad_call_to_action).setBackground(drawable);
        }

        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        adView.setPriceView(adView.findViewById(R.id.ad_price));
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
        adView.setStoreView(adView.findViewById(R.id.ad_store));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));
        Objects.requireNonNull(adView.getMediaView()).setMediaContent(nativeAd.getMediaContent());
        ((TextView) Objects.requireNonNull(adView.getHeadlineView())).setText(nativeAd.getHeadline());
        if (nativeAd.getBody() != null) {
            Objects.requireNonNull(adView.getBodyView()).setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        } else {
            Objects.requireNonNull(adView.getBodyView()).setVisibility(View.INVISIBLE);
        }
        if (!Native_Btn_Text_Size.isEmpty()) {
            ((TextView) Objects.requireNonNull(adView.getCallToActionView())).setTextSize(Float.parseFloat(Native_Btn_Text_Size));
        }
        if (!Native_Btn_Text_Color.isEmpty()) {
            ((TextView) Objects.requireNonNull(adView.getCallToActionView())).setTextColor(Color.parseColor(Native_Btn_Text_Color));
        }
        if (nativeAd.getCallToAction() != null) {
            Objects.requireNonNull(adView.getCallToActionView()).setVisibility(View.VISIBLE);
            if (!Native_Btn_text.isEmpty()) {
                ((TextView) adView.getCallToActionView()).setText(Native_Btn_text);
            } else {
                ((TextView) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
            }
        } else {
            Objects.requireNonNull(adView.getCallToActionView()).setVisibility(View.INVISIBLE);
        }
        if (nativeAd.getIcon() == null) {
            Objects.requireNonNull(adView.getIconView()).setVisibility(View.GONE);
        } else {
            ((ImageView) Objects.requireNonNull(adView.getIconView())).setImageDrawable(nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }
        if (nativeAd.getStarRating() == null) {
            Objects.requireNonNull(adView.getStarRatingView()).setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) Objects.requireNonNull(adView.getStarRatingView())).setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }
        if (nativeAd.getAdvertiser() == null) {
            Objects.requireNonNull(adView.getAdvertiserView()).setVisibility(View.INVISIBLE);
        } else {
            ((TextView) Objects.requireNonNull(adView.getAdvertiserView())).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }
        adView.setNativeAd(nativeAd);

        if ((preloadNative_AdStatus && state_admobNative.equals("Start")) || state_admobNative.equals("Fail")) {
            Log.e(TAG, "inflate_NATIV_ADMOBIFTruePreload: " + preloadNative_AdStatus);
            if (admob_native.isEmpty()) {
                Log.e(TAG, "inflate_NATIV_ADMOBadmob_dbEmityConditomnif: ");
                return;
            }
            state_admobNative = "Loading";
            AdLoader adLoader = new AdLoader.Builder(activity, admob_native).forNativeAd(new NativeAd.OnNativeAdLoadedListener() { // from class: com.superadtech.modids.42
                @Override
                public void onNativeAdLoaded(@NonNull NativeAd nativeAd2) {
                    Log.e(TAG, "MainonNativeAdLoaded: ");
                    admobNativeAd_preLoad = null;
                    admobNativeAd_preLoad = nativeAd2;
                    state_admobNative = "Loaded";
                }
            }).withAdListener(new com.google.android.gms.ads.AdListener() { // from class: com.superadtech.modids.41
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                    admobNativeAd_preLoad = null;
                    state_admobNative = "Fail";
                    showAdmobNative(nativeAdContainer, admob_native);
                }
            }).withNativeAdOptions(new NativeAdOptions.Builder().build()).build();
            adLoader.loadAd(new AdRequest.Builder().build());
            return;
        }
        Log.e("admob_state", "proccess");
    }

    public void loadInterstitialAd(Activity activity2) {
        turnLoadInterstitialAd(activity2, AD_MOB_APP_ID_Inter1, FB_Inter_ID1);
    }

    public void turnLoadInterstitialAd(Activity activity2, String google_i, String facebook_i) {
        if (!All_Ads_Show.equalsIgnoreCase("true")) {
            return;
        }
        if (AD_MOB_STATUS.equalsIgnoreCase("true") && app_AdsPriority.equalsIgnoreCase("google") && !google_i.isEmpty() && !this.google_i_pre.equals(google_i)) {
            loadAdmobInterstitial(activity2, google_i);
        } else if (FACEBOOK_AD_STATUS.equalsIgnoreCase("true") && app_AdsPriority.equalsIgnoreCase("facebook") && !facebook_i.isEmpty() && !this.facebook_i_pre.equals(facebook_i)) {
            loadFacebookInterstitial(activity2, facebook_i);
        }
    }

    public void Show_Next_InterstitialAd(Activity context, MyCallback myCallback2, int how_many_clicks) {
        NextturnInterstitialAd(context, myCallback2, how_many_clicks);
    }

    public void Show_Back_InterstitialAd(Activity context, MyCallback myCallback2, int how_many_clicks) {
        BackturnInterstitialAd(context, myCallback2, how_many_clicks);
    }

    public void NextturnInterstitialAd(Activity context, MyCallback myCallback2, int how_many_clicks) {
        myCallback = myCallback2;
        if (how_many_clicks == 0) {
            count_click_next = 0;
            displayInterstitialAd(context);
        } else {
            count_click_next = count_click_next + 1;
            if (!All_Ads_Show.equalsIgnoreCase("true")) {
                if (myCallback2 != null) {
                    myCallback2.callbackCall();
                    myCallback = null;
                }
            } else if (how_many_clicks != 0 && count_click_next % how_many_clicks != 0) {
                if (myCallback2 != null) {
                    myCallback2.callbackCall();
                    myCallback = null;
                }
            } else {
                count_click_next = 0;

                displayInterstitialAd(context);
            }
        }
    }

    public void BackturnInterstitialAd(Activity context, MyCallback myCallback2, int how_many_clicks) {
        myCallback = myCallback2;
        if (how_many_clicks == 0) {
            count_click_back = 0;
            displayInterstitialAd(context);
        } else {
            count_click_back = count_click_back + 1;
            if (!All_Ads_Show.equalsIgnoreCase("true")) {
                if (myCallback2 != null) {
                    myCallback2.callbackCall();
                    myCallback = null;
                }
            } else if (how_many_clicks != 0 && count_click_back % how_many_clicks != 0) {
                if (myCallback2 != null) {
                    myCallback2.callbackCall();
                    myCallback = null;
                }
            } else {
                count_click_back = 0;
                displayInterstitialAd(context);
            }
        }
    }

    public void displayInterstitialAd(final Activity context) {

        this.dialog = new Dialog(context);
        View view = LayoutInflater.from(context).inflate(R.layout.ad_loading_progress_dialog, null);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.FILL_PARENT);
        dialog.setContentView(view);
        dialog.setCancelable(false);

        if (app_AdsPriority.equalsIgnoreCase("google")) {
            if (AD_MOB_STATUS.equalsIgnoreCase("true") && mInterstitialAd != null) {
                if (Dialog_Show.equalsIgnoreCase("true")) {
                    dialog.show();
                    new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                        @Override // android.os.CountDownTimer
                        public void onTick(long millisUntilFinished) {
                            double d = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            dialog.dismiss();
                            mInterstitialAd.show((Activity) context);
                        }
                    }.start();
                    //  return;
                } else {
                    mInterstitialAd.show((Activity) context);
                }
            } else if (FACEBOOK_AD_STATUS.equalsIgnoreCase("true") && fbinterstitialAd1 != null) {
                if (Dialog_Show.equalsIgnoreCase("true")) {
                    dialog.show();
                    new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                        @Override // android.os.CountDownTimer
                        public void onTick(long millisUntilFinished) {
                            double d = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            dialog.dismiss();
                            fbinterstitialAd1.show();
                        }
                    }.start();
                    // return;
                } else {
                    fbinterstitialAd1.show();
                }

            } else {
                if (!google_i_pre.isEmpty()) {
                    loadAdmobInterstitial(context, google_i_pre);
                }
                nextInterstitialPlatform();
            }
        } else if (app_AdsPriority.equalsIgnoreCase("facebook")) {
            if (FACEBOOK_AD_STATUS.equalsIgnoreCase("true") && fbinterstitialAd1.isAdLoaded()) {
                if (Dialog_Show.equalsIgnoreCase("true")) {
                    dialog.show();
                    new CountDownTimer(ad_dialog_time_in_second * 1000, 10) { // from class: com.superadtech.modids.47
                        @Override // android.os.CountDownTimer
                        public void onTick(long millisUntilFinished) {
                            double d = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            dialog.dismiss();
                            fbinterstitialAd1.show();
                        }
                    }.start();
                    //  return;
                } else {
                    fbinterstitialAd1.show();
                }

            } else if (AD_MOB_STATUS.equalsIgnoreCase("true") && mInterstitialAd != null) {
                if (Dialog_Show.equalsIgnoreCase("true")) {
                    dialog.show();
                    new CountDownTimer(ad_dialog_time_in_second * 1000, 10) { // from class: com.superadtech.modids.48
                        @Override // android.os.CountDownTimer
                        public void onTick(long millisUntilFinished) {
                            double d = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            dialog.dismiss();
                            mInterstitialAd.show(context);
                        }
                    }.start();
                    // return;
                } else {
                    mInterstitialAd.show(context);
                }

            } else {
                if (!facebook_i_pre.isEmpty()) {
                    loadFacebookInterstitial(context, facebook_i_pre);
                }
                nextInterstitialPlatform();
            }
        } else if (AD_MOB_STATUS.equalsIgnoreCase("true") && mInterstitialAd != null) {
            if (Dialog_Show.equalsIgnoreCase("true")) {
                dialog.show();
                new CountDownTimer(ad_dialog_time_in_second * 1000, 10) { // from class: com.superadtech.modids.52
                    @Override // android.os.CountDownTimer
                    public void onTick(long millisUntilFinished) {
                        double d = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        dialog.dismiss();
                        mInterstitialAd.show(context);
                    }
                }.start();
                //  return;
            } else {
                mInterstitialAd.show(context);
            }
        } else if (FACEBOOK_AD_STATUS.equalsIgnoreCase("true") && fbinterstitialAd1.isAdLoaded()) {
            if (Dialog_Show.equalsIgnoreCase("true")) {
                dialog.show();
                new CountDownTimer(ad_dialog_time_in_second * 1000, 10) { // from class: com.superadtech.modids.53
                    @Override // android.os.CountDownTimer
                    public void onTick(long millisUntilFinished) {
                        double d = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        dialog.dismiss();
                        fbinterstitialAd1.show();
                    }
                }.start();
                //   return;
            } else {
                fbinterstitialAd1.show();
            }
        } else {
            nextInterstitialPlatform();
        }
    }

    public void loadAdmobInterstitial(final Activity activity2, String google_i) {
        google_i_pre = google_i;
        AdRequest adRequest = new AdRequest.Builder().build();
        com.google.android.gms.ads.interstitial.InterstitialAd.load(activity2, google_i, adRequest, new InterstitialAdLoadCallback() { // from class: com.superadtech.modids.59
            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(com.google.android.gms.ads.interstitial.InterstitialAd interstitialAd) {
                mInterstitialAd = interstitialAd;
                Log.e(TAG, "onAdLoadedgg1");
                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.superadtech.modids.59.1
                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdDismissedFullScreenContent() {
                        Log.e("TAG", "onAdDismissedFullScreenContentgg1");

                        google_i_pre = AD_MOB_APP_ID_Inter1;
                        if (!google_i_pre.isEmpty()) {
                            loadAdmobInterstitial(activity2, google_i_pre);
                        }
                        interstitialCallBack();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                        Log.e("TAG", "onAdFailedToShowFullScreenContentgg1");
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdShowedFullScreenContent() {
                        mInterstitialAd = null;
                        Log.e("TAG", "onAdShowedFullScreenContentgg1");
                    }
                });
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                Log.e(TAG, "onAdFailedToLoadgg1");
                mInterstitialAd = null;
                google_i_pre = AD_MOB_APP_ID_Inter2;
                if (!google_i_pre.isEmpty()) {
                    loadAdmobInterstitial2(activity2, google_i_pre);
                }
            }
        });
    }

    public void loadAdmobInterstitial2(final Activity activity2, String google_i) {
        this.google_i_pre = google_i;
        AdRequest adRequest = new AdRequest.Builder().build();
        com.google.android.gms.ads.interstitial.InterstitialAd.load(activity2, google_i, adRequest, new InterstitialAdLoadCallback() { // from class: com.superadtech.modids.60
            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(com.google.android.gms.ads.interstitial.InterstitialAd interstitialAd) {
                mInterstitialAd = interstitialAd;
                Log.e(TAG, "onAdLoadedgg2");
                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.superadtech.modids.60.1
                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdDismissedFullScreenContent() {
                        Log.e("TAG", "onAdDismissedFullScreenContentgg2");
                        google_i_pre = AD_MOB_APP_ID_Inter2;
                        if (!google_i_pre.isEmpty()) {
                            loadAdmobInterstitial2(activity2, google_i_pre);
                        }
                        interstitialCallBack();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                        Log.e("TAG", "onAdFailedToShowFullScreenContentgg2");
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdShowedFullScreenContent() {
                        mInterstitialAd = null;
                        Log.e("TAG", "onAdShowedFullScreenContentgg2");
                    }
                });
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                Log.e(TAG, "onAdFailedToLoadgg2");
                mInterstitialAd = null;
                google_i_pre = AD_MOB_APP_ID_Inter3;
                if (!google_i_pre.isEmpty()) {
                    loadAdmobInterstitial3(activity2, google_i_pre);
                }
            }
        });
    }

    public void loadAdmobInterstitial3(final Activity activity2, String google_i) {
        this.google_i_pre = google_i;
        AdRequest adRequest = new AdRequest.Builder().build();
        com.google.android.gms.ads.interstitial.InterstitialAd.load(activity2, google_i, adRequest, new InterstitialAdLoadCallback() { // from class: com.superadtech.modids.61
            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(com.google.android.gms.ads.interstitial.InterstitialAd interstitialAd) {
                mInterstitialAd = interstitialAd;
                Log.e(TAG, "onAdLoadedgg3");
                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.superadtech.modids.61.1
                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdDismissedFullScreenContent() {
                        Log.e("TAG", "onAdDismissedFullScreenContentgg3");
                        google_i_pre = AD_MOB_APP_ID_Inter3;
                        if (!google_i_pre.isEmpty()) {
                            loadAdmobInterstitial3(activity2, google_i_pre);
                        }
                        interstitialCallBack();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                        Log.e("TAG", "onAdFailedToShowFullScreenContentgg3");
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdShowedFullScreenContent() {
                        mInterstitialAd = null;
                        Log.e("TAG", "onAdShowedFullScreenContentgg3");
                    }
                });
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                Log.e(TAG, "onAdFailedToLoadgg3");
                mInterstitialAd = null;
                if (FACEBOOK_AD_STATUS.equalsIgnoreCase("true") && app_AdsPriority.equalsIgnoreCase("google")) {
                    loadFacebookInterstitial(activity2, FB_Inter_ID1);
                } else {
                    nextInterstitialPlatform();
                }
            }
        });
    }

    public void loadFacebookInterstitial(final Activity activity2, String facebook_i) {
        this.facebook_i_pre = facebook_i;
        fbinterstitialAd1 = new InterstitialAd(activity2, facebook_i);
        fbinterstitialAd1.loadAd(fbinterstitialAd1.buildLoadAdConfig().withAdListener(new AbstractAdListener() { // from class: com.superadtech.modids.62
            @Override // com.facebook.ads.AbstractAdListener, com.facebook.ads.AdListener
            public void onError(Ad ad, AdError error) {
                super.onError(ad, error);
                Log.e(TAG, "onError1: ");
                if (!facebook_i_pre.isEmpty()) {
                    loadFacebookInterstitial2(activity2, FB_Inter_ID2);
                }
            }

            @Override // com.facebook.ads.AbstractAdListener, com.facebook.ads.AdListener
            public void onAdLoaded(Ad ad) {
                Log.e(TAG, "onAdLoaded1: ");
                super.onAdLoaded(ad);
            }

            @Override
            // com.facebook.ads.AbstractAdListener, com.facebook.ads.InterstitialAdListener
            public void onInterstitialDismissed(Ad ad) {
                Log.e(TAG, "onInterstitialDismissed1: ");
                super.onInterstitialDismissed(ad);
                loadFacebookInterstitial(activity2, facebook_i_pre);
                interstitialCallBack();
            }
        }).build());
    }

    public void loadFacebookInterstitial2(final Activity activity2, String facebook_i) {
        this.facebook_i_pre = facebook_i;
        fbinterstitialAd1 = new InterstitialAd(activity2, facebook_i);

        fbinterstitialAd1.loadAd(fbinterstitialAd1.buildLoadAdConfig().withAdListener(new AbstractAdListener() { // from class: com.superadtech.modids.63
            @Override // com.facebook.ads.AbstractAdListener, com.facebook.ads.AdListener
            public void onError(Ad ad, AdError error) {
                Log.e(TAG, "onError2: ");
                super.onError(ad, error);
                if (!facebook_i_pre.isEmpty()) {
                    loadFacebookInterstitial3(activity2, FB_Inter_ID3);
                }
            }

            @Override // com.facebook.ads.AbstractAdListener, com.facebook.ads.AdListener
            public void onAdLoaded(Ad ad) {
                Log.e(TAG, "onAdLoaded2: ");
                super.onAdLoaded(ad);
            }

            @Override
            // com.facebook.ads.AbstractAdListener, com.facebook.ads.InterstitialAdListener
            public void onInterstitialDismissed(Ad ad) {
                Log.e(TAG, "onInterstitialDismissed2: ");
                super.onInterstitialDismissed(ad);
                loadFacebookInterstitial(activity2, facebook_i_pre);
                interstitialCallBack();
            }
        }).build());
    }

    public void loadFacebookInterstitial3(final Activity activity2, String facebook_i) {
        this.facebook_i_pre = facebook_i;
        fbinterstitialAd1 = new InterstitialAd(activity2, facebook_i);
        fbinterstitialAd1.loadAd(fbinterstitialAd1.buildLoadAdConfig().withAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError error) {
                super.onError(ad, error);
                Log.e(TAG, "onErrorinter3: ");
                if (AD_MOB_STATUS.equalsIgnoreCase("true") && app_AdsPriority.equalsIgnoreCase("facebook")) {
                    loadAdmobInterstitial(activity2, AD_MOB_APP_ID_Inter1);
                } else {
                    nextInterstitialPlatform();
                }
            }

            @Override
            public void onAdLoaded(Ad ad) {
                super.onAdLoaded(ad);
                Log.e(TAG, "onAdLoaded3: ");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                Log.e(TAG, "onInterstitialDismissed3: ");
                super.onInterstitialDismissed(ad);
                if (fbinterstitialAd1 != null) {
                    fbinterstitialAd1.destroy();
                }
                loadFacebookInterstitial(activity2, facebook_i_pre);
                interstitialCallBack();
            }
        }).build());
    }

    public void interstitialCallBack() {
        MyCallback myCallback2 = myCallback;
        if (myCallback2 != null) {
            myCallback2.callbackCall();
            myCallback = null;
        }
    }

    public void nextInterstitialPlatform() {
        interstitialCallBack();
    }

    public void Qureka_Open_Chome(Context activity2, String s) {
        try {
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.intent.setPackage("com.android.chrome");
            customTabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            customTabsIntent.launchUrl(activity2, Uri.parse(s));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void DestroyINBAd() {
        if (AD_MOB_STATUS.equalsIgnoreCase("true")) {
            if (this.mInterstitialAd != null) {
                this.mInterstitialAd = null;
            }

            if (admobNativeAd_preLoad != null) {
                admobNativeAd_preLoad.destroy();
            }

            if (admobBannerNativeAd != null) {
                admobBannerNativeAd.destroy();
            }

            if (mAdView != null) {
                mAdView.destroy();
            }
        }

        if (FACEBOOK_AD_STATUS.equalsIgnoreCase("true")) {
            if (fbinterstitialAd1 != null) {
                fbinterstitialAd1.destroy();
            }

            if (fbNativeAd_preLoad != null) {
                fbNativeAd_preLoad.destroy();
            }

            if (nativeAd1 != null) {
                nativeAd1.destroy();
            }

            if (this.fbadView != null) {
                this.fbadView.destroy();
            }
        }
    }

    public void distoryAllAd() {
        Log.e(TAG, "distoryAllAd: ");
        if (AD_MOB_STATUS.equalsIgnoreCase("true")) {
            if (this.mInterstitialAd != null) {
                this.mInterstitialAd = null;
            }

            if (admobNativeAd_preLoad != null) {
                admobNativeAd_preLoad.destroy();
            }

            if (admobBannerNativeAd != null) {
                admobBannerNativeAd.destroy();
            }

            if (mAdView != null) {
                mAdView.destroy();
            }
        }

        if (FACEBOOK_AD_STATUS.equalsIgnoreCase("true")) {
            if (fbinterstitialAd1 != null) {
                fbinterstitialAd1.destroy();
            }

            if (fbNativeAd_preLoad != null) {
                fbNativeAd_preLoad.destroy();
            }

            if (nativeAd1 != null) {
                nativeAd1.destroy();
            }

            if (this.fbadView != null) {
                this.fbadView.destroy();
            }
        }

        if (AD_MOB_OpenAd_STATUS.equalsIgnoreCase("true")) {
            appOpenManager.DestroyAllAds();
        }
    }
}