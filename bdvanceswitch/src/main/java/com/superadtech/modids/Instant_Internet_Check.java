package com.superadtech.modids;

import static com.superadtech.modids.Constant_Super.installReferrer;
import static com.superadtech.modids.MyAdZOne.Install_Ref1;
import static com.superadtech.modids.MyAdZOne.Install_Ref2;
import static com.superadtech.modids.MyAdZOne.Install_Ref3;
import static com.superadtech.modids.MyAdZOne.Install_Ref4;
import static com.superadtech.modids.MyAdZOne.Install_Ref_Activate;

import android.app.Activity;
import android.os.RemoteException;

import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;

public class Instant_Internet_Check {

    public static Activity activity;
    public static Instant_Internet_Check myAdZOne;
    static MyInstallCallback myCallbackinstall;

    public interface MyInstallCallback {
        void Succeessfull();

        void UnSucceessfull();
    }

    public Instant_Internet_Check(Activity activity1) {
        activity = activity1;
    }

    public static Instant_Internet_Check getInstance(Activity activity1) {
        activity = activity1;
        if (myAdZOne == null) {
            myAdZOne = new Instant_Internet_Check(activity);
        }
        return myAdZOne;
    }

    public void Check_Internet_Inst(MyInstallCallback myCallbackx) {
        myCallbackinstall = myCallbackx;

        InstallReferrerClient referrerClient = InstallReferrerClient.newBuilder(activity).build();
        referrerClient.startConnection(new InstallReferrerStateListener() {
            @Override
            public void onInstallReferrerSetupFinished(int responseCode) {
                if (responseCode == InstallReferrerClient.InstallReferrerResponse.OK) {
                    try {
                        ReferrerDetails response = referrerClient.getInstallReferrer();
                        installReferrer = response.getInstallReferrer();

                        if (installReferrer != null) {
                            if (Install_Ref_Activate.equals("true")) {
                                try {
                                    if (installReferrer.contains(Install_Ref1) ||
                                            installReferrer.contains(Install_Ref2) ||
                                            installReferrer.contains(Install_Ref3) ||
                                            installReferrer.contains(Install_Ref4)) {
                                        if (myCallbackx != null) {
                                            myCallbackx.Succeessfull();
                                            myCallbackinstall = null;
                                        }
                                    } else {
                                        if (myCallbackx != null) {
                                            myCallbackx.UnSucceessfull();
                                            myCallbackinstall = null;
                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                } finally {
                                    referrerClient.endConnection();
                                }
                            } else {
                                if (myCallbackx != null) {
                                    myCallbackx.UnSucceessfull();
                                    myCallbackinstall = null;
                                }
                            }
                        } else {
                            if (myCallbackx != null) {
                                myCallbackx.UnSucceessfull();
                                myCallbackinstall = null;
                            }
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                } else {
                    if (myCallbackx != null) {
                        myCallbackx.UnSucceessfull();
                        myCallbackinstall = null;
                    }
                }
            }

            @Override
            public void onInstallReferrerServiceDisconnected() {
                // Handle the case where the service is disconnected
            }
        });
    }
}
