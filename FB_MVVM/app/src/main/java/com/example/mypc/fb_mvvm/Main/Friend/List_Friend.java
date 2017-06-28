package com.example.mypc.fb_mvvm.Main.Friend;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.mypc.fb_mvvm.R;
import com.example.mypc.fb_mvvm.databinding.ActivityListFriendBinding;

public class List_Friend extends AppCompatActivity {
    private Listfriend_viewmodel listfriendViewmodel;
    private Button button;
    private FriendAdapter friendAdapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListFriendBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_list__friend);

        friendAdapter = new FriendAdapter();
        listfriendViewmodel = new Listfriend_viewmodel(friendAdapter);
        binding.setViewModel(listfriendViewmodel);

        recyclerView = (RecyclerView)findViewById(R.id.idrc);
        recyclerView.setAdapter(friendAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
