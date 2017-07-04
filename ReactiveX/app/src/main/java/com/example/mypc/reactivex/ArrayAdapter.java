package com.example.mypc.reactivex;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MyPC on 30/06/2017.
 */

public class ArrayAdapter extends RecyclerView.Adapter<ArrayAdapter.viewhodel> {
    private ArrayList<Data> datas;

    public ArrayAdapter(ArrayList<Data> list) {
        datas = list;
    }

    @Override
    public viewhodel onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return  new viewhodel(view);
    }

    @Override
    public void onBindViewHolder(viewhodel holder, int position) {
        holder.mName.setText(datas.get(position).getName());
        holder.mVersion.setText(datas.get(position).getVer());
        holder.mApi.setText(datas.get(position).getApi());
    }

    @Override
    public int getItemCount() {
        return datas.size();
       // return (datas == null) ? 0 : datas.size();
    }

    public class viewhodel extends RecyclerView.ViewHolder {
        private TextView mName,mVersion,mApi;

        public viewhodel(View itemView) {
            super(itemView);
            mName = (TextView)itemView.findViewById(R.id.tv_name);
            mVersion = (TextView)itemView.findViewById(R.id.tv_version);
            mApi = (TextView)itemView.findViewById(R.id.tv_api_level);

        }
    }
}
