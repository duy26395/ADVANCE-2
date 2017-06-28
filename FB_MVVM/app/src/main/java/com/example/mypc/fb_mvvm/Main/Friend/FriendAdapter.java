package com.example.mypc.fb_mvvm.Main.Friend;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mypc.fb_mvvm.Data.Friend;
import com.example.mypc.fb_mvvm.R;
import com.example.mypc.fb_mvvm.databinding.ItemListBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPC on 27/06/2017.
 */

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.viewhodel> {
    private List<Friend> friends;

    public FriendAdapter() {
        friends = new ArrayList<>();
    }


    @Override
    public viewhodel onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_list,parent,false);
        return  new viewhodel(binding);
    }

    @Override
    public void onBindViewHolder(viewhodel holder, int position) {
            holder.bindata(friends.get(position));
    }
    public void addAllItems(List<Friend> friendList){
        friends.clear();
        friends.addAll(friendList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return  friends == null?0 : friends.size();
    }

    public class viewhodel extends RecyclerView.ViewHolder {
        private ItemListBinding listBinding;

        public viewhodel(ItemListBinding binding) {
            super(binding.getRoot());
            listBinding = binding;
        }

        public void bindata(Friend friend) {
           listBinding.setViewmodel(new itemViewmodel(friend));
            listBinding.executePendingBindings();
        }
    }

}
