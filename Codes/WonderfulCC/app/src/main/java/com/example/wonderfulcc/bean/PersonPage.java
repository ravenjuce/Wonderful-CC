package com.example.wonderfulcc.bean;

import java.util.List;

/**
 * @author Shiyun Zhu
 */
public class PersonPage {
    int uid;
    List<User> follower;
    List<User> following;
    List<User> userApply;

    public PersonPage(int uid) {
        this.uid = uid;
        this.follower=null;
        this.following=null;
        this.userApply=null;
    }

    public PersonPage(int uid, List<User> follower, List<User> following, List<User> userApply) {
        this.uid = uid;
        this.follower = follower;
        this.following = following;
        this.userApply = userApply;
    }

    public void accept(User user){}
    public void changeInfo(User user){}
}
