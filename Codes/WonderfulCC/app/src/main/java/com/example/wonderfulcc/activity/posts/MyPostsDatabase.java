package com.example.wonderfulcc.activity.posts;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * @author Wangyi Li
 * @reference https://www.udemy.com/course/full-android-11-masterclass-course-with-java-53-hours/learn/lecture/27266194#overview
 */
@Database(entities = MyPosts.class, version = 1)
public abstract class MyPostsDatabase extends RoomDatabase {
    public abstract MyPostsDao myPostsDao();

    // singleton
    private static MyPostsDatabase instance;
    public static synchronized MyPostsDatabase getInstance(Context context) {
        // if no database has been created for instance
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext()
                    ,MyPostsDatabase.class, "my_posts_database")
                    .fallbackToDestructiveMigration()
                    .build();
            // write fallbackToDestructiveMigration() outside
        }
        return instance;
    }
}
