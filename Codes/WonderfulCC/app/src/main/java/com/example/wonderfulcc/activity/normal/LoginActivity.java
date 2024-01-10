package com.example.wonderfulcc.activity.normal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "EmailPassword";

    EditText userName;
    EditText password;
    Button loginButton;
    Button signUp;

    UserDaoImpl userDao;

    //private FirebaseAuth mAuth;
    // Access a Cloud Firestore instance from your Activity
    //FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //connect views
        initView();
        //build user dao
        userDao = new UserDaoImpl(getApplicationContext());

        //userDao.addUser(creatUser("taylor","123456"));
        //OrdinaryUser find = userDao.searchUserByName("taylor");
       // System.out.println(find.getPassword());

        // set click event on button
        loginButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // get username and password
                        String strUserName = userName.getText().toString().trim();
                        String strPassWord = password.getText().toString().trim();
                        login(strUserName,strPassWord);
                    }
                }
        );
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(i);
            }
        });
    }

    /**
     * init views
     */
    private void initView(){
        // connect buttons
        userName = findViewById(R.id.UserNameEdit);
        password = findViewById(R.id.PassWordEdit);
        loginButton = findViewById(R.id.LoginButton);
        signUp = findViewById(R.id.signUpButton);
    }

    private void login (String name, String password){
        OrdinaryUser user = userDao.searchUserByName(name);
        if (user==null){
            Toast.makeText(getApplicationContext(),"Please sign up first.",Toast.LENGTH_LONG).show();
        }
        else if(user.getPassword().equals(password)){
            userDao.delLogin();

            userDao.saveLogin(name);
            Toast.makeText(getApplicationContext(),"Get started.",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), HomepageActivity.class);
            intent.putExtra("name",user.getName());
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Please enter the correct password.",Toast.LENGTH_LONG).show();
        }
    }



}