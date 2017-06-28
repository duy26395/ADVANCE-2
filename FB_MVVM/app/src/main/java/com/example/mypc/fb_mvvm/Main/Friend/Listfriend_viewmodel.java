package com.example.mypc.fb_mvvm.Main.Friend;

import android.databinding.BaseObservable;
import android.view.View;

import com.example.mypc.fb_mvvm.Data.Friend;
import com.example.mypc.fb_mvvm.Data.FriendJson;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPC on 27/06/2017.
 */

public class Listfriend_viewmodel extends BaseObservable {
    private FriendAdapter friendAdapter;
    private List<Friend> friends;

    public Listfriend_viewmodel(FriendAdapter adapter)
    {
        friendAdapter = adapter;
        friends = new ArrayList<>();
        loadfriend();
    }
    public FriendAdapter getAdapter()
    {
        return  friendAdapter;
    }
    public void onBtnReloadClick(View v) {
        loadfriend();
    }
    private void loadfriend() {
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/me/taggable_friends",
                null, HttpMethod.GET,
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {
                        FriendJson json = new Gson().fromJson(response.getRawResponse(),FriendJson.class);
                        friends = json.getFriends();
                        friendAdapter.addAllItems(friends);
                    }
                }

        ).executeAsync();
    }


}
