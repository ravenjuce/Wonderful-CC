package com.example.wonderfulcc.dao;

import com.example.wonderfulcc.bean.Post;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Shiyun Zhu
 */
public interface PostDao {

    public void addPost(Post post) throws SQLException;;

    public void deletePost(int id) throws SQLException;;

    public void updatePost(Post post) throws SQLException;;

    public List<Post> searchPost(int id) throws SQLException;;

}
