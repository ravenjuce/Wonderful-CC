package com.example.wonderfulcc.bean;;

import com.example.wonderfulcc.bean.Chat;
import com.example.wonderfulcc.bean.Post;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Chuming Zhang
 */
public class OrdinaryUser {

        private int uid;
        private String userType;
        private String name;
        private String password;
        private String email;
        private String profile;
        private List<User> follower;
        private List<User> following;
        private List<User> friend;
        private List<User> blacklist;
        private List<Post> post;
        private List<Chat> chart;

        public OrdinaryUser(){};

        public OrdinaryUser(int uid){
                this.uid = uid;
                this.userType = null;
                this.name = null;
                this.password = null;
                this.email = null;
                this.profile = null;
                this.follower = null;
                this.following = null;
                this.friend = null;
                this.blacklist = null;
                this.post = null;
                this.chart= null;
        }
        public OrdinaryUser(int uid,String userType, String name, String password,
                            String email,String profile, List<User> follower, List<User> following,
                            List<User> friend, List<User> blacklist, List<Post> post, List<Chat> chart){
                this.uid = uid;
                this.userType = userType;
                this.name = name;
                this.password = password;
                this.email = email;
                this.profile = profile;
                this.follower = follower;
                this.following = following;
                this.friend = friend;
                this.blacklist = blacklist;
                this.post = post;
                this.chart= chart;
        }

        public int getUid() {
                return uid;
        }

        public void setUid(int uid) {
                this.uid = uid;
        }

        public String getUserType() {
                return userType;
        }

        public void setUserType(String userType) {
                this.userType = userType;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getProfile() {
                return profile;
        }

        public void setProfile(String profile) {
                this.profile = profile;
        }

        public List<User> getFollower() {
                return follower;
        }

        public void setFollower(List<User> follower) {
                this.follower = follower;
        }

        public List<User> getFollowing() {
                return following;
        }

        public void setFollowing(List<User> following) {
                this.following = following;
        }

        public List<User> getFriend() {
                return friend;
        }

        public void setFriend(List<User> friend) {
                this.friend = friend;
        }

        public List<User> getBlacklist() {
                return blacklist;
        }

        public void setBlacklist(List<User> blacklist) {
                this.blacklist = blacklist;
        }

        public List<Post> getPost() {
                return post;
        }

        public void setPost(List<Post> post) {
                this.post = post;
        }

        public List<Chat> getChart() {
                return chart;
        }

        public void setChart(List<Chat> chart) {
                this.chart = chart;
        }

        public void follow(User user){}
        public void unFollow(User user){}
        public void deleteFollower(User user){}
        public void addFriend(User user){}
        public void delFriend(User user){}
        public void blackList(User user){}
        public void createChat(User user){}
        public void like(Post post){}
        public void dislike(Post post){}
        public void comment(Post post, String comment){}
        public void share(Post post, User user){}
        public void createPost(){}
        public void readPost(Post post, User user){}
        public void notifyAllPost(Post post){}
        public void login(){}
        public void signUp(){}

        abstract class User {}

}
