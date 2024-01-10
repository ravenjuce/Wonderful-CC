package com.example.wonderfulcc.bean;

import java.util.List;

/**
 * @author Shiyun Zhu
 */
public class Chat {
    private int uid;
    private User users;
    private List<String> content;

    public Chat(int uid, User users) {
        this.uid = uid;
        this.users = users;
        this.content = null;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public void send(){}

    public void delet(){}

}
