package com.rnd.java.login;

import java.util.List;

public class User implements LoginContractor.LogiModel {

    private int userId;
    private int fillName;
    private String userName;
    private String userPswd;

    public User() {
    }

    public User(String userName, String userPswd) {
        this.userName = userName;
        this.userPswd = userPswd;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPswd() {
        return userPswd;
    }

    public void setUserPswd(String userPswd) {
        this.userPswd = userPswd;
    }

    public int getFillName() {
        return fillName;
    }

    public void setFillName(int fillName) {
        this.fillName = fillName;
    }


    @Override
    public boolean isValidUser(List<User> users) {
        boolean value = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(userName) && users.get(i).getUserPswd().equals(userPswd)) {
                value = true;
            }
        }
        return value;
    }

}
