package com.example.wonderfulcc.activity.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wonderfulcc.R;
import com.example.wonderfulcc.bean.FriendBean;
import com.example.wonderfulcc.dao.impl.UserDaoImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chuming Zhang
 * des: Friends Adapter
 */
/*
public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {

    private Context context;
    List<FriendBean> list;
    UserDaoImpl userDao;
    String userName;

    public FriendAdapter(Context context, List<FriendBean> list, UserDaoImpl userDao, String userName) {
        this.context = context;
        this.list = list;
        this.userDao = userDao;
        this.userName = userName;
    }

    public void setNewsData(List<FriendBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_friend, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        FriendBean bean = list.get(position);
        holder.tv01.setText("User：" + bean.getName());

        holder.btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FriendBean friendBean = list.get(position);
                System.out.println("FriendAdapter.onClick===" + friendBean.getId());

                long result = userDao.addBlackList(friendBean.getId());
                Toast.makeText(context, "result=" + result, Toast.LENGTH_SHORT).show();

                ArrayList<FriendBean> strings = userDao.searchFriendByNameNew(userName);
                ArrayList<FriendBean> mList = new ArrayList<>();
                for (FriendBean string : strings) {
                    if (string.getBlackStatus().equals("0")) {
                        mList.add(string);
                    }
                }
                setNewsData(mList);


            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv01;
        private Button btnADD;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv01 = itemView.findViewById(R.id.tvName);
            btnADD = itemView.findViewById(R.id.btnADD);
        }
    }


}*/
