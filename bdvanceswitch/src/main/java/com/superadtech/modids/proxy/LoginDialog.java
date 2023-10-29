package com.superadtech.modids.proxy;

import static com.superadtech.modids.proxy.Const_Preference.BASE_CARRIER_ID;
import static com.superadtech.modids.proxy.Const_Preference.BASE_HOST;
import static com.superadtech.modids.proxy.Const_Preference.STORED_CARRIER_ID_KEY;
import static com.superadtech.modids.proxy.Const_Preference.STORED_HOST_URL_KEY;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.superadtech.modids.R;

import butterknife.ButterKnife;
import unified.vpn.sdk.Callback;

public class LoginDialog extends DialogFragment {

    EditText hostUrlEditText;

    EditText carrierIdEditText;

    private LoginConfirmationInterface loginConfirmationInterface;

    public LoginDialog() {
    }

    public static LoginDialog newInstance() {
        LoginDialog frag = new LoginDialog();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_login, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        SharedPreferences prefs = ((MainApp) getActivity().getApplication()).getPrefs();

        hostUrlEditText.setText(prefs.getString(STORED_HOST_URL_KEY, BASE_HOST));
        carrierIdEditText.setText(prefs.getString(STORED_CARRIER_ID_KEY, BASE_CARRIER_ID));

        hostUrlEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public void onAttach(Context ctx) {
        super.onAttach(ctx);
        if (ctx instanceof LoginConfirmationInterface) {
            loginConfirmationInterface = (LoginConfirmationInterface) ctx;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        loginConfirmationInterface = null;
    }

    public interface LoginConfirmationInterface {
        void isLoggedIn(Callback<Boolean> callback);

        void loginToVpn();

        void isConnected(Callback<Boolean> callback);

        void connectToVpn();

        void disconnectFromVnp();

        void chooseServer();

        void getCurrentServer(Callback<String> callback);

        void checkRemainingTraffic();

        void setLoginParams(String hostUrl, String carrierId);

        void loginUser();
    }
}
