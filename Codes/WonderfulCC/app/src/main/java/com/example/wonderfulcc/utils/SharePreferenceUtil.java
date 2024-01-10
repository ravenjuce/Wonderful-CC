package com.example.wonderfulcc.utils;

import android.content.Context;
import android.content.SharedPreferences;
/**
 * @reference https://developer.android.com/reference/android/content/SharedPreferences
 */

public class SharePreferenceUtil {
    private SharedPreferences mSharedPreferences;
    private static SharedPreferences.Editor editor;
    private static SharePreferenceUtil mPreferenceUtils;

    public SharePreferenceUtil(Context context) {
        mSharedPreferences = context.getSharedPreferences("369sp", Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
    }

    public static synchronized SharePreferenceUtil getInstance(Context cxt) {
        if (mPreferenceUtils == null) {
            mPreferenceUtils = new SharePreferenceUtil(cxt);
        }

        return mPreferenceUtils;
    }


    public String getUserName() {
        return mSharedPreferences.getString("username", "");
    }

    public void setUserName(String name) {
        editor.putString("username", name);
        editor.commit();
    }

    public String getUserId() {
        return mSharedPreferences.getString("userId", "");
    }

    public void setUserId(String href) {
        editor.putString("userId", href);
        editor.commit();
    }


    public boolean getIsLogin() {
        return mSharedPreferences.getBoolean("isLogin", false);
    }

    public void setIsLogin(boolean isLogin) {
        editor.putBoolean("isLogin", isLogin);
        editor.commit();
    }


    public boolean getOpenMusic() {
        return mSharedPreferences.getBoolean("openmusic", true);
    }

    public void setOpenMusic(boolean IsFirstOpenApp) {
        editor.putBoolean("openmusic", IsFirstOpenApp);
        editor.commit();
    }


    public String getUserPassword() {
        return mSharedPreferences.getString("password", "");
    }

    public void setUserPassword(String password) {
        editor.putString("password", password);
        editor.commit();
    }


}
