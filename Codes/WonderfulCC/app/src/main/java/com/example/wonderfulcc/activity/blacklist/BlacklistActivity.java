package com.example.wonderfulcc.activity.blacklist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wonderfulcc.R;
//import com.example.wonderfulcc.activity.adapter.BlackAdapter;
import com.example.wonderfulcc.bean.FriendBean;
import com.example.wonderfulcc.dao.impl.UserDaoImpl;

import java.util.ArrayList;

/**
 * @author Chuming Zhang
 * Show Blacklist
 * des：the users in blacklist who cannot see the posts
 */
public class BlacklistActivity extends AppCompatActivity {
/*
    private RecyclerView mRecyclerView;
    private UserDaoImpl userDao;
    private BlackAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("blacklist");
        setContentView(R.layout.activity_blacklist);

        mRecyclerView = findViewById(R.id.addListView);

        //String userName = SharePreferenceUtil.getInstance(this).getUserName();
        String userName = getIntent().getStringExtra("name");

        userDao = new UserDaoImpl(getApplicationContext());

        ArrayList<FriendBean> strings = userDao.searchFriendByNameNew(userName);

        ArrayList<FriendBean> mList = new ArrayList<>();
        for (FriendBean string : strings) {
            System.out.println("FriendListActivity.onCreate string.getBlackStatus() 22222=" + string.getBlackStatus());
            if (string.getBlackStatus().equals("1")) {
                mList.add(string);
            }
        }

        mAdapter = new BlackAdapter(this, mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }*/
}