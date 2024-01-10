package com.example.wonderfulcc.activity.posts;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * @author Wangyi Li
 * @reference https://www.udemy.com/course/full-android-11-masterclass-course-with-java-53-hours/learn/lecture/27266194#overview
 */
public class MyPostsViewModel extends AndroidViewModel {
    private MyPostsRepository repository;
    private LiveData<List<MyPosts>> postsList;

    public MyPostsViewModel(@NonNull Application application) {
        super(application);

        repository = new MyPostsRepository(application);
        postsList = repository.getAllPosts();
    }

    // define database operation within this class
    public void insert(MyPosts myPosts) {
        repository.insert(myPosts);
    }

    public void delete(MyPosts myPosts) {
        repository.delete(myPosts);
    }

    public void update(MyPosts myPosts) {
        repository.update(myPosts);
    }

    public LiveData<List<MyPosts>> getAllPosts() {
        return postsList;
    }
}
