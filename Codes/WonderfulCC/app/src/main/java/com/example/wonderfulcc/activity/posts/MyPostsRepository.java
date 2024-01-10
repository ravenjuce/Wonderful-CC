package com.example.wonderfulcc.activity.posts;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * @author Wangyi Li
 * @reference https://www.udemy.com/course/full-android-11-masterclass-course-with-java-53-hours/learn/lecture/27266194#overview
 */
public class MyPostsRepository {

    private MyPostsDao myPostsDao;
    private LiveData<List<MyPosts>> postsList;

    public MyPostsRepository(Application application) {
        MyPostsDatabase database = MyPostsDatabase.getInstance(application);
        // user the database object created to find the myPostsDao object
        myPostsDao = database.myPostsDao();
        // get postList through the getAllPosts() in MyPostsDao
        postsList = myPostsDao.getAllPosts();
    }


    public void insert(MyPosts myPosts) {
        new InsertPostAsyncTask(myPostsDao).execute(myPosts);
    }

    public void delete(MyPosts myPosts) {
        new DeletePostAsyncTask(myPostsDao).execute(myPosts);
    }

    public void update(MyPosts myPosts) {
        new UpdatePostAsyncTask(myPostsDao).execute(myPosts);
    }


    // create getAllImages method: return the images list array created above
    public LiveData<List<MyPosts>> getAllPosts() {
        return postsList;
    }

    /**
     * asynchronous task 异布任务
     * first parameter --> doInBackground() (doing the progress in the background)
     * give the parameter belonging to the MyImages class to the doInBackground method so it can perform update
     * second parameter --> onProgressUpdate
     * third parameter --> return type of doInBackground()
     *
     * create a new class for background operation
     * create a asynchronous task for the inset and each operation
     */
    private static class InsertPostAsyncTask extends AsyncTask<MyPosts, Void, Void> {
        MyPostsDao postsDao;

        public InsertPostAsyncTask(MyPostsDao postsDao) {
            this.postsDao = postsDao;
        }

        @Override
        protected Void doInBackground(MyPosts... myPosts) {
            postsDao.insert(myPosts[0]);
            return null;
            // back to insert method above
        }
    }

    private static class UpdatePostAsyncTask extends AsyncTask<MyPosts, Void, Void> {
        MyPostsDao postsDao;

        public UpdatePostAsyncTask(MyPostsDao postsDao) {
            this.postsDao = postsDao;
        }

        @Override
        protected Void doInBackground(MyPosts... myPosts) {
            postsDao.update(myPosts[0]);
            return null;
        }
    }

    private static class DeletePostAsyncTask extends AsyncTask<MyPosts, Void, Void> {
        MyPostsDao postsDao;

        public DeletePostAsyncTask(MyPostsDao postsDao) {
            this.postsDao = postsDao;
        }

        @Override
        protected Void doInBackground(MyPosts... myPosts) {
            postsDao.delete(myPosts[0]);
            return null;
        }
    }
}
