package com.example.wonderfulcc.activity.posts;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.wonderfulcc.activity.observer.Subject;

import java.util.ArrayList;
import java.util.Observer;

/**
 * @author Wangyi Li
 */
@Entity(tableName = "my_posts")
public class MyPosts {

    // create column of the table
    // id column should be primaryKey (increase automatically)
    @PrimaryKey(autoGenerate = true)
    public int post_id;
    public String username;
    public String post_title;
    public String post_description;
    public String post_tag;
    // images are saved in the last column
    public byte[] image;
    //Visible 0: Only visible to yourself 1: Visible to everyone
    //public String postIsVisible ; //Visible 0: Only visible to yourself 1: Visible to everyone

    // constructor
    public MyPosts(String username, String post_title, String post_description,String post_tag, byte[] image) {
        this.username = username;
        this.post_title = post_title;
        this.post_description = post_description;
        this.post_tag = post_tag;
        this.image = image;
    }
    public MyPosts(String userName, String post_title, String post_description, String post_tag, byte[] image, String postIsVisible) {
        this.username = userName;
        this.post_title = post_title;
        this.post_description = post_description;
        this.post_tag = post_tag;
        this.image = image;
        //this.postIsVisible = postIsVisible;
    }

    public int getPost_id() {
        return post_id;
    }

    public String getUsername() {
        return username;
    }

    //public void setUsername(String username) {this.username = username;}

    //public String getPostIsVisible() { return postIsVisible; }

    //public void setPostIsVisible(String postIsVisible) {this.postIsVisible = postIsVisible;}

    public String getPost_title() {
        return post_title;
    }

    public String getPost_description() {
        return post_description;
    }

    public String getPost_tag() {
        return post_tag;
    }

    public byte[] getImage() {
        return image;
    }


    // know the id of the data that im going to update
    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    /*public String getPostIsVisible() {
        return postIsVisible;
    }

    public void setPostIsVisible(String postIsVisible) {
        this.postIsVisible = postIsVisible;
    }*/

}
