package com.example.wonderfulcc.activity.normal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wonderfulcc.R;
import com.example.wonderfulcc.bean.OrdinaryUser;
import com.example.wonderfulcc.dao.impl.UserDaoImpl;


/**
 * @author  Shiyun Zhu
 */

public class AddFriendActivity extends AppCompatActivity {
    String username;
    EditText name;
    Button add;

    UserDaoImpl userDao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        name = findViewById(R.id.afNameEdit);
        add = findViewById(R.id.afButton);
        userDao = new UserDaoImpl(getApplicationContext());

        Intent intent = getIntent();
        username = intent.getStringExtra("name");


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        this.username = userDao.readLogin();

    }

    /**
     * send application to friend by type name
     */
    private void add(){
        OrdinaryUser friend = userDao.searchUserByName(name.getText().toString());

        if(friend == null){
            Toast.makeText(getApplicationContext(),"No users named "+name.getText().toString(),Toast.LENGTH_LONG).show();

        }else if(userDao.searchApplyByName(username,name.getText().toString())){
            Toast.makeText(getApplicationContext(),"Already send application to "+name.getText().toString(),Toast.LENGTH_LONG).show();
        }
        else if(name.getText().toString().equals(username)){
            Toast.makeText(getApplicationContext(),"Can not add yourself",Toast.LENGTH_LONG).show();
        }
        else if(name.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Please enter the name of your friend",Toast.LENGTH_LONG).show();
        }
        else{
            userDao.addFriend(username,name.getText().toString());
            Toast.makeText(getApplicationContext(),"Successful add",Toast.LENGTH_LONG).show();
        }

    }


}