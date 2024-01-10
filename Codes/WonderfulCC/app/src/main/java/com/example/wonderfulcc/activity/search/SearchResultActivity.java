package com.example.wonderfulcc.activity.search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wonderfulcc.R;
import com.example.wonderfulcc.utils.tokenizer.Parser;
import com.example.wonderfulcc.utils.tokenizer.Tokenizer;

/**
 * @author  Shiyun Zhu
 */
public class SearchResultActivity extends AppCompatActivity {

    TextView name,tag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        // Get message from search bar and divide them into name and tag
        Intent intent = getIntent();
        String search = intent.getStringExtra("text");



        Parser parser = new Parser(new Tokenizer(search));
        String postAuthor = parser.getName();
        String strTag = parser.getTags();
        name = findViewById(R.id.show_name_search);
        tag = findViewById(R.id.show_tag_search);
        name.setText(postAuthor);
        tag.setText(strTag);



    }
}