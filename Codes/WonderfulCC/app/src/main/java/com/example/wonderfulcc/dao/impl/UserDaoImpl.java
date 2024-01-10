package com.example.wonderfulcc.dao.impl;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wonderfulcc.bean.FriendBean;
import com.example.wonderfulcc.bean.OrdinaryUser;
import com.example.wonderfulcc.bean.Post;
import com.example.wonderfulcc.dao.UserDao;
import com.example.wonderfulcc.utils.DBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shiyun Zhu
 */
public class UserDaoImpl implements UserDao {

    DBHelper helper ;
    public UserDaoImpl(Context context){
        this.helper = new DBHelper(context);
    }

    public UserDaoImpl getInstance(Context c){
        return new UserDaoImpl(c);
    }

    @Override
    public void addUser(OrdinaryUser user) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("name",user.getName());
        value.put("password",user.getPassword());

        //value.put("email",user.getEmail());
        db.insert(DBHelper.TABLE_NAME_USER,null,value);
    }

    @Override
    public void deleteUser(OrdinaryUser user) {
        int uid = user.getUid();
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(DBHelper.TABLE_NAME_USER,"uid=?",new String[]{uid+""});
    }

    @Override
    public void updateUser(OrdinaryUser user) {
    }

    @Override
    public List<Post> searchUserByPost(int id) {
        return null;
    }

    @Override
    public OrdinaryUser searchUserByName(String name) {
        SQLiteDatabase db = helper.getReadableDatabase();
        OrdinaryUser user = null;
        Cursor cursor = db.query(
                DBHelper.TABLE_NAME_USER,null,"name=?",new String[]{name+""},null,null,null);
        if(cursor.moveToNext()){
            user = new OrdinaryUser();
            user.setUid(cursor.getInt(0));
            user.setName(cursor.getString(1));
            user.setPassword(cursor.getString(2));
            user.setEmail(cursor.getString(3));
        }
        return user;
    }

    @Override
    public long addFollowing(String user, String name)  {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", user);
        values.put("fName", name);
        return db.insert(DBHelper.TABLE_NAME_FOLLOWING,null,values);
    }

    @Override
    public long addFollower(String user, String name) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", user);
        values.put("fName", name);
        return db.insert(DBHelper.TABLE_NAME_FOLLOWER,null,values);
    }

    @Override
    public long addFollowerNotification(String user, String name) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", user);
        values.put("fName", name);
        return db.insert(DBHelper.TABLE_NAME_FOLLOWER_NOTIFICATION,null,values);
    }

    @Override
    public long addLikeCount(String postId, String name) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("postId", postId);
        values.put("fName", name);
        return db.insert(DBHelper.TABLE_NAME_LIKE_COUNT,null,values);
    }

    @Override
    public long addComment(String postId, String name, String content) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("postId", postId);
        values.put("name", name);
        values.put("content", content);
        return db.insert(DBHelper.TABLE_NAME_COMMENTS,null,values);
    }


    ///////////////////////////////////////////////////////////////////////////
    // record login username
    ///////////////////////////////////////////////////////////////////////////
    public void saveLogin(String username){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("id",1);
        value.put("name",username);
        //value.put("email",user.getEmail());
        db.insert(DBHelper.TABLE_LOGIN,null,value);
    }
    public void delLogin(){
        SQLiteDatabase db = helper.getWritableDatabase();
        String name = readLogin();
        if (name!=null){
            db.delete(DBHelper.TABLE_LOGIN,"name=?",new String[]{name+""});
        }

    }
    public String readLogin(){
        SQLiteDatabase db = helper.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.query(
                DBHelper.TABLE_LOGIN,null,"id=?",new String[]{1+""},null,null,null);
        if(cursor.moveToNext()){
            return cursor.getString(1);
        }
        return null;
    }



    //========================================================================
    // operations for add friends and accept applications                   //
    //========================================================================

    @Override
    public long addFriend(String user, String name)  {
        SQLiteDatabase db = helper.getWritableDatabase();
        // key values
        ContentValues values = new ContentValues();
        values.put("name", user);
        values.put("fName", name);
        values.put("acc", 0);
        //values.put("blackStatus", "0");//Whether to join the blacklist: 0: No 1: Yes
        return db.insert(DBHelper.TABLE_NAME_APPLY_FRIEND,null,values);

    }



    public ArrayList<String> findApply(String name){
        ArrayList<String> applyNames = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.query(
                DBHelper.TABLE_NAME_APPLY_FRIEND,null,"fname=?",new String[]{name+""},null,null,null);
        while(cursor.moveToNext()){
            if(cursor.getInt(3)==0){
                applyNames.add(cursor.getString(1));
            }
        }
        return applyNames;
    }

    public void accApply(String applyName, String myName){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("acc",1);
        db.update(DBHelper.TABLE_NAME_APPLY_FRIEND, values, "name=? and fname=?",new String[]{applyName,myName});
    }

    public void rejectApply(String applyName, String myName){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(DBHelper.TABLE_NAME_APPLY_FRIEND, "name=? and fname=?",new String[]{applyName,myName});
    }


    public ArrayList<String> searchFriendByName(String name){
        ArrayList<String> friendNames = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.query(
                DBHelper.TABLE_NAME_APPLY_FRIEND,null,"name=?",new String[]{name+""},null,null,null);
       while(cursor.moveToNext()){
           if(cursor.getInt(3)==1){
               friendNames.add(cursor.getString(2));
           }
       }

        @SuppressLint("Recycle") Cursor cursor2 = db.query(
                DBHelper.TABLE_NAME_APPLY_FRIEND,null,"fname=?",new String[]{name+""},null,null,null);
        while(cursor2.moveToNext()){
            if(cursor2.getInt(3)==1){
                friendNames.add(cursor2.getString(1));
            }
        }
        return friendNames;
    }

    public boolean searchApplyByName(String username, String fname){
        String friendNames = null;
        SQLiteDatabase db = helper.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.query(
                DBHelper.TABLE_NAME_APPLY_FRIEND,null,"name=? and fname=?",new String[]{username,fname},null,null,null);
        if(cursor.moveToNext()){
            return true;
        }else{return false;}

    }


    //========================================================================
    // operations for processing following & follower list                   //
    //========================================================================

    public ArrayList<String> generateFollowingList(String name){
        ArrayList<String> followingList = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(
                DBHelper.TABLE_NAME_FOLLOWING,null,"name=?",new String[]{name+""},null,null,null);
        while (cursor.moveToNext()){
            followingList.add(cursor.getString(2));
        }
        return followingList;
    }

    public ArrayList<String> generateFollowerList(String name){
        ArrayList<String> followerList = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(
                DBHelper.TABLE_NAME_FOLLOWER,null,"name=?",new String[]{name+""},null,null,null);
        while (cursor.moveToNext()){
            followerList.add(cursor.getString(2));
        }
        return followerList;
    }

    public ArrayList<String> generateFollowerNotificationList(String name){
        ArrayList<String> followerNotificationList = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(
                DBHelper.TABLE_NAME_FOLLOWER_NOTIFICATION,null,"name=?",new String[]{name+""},null,null,"id DESC");
        while (cursor.moveToNext()){
            followerNotificationList.add(cursor.getString(2));
        }
        return followerNotificationList;
    }

    public ArrayList<String> generateLikeCountList(String postId){
        ArrayList<String> likeCountList = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(
                DBHelper.TABLE_NAME_LIKE_COUNT,null,"postId=?",new String[]{postId+""},null,null,"id DESC");
        while (cursor.moveToNext()){
            likeCountList.add(cursor.getString(2));
        }
        return likeCountList;
    }
    public ArrayList<String> generateCommentsList(String postId){
        ArrayList<String> commentsList = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(
                DBHelper.TABLE_NAME_COMMENTS,null,"postId=?",new String[]{postId+""},null,null,"id DESC");
        while (cursor.moveToNext()){
            commentsList.add(cursor.getString(3));
        }
        return commentsList;
    }
