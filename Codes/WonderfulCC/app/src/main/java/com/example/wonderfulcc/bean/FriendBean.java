package com.example.wonderfulcc.bean;

/**
 * @author Chuming Zhang
 */
public class FriendBean {
    private String id;
    public String name;
    private String blackStatus;//0:not in the blacklist  1：Already in the blacklist

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlackStatus() {
        return blackStatus;
    }

    public void setBlackStatus(String blackStatus) {
        this.blackStatus = blackStatus;
    }

    @Override
    public String toString() {
        return "FriendBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", blackStatus='" + blackStatus + '\'' +
                '}';
    }
}
