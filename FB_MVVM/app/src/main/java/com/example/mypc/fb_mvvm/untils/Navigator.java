package com.example.mypc.fb_mvvm.untils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by MyPC on 27/06/2017.
 */

public class Navigator {
    private Activity mActivity;

    public Activity getActivity(){
        return mActivity;
    }
    public Navigator(Activity activity)
    {
        mActivity = activity;
    }
    public void Toast(String test)
    {
        Toast.makeText(mActivity,test, Toast.LENGTH_SHORT).show();
    }
    public void startactivity (Class<?extends Activity>cla, Bundle bundle){
        Intent intent = new Intent(mActivity,cla);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void startActivity(Intent intent){
        mActivity.startActivity(intent);
    }
}
