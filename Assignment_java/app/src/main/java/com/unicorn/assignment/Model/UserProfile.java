package com.unicorn.assignment.Model;

public class UserProfile {

    private static UserProfile mUserProfile = new UserProfile("Test");
    private String mUserName;

    public UserProfile(String UserName)
    {
        mUserName = UserName;
    }

    public String getUserName() {
        return mUserName;
    }

    public static UserProfile GetInstance()
    {
        return mUserProfile;
    }
}