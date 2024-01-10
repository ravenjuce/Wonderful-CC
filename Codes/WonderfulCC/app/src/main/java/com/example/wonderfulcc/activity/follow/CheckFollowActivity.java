package com.example.wonderfulcc.activity.follow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.wonderfulcc.R;
import com.example.wonderfulcc.activity.observer.Follower;
import com.example.wonderfulcc.activity.observer.FollowerNotificationActivity;
import com.example.wonderfulcc.dao.impl.UserDaoImpl;

import java.util.ArrayList;

/**
 * @author Wangyi Li
 */
public class CheckFollowActivity extends AppCompatActivity {
    ListView listViewFollowing;
    ListView listViewFollower;

    private String myUsername;
    private ArrayAdapter followingAdapter;
    private ArrayAdapter followerAdapter;
    UserDaoImpl userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_follow);

        userDao = new UserDaoImpl(getApplicationContext());

        myUsername = userDao.readLogin();

        ArrayList<String> myFollowingList = new ArrayList<>();
        myFollowingList.addAll(userDao.generateFollowingList(myUsername));

        listViewFollowing = (ListView) findViewById(R.id.listViewFollowing);
        followingAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myFollowingList);
        listViewFollowing.setAdapter(followingAdapter);

        ArrayList<String> myFollowerList = new ArrayList<>();
        myFollowerList.addAll(userDao.generateFollowerList(myUsername));

        listViewFollower = (ListView) findViewById(R.id.listViewFollower);
        followerAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myFollowerList);
        listViewFollower.setAdapter(followerAdapter);

        Button followingNotification = (Button) findViewById(R.id.buttonFollowNotification);
        followingNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FollowerNotificationActivity.class);
                startActivity(intent);
            }
        });


    }
}