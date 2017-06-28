package com.example.mypc.fb_mvvm.untils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by MyPC on 27/06/2017.
 */

public final class BindingUtils {
    private BindingUtils(){
    }
    @BindingAdapter("addrecycle")
    public static void setAdapterRecyclerView(RecyclerView recyclerView,RecyclerView.Adapter adapter)
    {
        recyclerView.setAdapter(adapter);
    }
    @BindingAdapter("srcUrl")
    public static void setImageUrl(ImageView view ,String url)
    {
        Glide.with(view.getContext()).load(url).into(view);
    }
}
