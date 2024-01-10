package com.example.wonderfulcc.activity.normal;



import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.wonderfulcc.activity.blacklist.BlacklistActivity;
import com.example.wonderfulcc.activity.blacklist.FriendListActivity;
import com.example.wonderfulcc.activity.follow.CheckFollowActivity;
import com.example.wonderfulcc.activity.mainPage.MePageActivity;
import com.example.wonderfulcc.activity.posts.MyPostPreviewActivity;
import com.example.wonderfulcc.R;
import com.example.wonderfulcc.activity.search.SearchResultActivity;
import com.example.wonderfulcc.dao.impl.UserDaoImpl;



/**
 * @author  Shiyun Zhu
 */
public class HomepageActivity extends AppCompatActivity {
    private String name;
    UserDaoImpl userDao;

    private SearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        userDao = new UserDaoImpl(getApplicationContext());
        Intent intent = getIntent();
        name = intent.getStringExtra("name");


        Button showPosts = (Button) findViewById(R.id.showPosts);
        showPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyPostPreviewActivity.class);
                startActivity(intent);

            }
        });

        Button checkFollow = (Button) findViewById(R.id.buttonCheckFollow);
        checkFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CheckFollowActivity.class);
                startActivity(intent);
            }
        });




        //==============================================================
        //                      search part start
        //==============================================================
        mSearchView = findViewById(R.id.search_view);
        mSearchView.setSubmitButtonEnabled(true);

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.e("CSDN_LQR", "TextSubmit : " + query);

                Intent intent1 = new Intent(getApplicationContext(), SearchResultActivity.class);
                intent1.putExtra("text",query);
                startActivity(intent1);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.e("NEXT", "TextSubmit : " + newText);
                return false;

            }
        });

        //===============================================================
        //                      search part end
        //===============================================================


    }









    @Override
    protected void onResume() {
        super.onResume();
        this.name = userDao.readLogin();

    }

    public void toMePage(View v){
        Intent ii = new Intent(getApplicationContext(), MePageActivity.class);
        ii.putExtra("username", name);
        startActivity(ii);

    }

    public void addFriend (View view){
        Intent i = new Intent(this, FriendsActivity.class);
        i.putExtra("name",name);
        startActivity(i);
    }

    /*public void friendsList (View view){
        Intent i = new Intent(this, FriendListActivity.class);
        i.putExtra("name",name);
        startActivity(i);
    }
    public void blacklist (View view){
        Intent i = new Intent(this, BlacklistActivity.class);
        i.putExtra("name",name);
        startActivity(i);
    }*/
}