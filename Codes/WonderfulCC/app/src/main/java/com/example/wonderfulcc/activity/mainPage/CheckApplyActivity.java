package com.example.wonderfulcc.activity.mainPage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.wonderfulcc.R;
import com.example.wonderfulcc.activity.normal.AddFriendActivity;
import com.example.wonderfulcc.dao.impl.UserDaoImpl;

import java.util.ArrayList;
/**
 * @author  Shiyun Zhu
 */

public class CheckApplyActivity extends AppCompatActivity {

    private String username;
    ListView applyListViews;
    Button btnClear;

    ArrayList<String> applys = new ArrayList<>();
    UserDaoImpl userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_apply);


        initViews();
        userDao = new UserDaoImpl(getApplicationContext());

        // get username
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        this.username = userDao.readLogin();
        //get all applys
        applys.addAll(userDao.findApply(username));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.list_view,applys);
        applyListViews.setAdapter(arrayAdapter);

        applyListViews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String apply = applys.get(i);

                //create dialog to notify user whether to add friend by click an item in listview
                AlertDialog.Builder  builder= new AlertDialog.Builder(CheckApplyActivity.this);
                builder.setTitle("Add friend");
                builder.setMessage("Do you want to add "+apply+ "as your friend?");
                builder.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        userDao.accApply(apply, username);

                        startActivity(new Intent(CheckApplyActivity.this, CheckApplyActivity.class));
                        finish();
                    }
                });

                builder.setNegativeButton("Refuse", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        userDao.rejectApply(apply, username);
                        startActivity(new Intent(CheckApplyActivity.this, CheckApplyActivity.class));
                        finish();
                    }
                });
                //build dialog according to the builder
                AlertDialog dialog = builder.create();
                dialog.show();


            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        this.username = userDao.readLogin();

    }
    /**
     * init views
     */
    private void initViews(){
        applyListViews = findViewById(R.id.check_apply_listview);
        btnClear = findViewById(R.id.check_apply_btn_clear);

    }


}