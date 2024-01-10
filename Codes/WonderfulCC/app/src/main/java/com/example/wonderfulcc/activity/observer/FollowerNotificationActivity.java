package com.example.wonderfulcc.activity.observer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.wonderfulcc.R;
import com.example.wonderfulcc.dao.impl.UserDaoImpl;

import java.util.ArrayList;

public class FollowerNotificationActivity extends AppCompatActivity {
    UserDaoImpl userDao;
    private ListView followingNotification;
    private ArrayAdapter followerNotificationAdapter;
    private String myUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follower_notification);

        userDao = new UserDaoImpl(getApplicationContext());
        myUsername = userDao.readLogin();

        ArrayList<String> followerNotificationList = new ArrayList<>();
        ArrayList<String> postUsernameList = new ArrayList<>();
        postUsernameList.addAll(userDao.generateFollowerNotificationList(myUsername));

        for (String postUsername : postUsernameList)
            followerNotificationList.add(postUsername + " makes a new post! ᕕ(ᐛ)ᕗ");

        followingNotification = (ListView) findViewById(R.id.listViewFollowingNotification);
        followerNotificationAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, followerNotificationList);
        followingNotification.setAdapter(followerNotificationAdapter);
    }
}