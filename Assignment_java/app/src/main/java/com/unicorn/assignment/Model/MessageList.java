package com.unicorn.assignment.Model;

import java.util.ArrayList;

public class MessageList {
    private ArrayList<BaseMessage> mBaseMessageList=new ArrayList<>();
    private static MessageList mInstance = new MessageList();

    public static MessageList GetInstance()
    {
        return mInstance;
    }

    public ArrayList<BaseMessage> getBaseMessageList() {
        return mBaseMessageList;
    }

    public void AddMessage(String userName, String message)
    {
        mBaseMessageList.add(new BaseMessage(userName, message));
    }
}