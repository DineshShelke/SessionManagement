package com.example.shree.sharepreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Shree on 2/13/2018.
 */

public class Session {

    private static final String NAME = "name";
    private static final String KEY_LOGIN_STATE = "logedin";
//    private static final String KEY_LOGIN_MODE = "login";

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context;

    public Session(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void setLoggedin(boolean loggedin){
        editor.putBoolean(KEY_LOGIN_STATE, loggedin);
        editor.commit();
    }

    public boolean loggedin(){
        return preferences.getBoolean(KEY_LOGIN_STATE, false);
    }
}
