package com.example.wonderfulcc.dao;

import com.example.wonderfulcc.bean.OrdinaryUser;
import com.example.wonderfulcc.bean.Post;
import com.example.wonderfulcc.bean.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Shiyun Zhu
 */
public interface UserDao {

    public long addFriend(String user, String name) ;

    public void addUser(OrdinaryUser user) ;

    public void deleteUser(OrdinaryUser user) ;

    public void updateUser(OrdinaryUser user) ;

    public List<Post> searchUserByPost(int id) ;

    public OrdinaryUser searchUserByName(String name) ;

    public long addFollowing(String user, String name) ;
    public long addFollower(String user, String name) ;
    public long addFollowerNotification(String user, String name) ;
    public long addLikeCount(String postId, String name) ;
    public long addComment(String postId, String name, String content) ;
}
