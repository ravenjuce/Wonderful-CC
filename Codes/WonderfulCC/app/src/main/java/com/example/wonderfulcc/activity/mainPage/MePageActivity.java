package com.example.wonderfulcc.activity.mainPage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wonderfulcc.R;
import com.example.wonderfulcc.dao.impl.UserDaoImpl;
import com.example.wonderfulcc.utils.UItools.FontIconView;

/**
 * @author  Shiyun Zhu
 */

public class MePageActivity extends AppCompatActivity {
    private String userName;
    Button meBtnCheckPost,meBtnCheckApply;
    TextView meTvName;

    UserDaoImpl userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_page);

        userDao = new UserDaoImpl(getApplicationContext());
        initViews();
        //get username who login and display on the textview
        Intent intent = getIntent();
        userName = intent.getStringExtra("username");
        meTvName.setText(userName);

        meBtnCheckApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),CheckApplyActivity.class);
                i.putExtra("username",userName);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.userName = userDao.readLogin();
        meTvName.setText(userName);
    }

    private void initViews(){
        meBtnCheckApply = findViewById(R.id.me_btn_checkApply);
        meBtnCheckPost = findViewById(R.id.me_btn_checkMyPost);
        meTvName = findViewById(R.id.me_tv_name_showMyName);
    }
}