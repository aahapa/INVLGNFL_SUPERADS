package com.superadtech.modids.proxy;

import static com.superadtech.modids.MyAdZOne.AD_MOB_APP_OPEN_TIMER;
import static com.superadtech.modids.MyAdZOne.AD_MOB_OpenAd_Fails_INTER_SHOW;
import static com.superadtech.modids.MyAdZOne.AD_MOB_OpenAd_STATUS;
import static com.superadtech.modids.MyAdZOne.AD_MOB_SPLASH_INTER_FORCE;
import static com.superadtech.modids.MyAdZOne.AD_MOB_SPLASH_INTER_TIMER;
import static com.superadtech.modids.MyAdZOne.All_Ads_Show;
import static com.superadtech.modids.MyAdZOne.Install_Ref_Activate;
import static com.superadtech.modids.MyAdZOne.VPN_OFF_When_App_Close;
import static com.superadtech.modids.MyAdZOne.VPN_SERVER_NAME_TO_CONNECT;
import static com.superadtech.modids.MyAdZOne.VPN_SHOW_AT_APP_Start;
import static com.superadtech.modids.MyAdZOne.app_BannerPeriority;
import static com.superadtech.modids.MyAdZOne.app_NativeAdCodeType;
import static com.superadtech.modids.MyAdZOne.app_UpdatePackageName;
import static com.superadtech.modids.MyAdZOne.app_onesingle_appid;
import static com.superadtech.modids.MyAdZOne.app_updateAppDialogStatus;
import static com.superadtech.modids.MyAdZOne.app_versionCode;
import static com.superadtech.modids.proxy.Const_Preference.Splash_state;
import static com.superadtech.modids.proxy.Const_Preference.Vpn_States;
import static com.superadtech.modids.proxy.CountryData.COUNTRY_DATA;
import static com.superadtech.modids.proxy.CountryData.SELECTED_COUNTRY;
import static unified.vpn.sdk.OpenVpnTransport.TRANSPORT_ID_TCP;
import static unified.vpn.sdk.OpenVpnTransport.TRANSPORT_ID_UDP;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.gson.Gson;
import com.onesignal.OneSignal;
import com.superadtech.modids.AESSUtils;
import com.superadtech.modids.AppOpenManager;
import com.superadtech.modids.Applicationclass;
import com.superadtech.modids.Constant_Super;
import com.superadtech.modids.Instant_Internet_Check;
import com.superadtech.modids.MyAdZOne;
import com.superadtech.modids.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import unified.vpn.sdk.AuthMethod;
import unified.vpn.sdk.AvailableCountries;
import unified.vpn.sdk.Callback;
import unified.vpn.sdk.CompletableCallback;
import unified.vpn.sdk.Country;
import unified.vpn.sdk.HydraTransport;
import unified.vpn.sdk.HydraVpnTransportException;
import unified.vpn.sdk.NetworkRelatedException;
import unified.vpn.sdk.PartnerApiException;
import unified.vpn.sdk.RemainingTraffic;
import unified.vpn.sdk.SessionConfig;
import unified.vpn.sdk.SessionInfo;
import unified.vpn.sdk.TrackingConstants;
import unified.vpn.sdk.TrafficRule;
import unified.vpn.sdk.UnifiedSdk;
import unified.vpn.sdk.User;
import unified.vpn.sdk.VpnException;
import unified.vpn.sdk.VpnPermissionDeniedException;
import unified.vpn.sdk.VpnPermissionRevokedException;
import unified.vpn.sdk.VpnState;
import unified.vpn.sdk.VpnTransportException;

public class MasterX extends AppCompatActivity implements LoginDialog.LoginConfirmationInterface {

    public static String mode = "";
    public static boolean isShowOpen = false;
    public static AppOpenManager appOpenManager;
    public static boolean need_internet = false;
    public static boolean is_retry;
    public static Handler refreshHandler;
    public static Runnable runnable;
    public static int vercode;

    public String model = "";
    public String intentdata = "";
    public int cversion;

    Activity activity = this;

    protected static final String TAG = MasterX.class.getSimpleName();
    Const_Preference constPreference;
    boolean connected = false;

    private Handler mUIHandler = new Handler(Looper.getMainLooper());

