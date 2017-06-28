package com.example.mypc.fb_mvvm.Main.Friend;

import android.databinding.BaseObservable;

import com.example.mypc.fb_mvvm.Data.Friend;

/**
 * Created by MyPC on 27/06/2017.
 */

public class itemViewmodel extends BaseObservable {
    Friend friend;

    public itemViewmodel(Friend friend) {
        this.friend = friend;
    }

    public String getName() {
        return friend.getName();
    }

    public String getImage() {
        return friend.getImage();
    }
}
