package com.example.wonderfulcc.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wonderfulcc.bean.OrdinaryUser;


/**
 * build the helper class of SQLite
 * @author Shiyun Zhu
 */
public class DBHelper extends SQLiteOpenHelper {


    //declare the name of database
    public static  final String DB_NAME = "wanderfulcc.db";
    //declare the  name of table
    public static final String TABLE_NAME_APPLY_FRIEND = "applyFriend";
    public static final String TABLE_NAME_USER = "user";
    public  static  final String TABLE_NAME_POST = "post";
    public  static  final String TABLE_LOGIN = "login";

    public  static  final String TABLE_NAME_FOLLOWING = "following";
    public  static  final String TABLE_NAME_FOLLOWER = "follower";
    public  static  final String TABLE_NAME_FOLLOWER_NOTIFICATION = "followerNotification";
    public  static  final String TABLE_NAME_LIKE_COUNT = "likeCount";
    public  static  final String TABLE_NAME_COMMENTS = "comment";

    //declare  the sql to build table
    private static  final String CREATE_ADD_FRIEND_TABLE_SQL = "create table "+TABLE_NAME_APPLY_FRIEND+" (id integer primary key autoincrement, name text, fname text, acc integer)";
    private static final String CREATE_USER_TABLE_SQL = "create table " + TABLE_NAME_USER + " (id integer primary key autoincrement, name text, password text, email text)";
    private static final String CREATE_POST_TABLE_SQL = "create table "+TABLE_NAME_POST+" (id integer primary key autoincrement, name text, content text, time text, tag text)";
    private static final String CRATE_LOGIN_TABLE_SQL = "create table "+TABLE_LOGIN+" (id integer, name text)";

    private static  final String CREATE_FOLLOWING_TABLE_SQL = "create table "+TABLE_NAME_FOLLOWING+" (id integer primary key autoincrement, name text, fname text)";
    private static  final String CREATE_FOLLOWER_TABLE_SQL = "create table "+TABLE_NAME_FOLLOWER+" (id integer primary key autoincrement, name text, fname text)";
    private static  final String CREATE_FOLLOWER_NOTIFICATION_TABLE_SQL = "create table "+TABLE_NAME_FOLLOWER_NOTIFICATION+" (id integer primary key autoincrement, name text, fname text)";
    private static  final String CREATE_LIKE_COUNT_TABLE_SQL = "create table "+TABLE_NAME_LIKE_COUNT+" (id integer primary key autoincrement, postId text, fname text)";
    private static  final String CREATE_LIKE_COMMENTS_SQL = "create table "+TABLE_NAME_COMMENTS+" (id integer primary key autoincrement, postId text, name text, content text)";


    //declare the version of database
    public static int DB_VERSION = 1;


    //declare the constructor
    public DBHelper(Context context){

        super(context, DB_NAME,null, DB_VERSION);
        System.out.println("build database");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("build tables");

        //String sql = "create table user (id integer primary key autoincrement, name text, password text, email text);";

        db.execSQL(CREATE_USER_TABLE_SQL);
        db.execSQL(CREATE_POST_TABLE_SQL);
        db.execSQL(CREATE_ADD_FRIEND_TABLE_SQL);
        db.execSQL(CRATE_LOGIN_TABLE_SQL);

        db.execSQL(CREATE_FOLLOWING_TABLE_SQL);
        db.execSQL(CREATE_FOLLOWER_TABLE_SQL);
        db.execSQL(CREATE_FOLLOWER_NOTIFICATION_TABLE_SQL);
        db.execSQL(CREATE_LIKE_COUNT_TABLE_SQL);
        db.execSQL(CREATE_LIKE_COMMENTS_SQL);

        //sqLiteDatabase.execSQL(CREATE_ADD_FRIEND_TABLE_SQL);
        //db.execSQL(CREATE_TABLE_SQL);
        //sqLiteDatabase.execSQL(CREATE_POST_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }



}

