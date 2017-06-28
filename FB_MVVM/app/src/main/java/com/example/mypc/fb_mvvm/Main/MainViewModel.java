package com.example.mypc.fb_mvvm.Main;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.view.View;

import com.example.mypc.fb_mvvm.Main.Friend.List_Friend;
import com.example.mypc.fb_mvvm.untils.Navigator;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

/**
 * Created by MyPC on 27/06/2017.
 */

public class MainViewModel extends BaseObservable {
    LoginButton mloLoginButton;
    CallbackManager callbackManager;
    Navigator navigator;

    public MainViewModel(LoginButton mloLoginButton, CallbackManager callbackManager, Navigator navigator) {
        this.mloLoginButton = mloLoginButton;
        this.callbackManager = callbackManager;
        this.navigator = navigator;
    }
    public void LoginButtonClicked(View view)
    {
        loginfacbook();
    }

    private void loginfacbook() {
        mloLoginButton.setReadPermissions(Arrays.asList("user_photos", "read_custom_friendlists", "user_friends"));
        mloLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                navigator.startActivity(new Intent(navigator.getActivity(),List_Friend.class));
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

    }


}
