package com.example.wonderfulcc.activity.posts;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * @author Wangyi Li
 */
@Dao
public interface MyPostsDao {
    @Insert
    void insert(MyPosts myPosts);

    @Delete
    void delete(MyPosts myPosts);

    @Update
    void update(MyPosts myPosts);

    @Query("SELECT * FROM my_posts ORDER BY post_id DESC")

    // import all that data that will come from the query into a list.
    // List<MyPosts> under the supervision of live data
    LiveData<List<MyPosts>> getAllPosts();
}
