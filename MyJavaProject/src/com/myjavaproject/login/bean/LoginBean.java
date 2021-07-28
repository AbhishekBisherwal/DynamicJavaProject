package com.myjavaproject.login.bean;

import java.io.Serializable;

public class LoginBean implements Serializable {
   
    private static final long serialVersionUID = 1L;
    private int userID;
    private String password;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID2) {
        this.userID = userID2;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}