    final Runnable mUIUpdateRunnable = new Runnable() {
        @Override
        public void run() {
            updateUI();
            checkRemainingTraffic();
            mUIHandler.postDelayed(mUIUpdateRunnable, 10000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        Intent receivedIntent = getIntent();
        if (receivedIntent != null) {
            model = receivedIntent.getStringExtra("model");
            cversion = receivedIntent.getIntExtra("cversion", 0);
            Splash_state = receivedIntent.getBooleanExtra(Const_Preference.From_Splash, true);
        }

        if (Splash_state) {
            sendRequest(model, cversion);
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        isConnected(new Callback<Boolean>() {
            @Override
            public void success(@NonNull Boolean aBoolean) {
                if (aBoolean) {
                    startUIUpdateTask();
                }
            }

            @Override
            public void failure(@NonNull VpnException e) {

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopUIUpdateTask();
    }

    protected void startUIUpdateTask() {
        stopUIUpdateTask();
        mUIHandler.post(mUIUpdateRunnable);
    }

    protected void stopUIUpdateTask() {
        mUIHandler.removeCallbacks(mUIUpdateRunnable);
        updateUI();
    }

    protected void updateUI() {
        UnifiedSdk.getVpnState(new Callback<VpnState>() {
            @Override
            public void success(@NonNull VpnState vpnState) {
                switch (vpnState) {
                    case IDLE: {
                        Log.e(TAG, "success: IDLE");
                        /*getip();*/
                        if (connected) {
                            connected = false;
                        }
                        break;
                    }
                    case CONNECTED: {
                        Log.e(TAG, "success: CONNECTED");
                        Vpn_States = "CONNECTED";
                        if (Splash_state) {
                            Allloadeddarts();
                        } else {
                            Toast.makeText(activity, "Connected", Toast.LENGTH_SHORT).show();
                        }
                        if (!connected) {
                            connected = true;
                        }
                        break;
                    }
                    case CONNECTING_VPN:
                    case CONNECTING_CREDENTIALS:
                    case CONNECTING_PERMISSIONS: {
                        break;
                    }
                    case PAUSED: {
                        Log.e(TAG, "success: PAUSED");
                        break;
                    }
                }
            }

            @Override
            public void failure(@NonNull VpnException e) {
            }
        });
        getCurrentServer(new Callback<String>() {
            @Override
            public void success(@NonNull final String currentServer) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }

            @Override
            public void failure(@NonNull VpnException e) {

            }
        });
    }

    protected void updateRemainingTraffic(RemainingTraffic remainingTrafficResponse) {
        if (remainingTrafficResponse.isUnlimited()) {
        }
    }

    protected void showMessage(String msg) {
        Toast.makeText(MasterX.this, msg, Toast.LENGTH_SHORT).show();
    }

    private String selectedCountry = "";
    private String ServerIPaddress = "00.000.000.00";

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void isLoggedIn(Callback<Boolean> callback) {
        UnifiedSdk.getInstance().getBackend().isLoggedIn(callback);
    }

    @Override
    public void loginToVpn() {
        Log.e(TAG, "loginToVpn: 1111");
        AuthMethod authMethod = AuthMethod.anonymous();
        UnifiedSdk.getInstance().getBackend().login(authMethod, new Callback<User>() {
            @Override
            public void success(@NonNull User user) {
                chooseServer();
                updateUI();
            }

            @Override
            public void failure(@NonNull VpnException e) {
                updateUI();
                handleError(e);
            }
        });
    }

    @Override
    public void isConnected(Callback<Boolean> callback) {
        UnifiedSdk.getVpnState(new Callback<VpnState>() {
            @Override
            public void success(@NonNull VpnState vpnState) {
                callback.success(vpnState == VpnState.CONNECTED);
            }

            @Override
            public void failure(@NonNull VpnException e) {
                callback.success(false);
            }
        });
    }

    @Override
    public void connectToVpn() {
        isLoggedIn(new Callback<Boolean>() {
            @Override
            public void success(@NonNull Boolean aBoolean) {
                if (aBoolean) {
                    List<String> fallbackOrder = new ArrayList<>();
//                    fallbackOrder.add(HydraTransport.TRANSPORT_ID);
                    fallbackOrder.add(TRANSPORT_ID_TCP);
                    fallbackOrder.add(TRANSPORT_ID_UDP);
                    List<String> bypassDomains = new LinkedList<>();
                    bypassDomains.add("*facebook.com");
                    bypassDomains.add("*wtfismyip.com");
                    UnifiedSdk.getInstance().getVpn().start(new SessionConfig.Builder()
                            .withReason(TrackingConstants.GprReasons.M_UI)
                            .withTransportFallback(fallbackOrder)
                            .withVirtualLocation(selectedCountry)
                            .withTransport(HydraTransport.TRANSPORT_ID)
                            .addDnsRule(TrafficRule.Builder.bypass().fromDomains(bypassDomains))
                            .build(), new CompletableCallback() {
                        @Override
                        public void complete() {
                            startUIUpdateTask();
                        }

                        @Override
                        public void error(@NonNull VpnException e) {
                            updateUI();
                            handleError(e);
                        }
                    });
                }
            }

            @Override
            public void failure(@NonNull VpnException e) {
            }
        });
    }

    @Override
    public void disconnectFromVnp() {
        UnifiedSdk.getInstance().getVpn().stop(TrackingConstants.GprReasons.M_UI, new CompletableCallback() {
            @Override
            public void complete() {
                stopUIUpdateTask();
            }

            @Override
            public void error(@NonNull VpnException e) {
                updateUI();
                handleError(e);
            }
        });
    }

    @Override
    public void chooseServer() {
        isLoggedIn(new Callback<Boolean>() {
            @Override
            public void success(@NonNull Boolean aBoolean) {
                if (aBoolean) {
                    loadServers();
                } else {
                    showMessage("Login please");
                }
            }

            @Override
            public void failure(@NonNull VpnException e) {

            }
        });
    }

    public void loadServers() {
        UnifiedSdk.getInstance().getBackend().countries(new Callback<AvailableCountries>() {
            @Override
            public void success(@NonNull final AvailableCountries countries) {
                List<Country> countryList = countries.getCountries();
                List<CountryData> regions = new ArrayList<>();
                for (int i = 0; i < countryList.size(); i++) {
                    CountryData newData = new CountryData();
                    newData.setCountryvalue(countryList.get(i));
                    regions.add(newData);
                }

                if (VPN_SERVER_NAME_TO_CONNECT.isEmpty()) {
                    Bundle args = new Bundle();
                    Gson gson = new Gson();
                    int min = 0;
                    int max = regions.size();
                    int random = new Random().nextInt((max - min)) + min;
                    String json = gson.toJson(regions.get(random));
                    args.putString(COUNTRY_DATA, json);
                    CountryData itemx = gson.fromJson(args.getString(COUNTRY_DATA), CountryData.class);
                    onRegionSelected(itemx);

                } else {
                    String inputString = VPN_SERVER_NAME_TO_CONNECT;
                    String[] nameparts = inputString.split(",");

                    Bundle argselse = new Bundle();
                    Gson gsonelse = new Gson();
                    String cntr = "";
                    for (int i = 0; i < regions.size(); i++) {
                        CountryData item = regions.get(i);
                        String itemJson = gsonelse.toJson(item);
                        CountryData parsedCountry = gsonelse.fromJson(itemJson, CountryData.class);
                        cntr = parsedCountry.getCountryvalue().getCountry();

                        if (Arrays.asList(nameparts).contains(cntr)) {
                            String json = gsonelse.toJson(regions.get(i));
                            argselse.putString(COUNTRY_DATA, json);
                            CountryData itemx = gsonelse.fromJson(argselse.getString(COUNTRY_DATA), CountryData.class);
                            onRegionSelected(itemx);
                            break;
                        }
                    }
                }
            }

            @Override
            public void failure(@NonNull VpnException e) {
            }
        });
    }

    @Override
    public void getCurrentServer(final Callback<String> callback) {
        UnifiedSdk.getVpnState(new Callback<VpnState>() {
            @Override
            public void success(@NonNull VpnState state) {
                if (state == VpnState.CONNECTED) {
                    UnifiedSdk.getStatus(new Callback<SessionInfo>() {
                        @Override
                        public void success(@NonNull SessionInfo sessionInfo) {
                            ServerIPaddress = sessionInfo.getCredentials().getServers().get(0).getAddress();
                            callback.success(sessionInfo.getCredentials().getServers().get(0).getCountry());
                        }

                        @Override
                        public void failure(@NonNull VpnException e) {
                            callback.success(selectedCountry);
                        }
                    });
                } else {
                    callback.success(selectedCountry);
                }
            }

            @Override
            public void failure(@NonNull VpnException e) {
                callback.failure(e);
            }
        });
    }

    @Override
    public void checkRemainingTraffic() {
        UnifiedSdk.getInstance().getBackend().remainingTraffic(new Callback<RemainingTraffic>() {
            @Override
            public void success(@NonNull RemainingTraffic remainingTraffic) {
                updateRemainingTraffic(remainingTraffic);
            }

            @Override
            public void failure(@NonNull VpnException e) {
                updateUI();
                handleError(e);
            }
        });
    }

    @Override
    public void setLoginParams(String hostUrl, String carrierId) {
        ((MainApp) getApplication()).setNewHostAndCarrier(hostUrl, carrierId);
    }

    @Override
    public void loginUser() {
        loginToVpn();
    }

    public void onRegionSelected(CountryData item) {
        final Country new_countryValue = item.getCountryvalue();
        selectedCountry = new_countryValue.getCountry();
        constPreference.setStringpreference(SELECTED_COUNTRY, selectedCountry);
        CountryData.noty_selected_country = selectedCountry;

        updateUI();
        UnifiedSdk.getVpnState(new Callback<VpnState>() {
            @Override
            public void success(@NonNull VpnState state) {
                if (state == VpnState.CONNECTED) {
                    // showMessage("Reconnecting to VPN with " + selectedCountry);
                    UnifiedSdk.getInstance().getVpn().stop(TrackingConstants.GprReasons.M_UI, new CompletableCallback() {
                        @Override
                        public void complete() {
                            connectToVpn();
                        }

                        @Override
                        public void error(@NonNull VpnException e) {
                            // In this case we try to reconnect
                            selectedCountry = "";
                            constPreference.setStringpreference(SELECTED_COUNTRY, selectedCountry);
                            connectToVpn();
                        }
                    });
                } else {
                    connectToVpn();
                }
            }

            @Override
            public void failure(@NonNull VpnException e) {
            }
        });
    }

    public void handleError(Throwable e) {
        if (e instanceof NetworkRelatedException) {
            showMessage("Check internet connection");
        } else if (e instanceof VpnException) {
            if (e instanceof VpnPermissionRevokedException) {
                showMessage("User revoked vpn permissions");
            } else if (e instanceof VpnPermissionDeniedException) {
                showMessage("Please Grant vpn Permission");
                finishAffinity();
            } else if (e instanceof VpnTransportException) {
                HydraVpnTransportException hydraVpnTransportException = (HydraVpnTransportException) e;
                if (hydraVpnTransportException.getCode() == HydraVpnTransportException.HYDRA_ERROR_BROKEN) {
                    showMessage("Connection with vpn server was lost");
                } else if (hydraVpnTransportException.getCode() == HydraVpnTransportException.HYDRA_DCN_BLOCKED_BW) {
                    showMessage("Client traffic exceeded");
                } else {
                    showMessage("Error in VPN transport");
                }
            } else {
                Log.e(TAG, "Error in VPN Service ");
            }
        } else if (e instanceof PartnerApiException) {
            switch (((PartnerApiException) e).getContent()) {
                case PartnerApiException.CODE_NOT_AUTHORIZED:
                    showMessage("User unauthorized");
                    break;
                case PartnerApiException.CODE_TRAFFIC_EXCEED:
                    showMessage("Server unavailable");
                    break;
                default:
                    showMessage("Other error. Check PartnerApiException constants");
                    break;
            }
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////

    public void sendRequest(String model, final int cversion) {
        need_internet = !model.isEmpty();
        vercode = cversion;
        final Dialog dialog = new Dialog(activity);
        dialog.setCancelable(false);
        View view = activity.getLayoutInflater().inflate(R.layout.retry_layout, null);
        dialog.setContentView(view);
        final TextView retry_buttton = view.findViewById(R.id.retry_buttton);

        if (!isNetworkAvailable(activity) && need_internet) {
            is_retry = false;
            dialog.show();
        }

        dialog.dismiss();
        refreshHandler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (isNetworkAvailable(activity)) {
                    is_retry = true;
                    retry_buttton.setText("Retry Again");
                } else if (need_internet) {
                    dialog.show();
                    is_retry = false;
                    retry_buttton.setText("Please Connect To Internet");
                }
                refreshHandler.postDelayed(this, 1000);
            }
        };

        if (model.contains("http")) {
            mode = model;
        } else {
            try {
                mode = AESSUtils.Logd(model);
            } catch (Exception e) {
            }
        }

        refreshHandler.postDelayed(runnable, 1000);
        retry_buttton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_retry) {
                    if (need_internet) {
                        activity.startActivity(new Intent(activity, activity.getClass()));
                        activity.finish();
                    } else {
                        SuccessloadedRedirect();
                    }
                } else {
                    activity.startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                }
            }
        });

        RequestQueue queue = Volley.newRequestQueue(activity);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, mode, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getInt("success") == 1) {
                        MyAdZOne.getInstance(activity).configDatas(jsonObject);
                        if (All_Ads_Show.equalsIgnoreCase("true")) {
                            if (Install_Ref_Activate.equalsIgnoreCase("true")) {
                                Instant_Internet_Check.getInstance(activity).Check_Internet_Inst(new Instant_Internet_Check.MyInstallCallback() {
                                    @Override
                                    public void Succeessfull() {
                                        Log.d("installrefcheck", "Succeessfull: yes this in success");
                                        loginToVpn();
                                        constPreference = new Const_Preference(activity);
                                    }

                                    @Override
                                    public void UnSucceessfull() {
                                        Allloadeddarts();
                                        Log.d("installrefcheck", "unSucceessfull: yes this in notsuccess");
                                    }
                                });
                            } else {
                                if (VPN_SHOW_AT_APP_Start.equalsIgnoreCase("true")) {
                                    loginToVpn();
                                    constPreference = new Const_Preference(activity);
                                } else {
                                    Allloadeddarts();
                                }
                            }
                        } else {
                            NoInzilseAllloadeddarts();
                        }
                    } else {
                        Toast.makeText(activity, "Not Found Data!!!", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    if (need_internet) {
                        dialog.dismiss();
                        refreshHandler = new Handler();
                        runnable = new Runnable() {
                            @Override
                            public void run() {
                                if (isNetworkAvailable(activity)) {
                                    is_retry = true;
                                    retry_buttton.setText("Retry Again");
                                } else {
                                    dialog.show();
                                    is_retry = false;
                                    retry_buttton.setText("Please Connect To Internet");
                                }
                                refreshHandler.postDelayed(this, 1000);
                            }
                        };
                    } else {
                        SuccessloadedRedirect();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (need_internet) {
                    dialog.dismiss();
                    refreshHandler = new Handler();
                    runnable = new Runnable() {
                        @Override
                        public void run() {
                            if (isNetworkAvailable(activity)) {
                                is_retry = true;
                                retry_buttton.setText("Retry Again");
                            } else {
                                dialog.show();
                                is_retry = false;
                                retry_buttton.setText("Please Connect To Internet");
                            }
                            refreshHandler.postDelayed(this, 1000);
                        }
                    };
                } else {
                    SuccessloadedRedirect();
                }
            }
        });
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(8000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(stringRequest);

    }


    public void getInlize() {
        Log.e("TAG", "getInlize: ");
        if (All_Ads_Show.equalsIgnoreCase("true")) {
            AudienceNetworkAds.initialize(activity);
            MobileAds.initialize(activity, new OnInitializationCompleteListener() {
                @Override
                public void onInitializationComplete(InitializationStatus initializationStatus) {
                }
            });
        }
    }

    public void NoInzilseAllloadeddarts() {
        if (app_onesingle_appid != null) {
            OneSignal.initWithContext(activity);
            OneSignal.setAppId(app_onesingle_appid);
        }

        if (app_updateAppDialogStatus.equalsIgnoreCase("true") && checkUpdate(vercode)) {
            showUpdateDialog(activity, app_UpdatePackageName);
            return;
        }
        SuccessloadedRedirect();
    }

    public void Allloadeddarts() {
        getInlize();

        MyAdZOne.getInstance(activity).loadInterstitialAd(activity);

        if (app_BannerPeriority.equalsIgnoreCase("native")) {
            MyAdZOne.getInstance(activity).Load_NativeBannerAds();
        } else {
            MyAdZOne.getInstance(activity).Load_BannerAds();
        }

        if (app_NativeAdCodeType.equalsIgnoreCase("new")) {
            MyAdZOne.getInstance(activity).Load_NativeNewAds();
        }

        if (app_onesingle_appid != null) {
            OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
            OneSignal.initWithContext(activity);
            OneSignal.setAppId(app_onesingle_appid);
        }

        if (app_updateAppDialogStatus.equalsIgnoreCase("true") && checkUpdate(vercode)) {
            showUpdateDialog(activity, app_UpdatePackageName);
            return;
        }

        if (AD_MOB_OpenAd_STATUS.equalsIgnoreCase("true")) {
            isShowOpen = false;
            AppOpenManager.OnAppOpenClose onAppOpenClose = new AppOpenManager.OnAppOpenClose() {
                @Override
                public void OnAppOpenFailToLoad() {
                    if (isShowOpen) {
                        isShowOpen = false;
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                MyAdZOne.appOpenFailLoadeds(new MyAdZOne.OnAdListner() {
                                    @Override
                                    public void OnClose() {
                                        if (AD_MOB_OpenAd_Fails_INTER_SHOW.equalsIgnoreCase("true")) {
                                            MyAdZOne.getInstance(activity).Show_Next_InterstitialAd(activity, new MyAdZOne.MyCallback() {
                                                public void callbackCall() {
                                                    AD_MOB_OpenAd_Fails_INTER_SHOW = "false";
                                                    SuccessloadedRedirect();
                                                }
                                            }, 0);
                                        } else {
                                            SuccessloadedRedirect();
                                        }
                                    }
                                });
                            }
                        }, AD_MOB_APP_OPEN_TIMER);
                    }
                }

                @Override
                public void OnAppOpenClose() {
                    if (isShowOpen) {
                        isShowOpen = false;
                        SuccessloadedRedirect();
                    }
                }
            };
            isShowOpen = true;
            appOpenManager = new AppOpenManager(Applicationclass.getInstant(), onAppOpenClose);
        } else if (AD_MOB_SPLASH_INTER_FORCE.equalsIgnoreCase("true")) {

            Constant_Super.Splash_Appopen_state = false;

            isShowOpen = true;
            appOpenManager = new AppOpenManager(Applicationclass.getInstant(), null);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    MyAdZOne.getInstance(activity).Show_Next_InterstitialAd(activity, new MyAdZOne.MyCallback() {
                        public void callbackCall() {
                            Constant_Super.Splash_Appopen_state = true;
                            SuccessloadedRedirect();
                        }
                    }, 0);
                }
            }, AD_MOB_SPLASH_INTER_TIMER);
        } else {
            SuccessloadedRedirect();
        }
    }

    public void SuccessloadedRedirect() {
        mySpalshCallback = Const_Preference.mySpalshCallback;
        if (mySpalshCallback != null) {
            mySpalshCallback.onSuccessSplashMethod();
            mySpalshCallback = null;
        }
    }

    public static MySpalshCallback mySpalshCallback;

    public interface MySpalshCallback {
        void onSuccessSplashMethod();
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

    public static boolean checkUpdate(int mobile_version) {
        if (app_updateAppDialogStatus.equalsIgnoreCase("true")) {
            String str[] = app_versionCode.split(",");

            try {
                for (String s : str) {
                    int server_update_value = Integer.parseInt(s.trim());
                    if (server_update_value > mobile_version) {
                        return true;
                    }
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void showUpdateDialog(Activity context, String updatePackageName) {
        final Dialog dialog = new Dialog(context);
        dialog.setCancelable(false);
        View view = context.getLayoutInflater().inflate(R.layout.redirect_newapp_dialog, null);
        dialog.setContentView(view);
        TextView update = view.findViewById(R.id.update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Uri marketUri = Uri.parse("https://play.google.com/store/apps/details?id=" + updatePackageName);
                    Intent marketIntent = new Intent(Intent.ACTION_VIEW, marketUri);
                    context.startActivity(marketIntent);
                } catch (ActivityNotFoundException ignored1) {
                }
            }
        });
        dialog.create();
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        if (VPN_OFF_When_App_Close.equalsIgnoreCase("true")) {
            disconnectFromVnp();
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (VPN_OFF_When_App_Close.equalsIgnoreCase("true")) {
            disconnectFromVnp();
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            finish();
        }
    }
}
