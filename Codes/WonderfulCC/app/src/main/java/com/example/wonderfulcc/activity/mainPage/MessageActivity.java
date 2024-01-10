package com.example.wonderfulcc.activity.mainPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wonderfulcc.R;
import com.example.wonderfulcc.bean.Msg;
import com.example.wonderfulcc.dao.impl.UserDaoImpl;

import java.util.ArrayList;
import java.util.List;
/**
 * @author  Shiyun Zhu
 */

public class MessageActivity extends AppCompatActivity {
    private String userName;
    private UserDaoImpl userDao;
    private RecyclerView circleRecycle;
    private EditText inputEdit;
    private Button btn_send;
    private TextView textView;
    private List<Msg> msgList = new ArrayList<>();
    private MsgAdapter msgAdapter;


    //inner class for BroadcastReceiver
    public class BroadcastMain extends BroadcastReceiver {
        //listener for broadcast
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("brocast","------> get message ");

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        userDao = new UserDaoImpl(getApplicationContext());

        Intent intent1 = new Intent();
        String friend = intent1.getStringExtra("fname");
        textView = findViewById(R.id.messName_tv);
        textView.setText(friend);

        circleRecycle = findViewById(R.id.circle_edit);
        inputEdit =  findViewById(R.id.et_content);
        btn_send = findViewById(R.id.btn_send);

        // init message
        initMsgs();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        circleRecycle.setLayoutManager(layoutManager);
        msgAdapter = new MsgAdapter(msgList);
        circleRecycle.setAdapter(msgAdapter);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputEdit.getText().toString();
                if (!"".equals(content)){
                    Msg msg = new Msg(content,Msg.TYPE_SEND);
                    msgList.add(msg);
                    msgAdapter.notifyItemInserted(msgList.size() - 1);// when get new flash the adapter
                    circleRecycle.scrollToPosition(msgList.size() - 1);
                    inputEdit.setText("");// clear
                }
            }
        });
    }

    private void initMsgs() {
        Msg msg1 = new Msg("Chui si bing zhong jing zuo qi?",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("xiao wen ke cong he chu lai?",Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3 = new Msg("tong zhi, ke zhao dao ni la !",Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }

    private class LocalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("brocast","-----> get");
            Toast.makeText(MessageActivity.this,"local broadcast",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.userName = userDao.readLogin();
    }

}