package com.example.wonderfulcc.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wonderfulcc.R;
import com.example.wonderfulcc.bean.FriendBean;

import java.util.List;

/**
 * @author Chuming Zhang
 * des：blacklist adapter
 */
/*
public class BlackAdapter extends RecyclerView.Adapter<BlackAdapter.BulletinViewHolder> {

    private Context context;
    List<FriendBean> list;

    public BlackAdapter(Context context, List<FriendBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setNewsData(List<FriendBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public BulletinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_black, parent, false);
        return new BulletinViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull BulletinViewHolder holder, int position) {
        FriendBean bean = list.get(position);
        holder.tv01.setText("Username：" + bean.getName());

        holder.btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BulletinViewHolder extends RecyclerView.ViewHolder {

        private TextView tv01;
        private Button btnADD;

        public BulletinViewHolder(@NonNull View itemView) {
            super(itemView);
            tv01 = itemView.findViewById(R.id.tvName);
            btnADD = itemView.findViewById(R.id.btnADD);
        }
    }


}*/
