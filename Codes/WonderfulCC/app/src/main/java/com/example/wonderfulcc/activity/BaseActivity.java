package com.example.wonderfulcc.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.wonderfulcc.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
