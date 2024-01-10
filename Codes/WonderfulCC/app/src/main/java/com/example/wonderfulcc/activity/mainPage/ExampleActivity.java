package com.example.wonderfulcc.activity.mainPage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.wonderfulcc.R;
import com.example.wonderfulcc.dao.impl.UserDaoImpl;
/**
 * @author  Shiyun Zhu
 */

public class ExampleActivity extends AppCompatActivity {

    //在这里定义一个全局的数据操作类的变量
    UserDaoImpl userDao;
    //再定义一个用户名
    String userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        //在这里获得数据操作类的实例
        userDao = new UserDaoImpl(getApplicationContext());

        //用这个方法读取数据库的登陆用户名
        userName = userDao.readLogin();
    }
    /**
     * 当前页面切换走再回来的时候会调用这个方法
     */
    @Override
    protected void onResume() {
        super.onResume();
        //再次用这个方法读取数据库的登陆用户名，这样切换回来的时候就把用户名传给userName了
        //但是要注意！ onCreate里面如果用textView之类的东西显示了什么，这里需要再写一次
        userName = userDao.readLogin();
    }



}

