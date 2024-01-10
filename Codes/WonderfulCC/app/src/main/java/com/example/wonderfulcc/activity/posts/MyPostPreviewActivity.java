package com.example.wonderfulcc.activity.posts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wonderfulcc.R;
import com.example.wonderfulcc.activity.follow.PostCardActivity;
import com.example.wonderfulcc.bean.FriendBean;
import com.example.wonderfulcc.dao.impl.UserDaoImpl;
import com.example.wonderfulcc.utils.SharePreferenceUtil;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangyi Li
 */
public class MyPostPreviewActivity extends AppCompatActivity {
    private RecyclerView rv;
    private FloatingActionButton fab;
    private MyPostsViewModel myPostsViewModel;

    private ActivityResultLauncher<Intent> activityResultLauncherForAddPost;

    private String myUsername;

    UserDaoImpl userDao;
    private ArrayList<String> myFollowerList = new ArrayList<>();

    private List<MyPosts> myPostsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_post_preview);

        userDao = new UserDaoImpl(getApplicationContext());
        myUsername = userDao.readLogin();

        // register activity for add post
        registerActivityForAddPost();

        rv = findViewById(R.id.rv);
        fab = findViewById(R.id.fab);

        // create and define MyPostsAdapter in the MyPostPreviewActivity
        rv.setLayoutManager(new LinearLayoutManager(this));
        MyPostsAdapter adapter = new MyPostsAdapter();
        // reassign the adapter object to the recyclerView from top to bottom
        rv.setAdapter(adapter);

        // connect with viewModel
        /**
         * @reference https://www.udemy.com/course/full-android-11-masterclass-course-with-java-53-hours/learn/lecture/27266194#overview
         */
        myPostsViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(MyPostsViewModel.class);
        myPostsViewModel.getAllPosts().observe(MyPostPreviewActivity.this, new Observer<List<MyPosts>>() { // the observer method
            @Override
            public void onChanged(List<MyPosts> myPosts) {
                // set PostsList in adapter
                adapter.setPostsList(myPosts);
                // write the notified dataset changed method in setter method in Adapter class
                myPostsList = myPosts;
                //dealWith(myPosts, adapter);

            }
        });

        // set OnClickListener on fab to add post
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyPostPreviewActivity.this, AddPostActivity.class);

                // startActivityForResult()
                // activityResultLauncher (create an object from the activityResultLauncher class in the global area
                activityResultLauncherForAddPost.launch(intent);
            }
        });


        // go to the main activity and send the data to the update image activity.
        adapter.setListener(new MyPostsAdapter.OnPostClickListener() {
            @Override
            public void onPostClick(MyPosts myPosts) {
                Intent intent = new Intent(MyPostPreviewActivity.this, PostCardActivity.class);
                // here will send the id differently, so I will learn what data to update
                intent.putExtra("id", myPosts.getPost_id());
                intent.putExtra("title", myPosts.getPost_title());
                intent.putExtra("description", myPosts.getPost_description());
                intent.putExtra("tag", myPosts.getPost_tag());
                intent.putExtra("image", myPosts.getImage());
                intent.putExtra("postUsername", myPosts.getUsername());
                intent.putExtra("myUsername", myUsername);
                startActivity(intent);
            }
        });
    }

    public void registerActivityForAddPost() {
        activityResultLauncherForAddPost = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        // receive the data from AddPostActivity
                        int resultCode = result.getResultCode();
                        Intent data = result.getData();

                        // check the user has sent data from the addImageActivity
                        if (resultCode == RESULT_OK && data != null) {
                            // transfer the data to variables using keywords and the data object
                            String title = data.getStringExtra("title");
                            String description = data.getStringExtra("description");
                            String tag = data.getStringExtra("tag");
                            byte[] image = data.getByteArrayExtra("image");

                            String postIsVisible = data.getStringExtra("postIsVisible");
                            System.out.println("MyPostPreviewActivity.onActivityResult postIsVisible="+postIsVisible);

                            // create an project from MyPosts class
                            // MyPosts myPosts = new MyPosts(myUsername, title, description, tag, image);
                            MyPosts myPosts = new MyPosts(myUsername, title, description, tag, image, postIsVisible);

                            // save the data in database use insert() method in myImagesViewModel
                            myPostsViewModel.insert(myPosts);

                            // in order to show the data on the screen (write code in onBindViewHolder())

                            myFollowerList.addAll(userDao.generateFollowerList(myUsername));

                            for (String followerUsername : myFollowerList)
                                userDao.addFollowerNotification(followerUsername, myUsername);
                        }
                    }
                });
    }
    /*
    private void dealWith(List<MyPosts> myImages, MyPostsAdapter adapter) {

        //Check the whole list, if usernames are different, then make the post invisible
        //  All the invisible posts cannot be seen by users who did not post it

        List<MyPosts> myPostsList = new ArrayList<>();
        for (int i = 0; i < myImages.size(); i++) {
            MyPosts myPosts = myImages.get(i);
            System.out.println("MyPostPreviewActivity.onChanged myPosts getPostIsVisible=" + myPosts.getPostIsVisible());

            if (!myPosts.getUsername().equals(myUsername)) {
                if (myPosts.getPostIsVisible().equals("1")) {
                    myPostsList.add(myPosts);
                } else {
                    //Pass the post
                }
            } else {
                //the same username as login
                myPostsList.add(myPosts);
            }
        }
        */

/*
        UserDaoImpl userDao = new UserDaoImpl(getApplicationContext());
        ArrayList<FriendBean> strings = userDao.getAllFriendList();

        ArrayList<FriendBean> mBlackList = new ArrayList<>();
        for (FriendBean string : strings) {
            System.out.println("FriendListActivity.onCreate string.getBlackStatus()=" + string.getBlackStatus() + "  id=" + string.getId());
            if (string.getBlackStatus().equals("1")) {
                mBlackList.add(string);
            }
        }
        // Tell the username in the blacklist or not
        boolean isBlackListFriend = false;
        for (FriendBean bean : mBlackList) {
            if (bean.getName().equals(myUsername)) {
                isBlackListFriend = true;
            }
        }
        if (isBlackListFriend) {
            Toast.makeText(MyPostPreviewActivity.this, "You are in the blacklist, unable to check!", Toast.LENGTH_SHORT).show();
        } else {
            adapter.setPostsList(myPostsList);
        }
    }*/
}