/*
    // operations for blacklist
    public ArrayList<FriendBean> searchFriendByNameNew(String name) {
        ArrayList<FriendBean> friendNames = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(
                DBHelper.TABLE_NAME_APPLY_FRIEND, null, "name=?", new String[]{name + ""}, null, null, null);
        while (cursor.moveToNext()) {
            FriendBean friendBean = new FriendBean();
            friendBean.setId(cursor.getString(0));
            friendBean.setName(cursor.getString(2));
            friendBean.setBlackStatus(cursor.getString(4));
            friendNames.add(friendBean);
        }

        return friendNames;
    }

    public ArrayList<FriendBean> getAllFriendList() {
        ArrayList<FriendBean> friendNames = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(
                DBHelper.TABLE_NAME_APPLY_FRIEND, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            FriendBean friendBean = new FriendBean();
            friendBean.setId(cursor.getString(0));
            friendBean.setName(cursor.getString(2));
            friendBean.setBlackStatus(cursor.getString(4));
            friendNames.add(friendBean);
        }

        return friendNames;
    }

    // Use id to find the data in the friend list, and then update blackStatus
    public long addBlackList(String id) {
        SQLiteDatabase db = helper.getWritableDatabase();
        // key values
        ContentValues values = new ContentValues();
        values.put("blackStatus", "1");
        return db.update(DBHelper.TABLE_NAME_APPLY_FRIEND, values, "id = ?", new String[]{id});
    }*/

}
