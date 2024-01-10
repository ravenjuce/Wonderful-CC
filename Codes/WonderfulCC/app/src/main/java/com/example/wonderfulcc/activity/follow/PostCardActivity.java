package com.example.wonderfulcc.activity.follow;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wonderfulcc.R;
import com.example.wonderfulcc.dao.impl.UserDaoImpl;

import java.util.ArrayList;

/**
 * @author Wangyi Li
 */
public class PostCardActivity extends AppCompatActivity {

    private TextView textViewUsername, textviewTitle, textViewDescription, textViewTag, textViewLikeCount;
    private ImageView imageViewImage;
    private Button buttonFollow;
    private ImageButton buttonLike, buttonSend;

    private String postUsername, title, description, tag, myUsername;
    private byte[] image;
    private String postId;
    private ArrayList<String> likeUsernameList;
    private ArrayList<String> commentList = new ArrayList<>();;

    private EditText editTextComment;
    private ArrayAdapter commentAdapter;

    UserDaoImpl userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_card);

        userDao = new UserDaoImpl(getApplicationContext());


        Intent intent = getIntent();
        textViewUsername = (TextView) findViewById(R.id.postUsername);
        textviewTitle = (TextView) findViewById(R.id.postTitle);
        textViewDescription = (TextView) findViewById(R.id.postDescription);
        textViewTag = (TextView) findViewById(R.id.postTag);
        imageViewImage = (ImageView) findViewById(R.id.postImage);

        postId = intent.getStringExtra("postId");
        postUsername = intent.getStringExtra("postUsername");
        title = intent.getStringExtra("title");
        description = intent.getStringExtra("description");
        tag = intent.getStringExtra("tag");
        image = intent.getByteArrayExtra("image");

        textViewUsername.setText(postUsername);
        textviewTitle.setText(title);
        textViewDescription.setText(description);
        textViewTag.setText(tag);
        imageViewImage.setImageBitmap(BitmapFactory.decodeByteArray(image, 0, image.length));

        // generate myFollowingList
        myUsername = userDao.readLogin();
        ArrayList<String> myFollowingList = new ArrayList<>();

        myFollowingList.addAll(userDao.generateFollowingList(myUsername));

        buttonFollow = (Button) findViewById(R.id.buttonFollowConf);
        buttonFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myUsername.equals(postUsername)) {
                    Toast.makeText(getApplicationContext(), "You can't follow yourself.", Toast.LENGTH_LONG).show();
                } else {
                    if (myFollowingList.contains(postUsername)) {
//                        intent = new Intent(getApplication(), UnfollowActivity.class);
                        Toast.makeText(getApplicationContext(), "You have followed the user.", Toast.LENGTH_LONG).show();
                    } else {
                        userDao.addFollowing(myUsername,postUsername);
                        userDao.addFollower(postUsername,myUsername);
                        Toast.makeText(getApplicationContext(), "You have successfully followed " + postUsername + "!", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });




        buttonLike = (ImageButton) findViewById(R.id.buttonLike);
        textViewLikeCount = (TextView) findViewById(R.id.textViewLikeCount);



        likeUsernameList = new ArrayList<>();
        likeUsernameList.addAll(userDao.generateLikeCountList(postId));


        buttonLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (likeUsernameList.contains(myUsername)) {
                    Toast.makeText(getApplicationContext(), "You have already liked the post", Toast.LENGTH_LONG).show();
                } else {
                    userDao.addLikeCount(postId, myUsername);
                    Toast.makeText(getApplicationContext(), "Like successfully!", Toast.LENGTH_LONG).show();
                }
            }
        });
        textViewLikeCount.setText(likeUsernameList.size()+"");

        editTextComment = (EditText) findViewById(R.id.editTextComment);

        //commentList read from db
        commentList = userDao.generateCommentsList(postId);

        buttonSend = (ImageButton) findViewById(R.id.buttonSend);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = "@" + myUsername + ": " + editTextComment.getText().toString();
                commentList.add(content);
                Toast.makeText(getApplicationContext(), "You have commented successfully!", Toast.LENGTH_LONG).show();
                userDao.addComment(postId, myUsername, content);
                // set EditText to empty
                editTextComment.setText("");
                commentAdapter.notifyDataSetChanged();
            }
        });

        ListView listViewCommentList = (ListView) findViewById(R.id.listViewCommentList);

        commentAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, commentList);
//        listViewCommentList.setOnItemClickListener(myListener);
        listViewCommentList.setAdapter(commentAdapter);


    }

}