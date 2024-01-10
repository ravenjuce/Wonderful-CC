package Codes.WonderfulCC.app.src.main.java.com.example.wonderfulcc.bean;

import com.example.wonderfulcc.bean.Post;

/**
 * @author Chuming Zhang
 */
public class Administrator {
    private String userType;
    private String name;
    private String password;
    private String email;
    private int uid;

    public Administrator(int uid, String password){
        this.uid = uid;
        this.userType = null;
        this.name = null;
        this.password = null;
        this.email = null;
    }
    public void signUp(){}

    private void audit(Post post){}

    private void login(){}
}
