package com.example.wonderfulcc.activity.normal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import com.example.wonderfulcc.R;
import com.example.wonderfulcc.activity.mainPage.MessageActivity;
import com.example.wonderfulcc.dao.UserDao;
import com.example.wonderfulcc.dao.impl.UserDaoImpl;

import java.util.ArrayList;


/**
 * @author  Shiyun Zhu
 */
public class FriendsActivity extends AppCompatActivity {
    Button addButton,showButton;
    ListView friendListView;
    private String name;

    ArrayList<String> my_friends = new ArrayList<>();
    UserDaoImpl userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        initViews();
        userDao = new UserDaoImpl(getApplicationContext());

        // get username
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        my_friends.addAll(userDao.searchFriendByName(name));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.list_view,my_friends);
        friendListView.setAdapter(arrayAdapter);
        friendListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String friendName = my_friends.get(i);
                AlertDialog.Builder builder = new AlertDialog.Builder(FriendsActivity.this);
                builder.setTitle(friendName);
                builder.setMessage("What do you want to do with "+friendName);
                builder.setPositiveButton("Send message", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent1 = new Intent(getApplicationContext(), MessageActivity.class);
                        intent1.putExtra("fname",friendName);
                        startActivity(intent1);

                    }
                });
                builder.setNegativeButton("Unfriend", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });



        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AddFriendActivity.class);
                i.putExtra("name",name);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.name = userDao.readLogin();

    }

    /**
     * init views
     */
    private void initViews(){
        addButton = findViewById(R.id.addFriendButton);
        friendListView = findViewById(R.id.addListView);
        showButton = findViewById(R.id.showFriendButton);
    }

}