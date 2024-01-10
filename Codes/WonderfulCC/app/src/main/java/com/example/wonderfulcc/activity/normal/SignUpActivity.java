package com.example.wonderfulcc.activity.normal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wonderfulcc.activity.posts.MyPostPreviewActivity;
import com.example.wonderfulcc.R;
import com.example.wonderfulcc.bean.OrdinaryUser;
import com.example.wonderfulcc.dao.impl.UserDaoImpl;

/**
 * @author Shiyun Zhu
 */
public class SignUpActivity extends AppCompatActivity {

    Button sinUp;
    EditText userName, password;
    UserDaoImpl userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userDao = new UserDaoImpl(getApplicationContext());
        initView();
        userDao.delLogin();

        sinUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userName.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Please type in the username.",Toast.LENGTH_LONG).show();
            }else if ( password.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Please type in the password.",Toast.LENGTH_LONG).show();
                }

                else{
                    createUser(userName.getText().toString(),
                            password.getText().toString());
                }
            }
        });

    }

    private void initView(){
        sinUp = findViewById(R.id.signsignUpButton);
        userName = findViewById(R.id.signUserNameEdit);
        password = findViewById(R.id.signPassWordEdit);
    }

    private void createUser(String name, String pass){
        OrdinaryUser usr = new OrdinaryUser();
        usr.setName(name);
        usr.setPassword(pass);
        if(userDao.searchUserByName(name)!= null){
            Toast.makeText(getApplicationContext(),"User already exist",Toast.LENGTH_LONG).show();
        }
        else{
            userDao.addUser(usr);
            userDao.delLogin();
            userDao.saveLogin(name);
            Toast.makeText(getApplicationContext(),"Registration successful, going to the main page",Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(), HomepageActivity.class);
            i.putExtra("name",name);
            startActivity(i);

        }

    }
}