package com.example.wonderfulcc.activity.blacklist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wonderfulcc.R;
//import com.example.wonderfulcc.activity.adapter.FriendAdapter;
import com.example.wonderfulcc.bean.FriendBean;
import com.example.wonderfulcc.dao.impl.UserDaoImpl;

import java.util.ArrayList;

/**
 * @author Chuming Zhang
 * des: Show Friends
 */


public class FriendListActivity extends AppCompatActivity {
    /*UserDaoImpl userDao;
    RecyclerView mRecyclerView;
    private FriendAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Friends");
        setContentView(R.layout.activity_friend_list);
        mRecyclerView = findViewById(R.id.addListView);

        //String userName = SharePreferenceUtil.getInstance(this).getUserName();
        String userName = getIntent().getStringExtra("name");

        userDao = new UserDaoImpl(getApplicationContext());
        ArrayList<FriendBean> strings = userDao.searchFriendByNameNew(userName);

        ArrayList<FriendBean> mList = new ArrayList<>();
        for (FriendBean string : strings) {
            System.out.println("FriendListActivity.onCreate string.getBlackStatus()=" + string.getBlackStatus() + "  id=" + string.getId());
            if (string.getBlackStatus().equals("0")) {
                mList.add(string);
            }
        }

        mAdapter = new FriendAdapter(this, mList, userDao, userName);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);


    }*/
}