package com.superadtech.modids.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class Const_Preference {

    public static String BASE_HOST = "https://awebhtpo3u8g5t.ecoweb-network.com";
    public static String BASE_CARRIER_ID = "touchvpn";
    public static String BASE_OAUTH_METHOD = "anonymous";
    public static String SHARED_PREFS = "NORTHGHOST_SHAREDPREFS";
    public static String STORED_HOST_URL_KEY = "com.northghost.afvclient.STORED_HOST_KEY";
    public static String STORED_CARRIER_ID_KEY = "com.northghost.afvclient.CARRIER_ID_KEY";
    public static MasterX.MySpalshCallback mySpalshCallback;
    public static String From_Splash = "";
    public static String Vpn_States = "";
    public static Boolean Splash_state = true;

    public SharedPreferences appSharedPrefs;
    public SharedPreferences.Editor prefsEditor;
    Context context;

    public Const_Preference(Context context) {
        this.context = context;
        this.appSharedPrefs = context.getSharedPreferences("My_pref", Activity.MODE_PRIVATE);
        this.prefsEditor = appSharedPrefs.edit();
    }

    public void setStringpreference(String key_value, String defult_value) {
        this.prefsEditor.putString(key_value, defult_value).commit();
    }
}
