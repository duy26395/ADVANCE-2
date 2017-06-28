package com.example.mypc.fb_mvvm.Main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mypc.fb_mvvm.R;
import com.example.mypc.fb_mvvm.databinding.ActivityMainBinding;
import com.example.mypc.fb_mvvm.untils.Navigator;
import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {
    private CallbackManager callbackManager;
    private MainViewModel mainViewModel;
    private LoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton)findViewById(R.id.id_lgbtn);
        mainViewModel = new MainViewModel(loginButton,callbackManager,new Navigator(this));

        binding.setViewModel(mainViewModel);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }
}
