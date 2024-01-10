package com.example.wonderfulcc.bean;

import java.util.List;

/**
 * @author Shiyun Zhu
 */
public class DisplayBoard {
    private int uid;
    private List<String> tagList;
    private List<Post> postList;

    public DisplayBoard(int uid, List<String> tagList, List<Post> postList) {
        this.uid = uid;
        this.tagList = tagList;
        this.postList = postList;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public void removeBlack(User user){}

    public void arrange(){}


}
