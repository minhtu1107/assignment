package com.unicorn.assignment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.unicorn.assignment.Model.MessageList;
import com.unicorn.assignment.Model.UserProfile;
import com.unicorn.assignment.Model.Util;

import java.util.ArrayList;

public class ChatScreenFragment extends Fragment {

    private RecyclerView mMessageRecycler;
    private MessageListAdapter mMessageAdapter;
    private EditText mInputMessage;
    private Button mSend;

    public ChatScreenFragment() {

    }

    public static ChatScreenFragment newInstance() {
        ChatScreenFragment fragment = new ChatScreenFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_chat_screen, container, false);

        mMessageRecycler = (RecyclerView) v.findViewById(R.id.reyclerview_message_list);
        mMessageAdapter = new MessageListAdapter(getContext(), MessageList.GetInstance().getBaseMessageList());
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mMessageRecycler.setAdapter(mMessageAdapter);

        mInputMessage = (EditText) v.findViewById(R.id.edittext_chatbox);
        mSend = (Button) v.findViewById(R.id.button_chatbox_send);
        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> SplittedMess = Util.GetInstance().SplitMessage(mInputMessage.getText().toString());
                if (SplittedMess==null)
                {
                    Toast.makeText(getContext(),
                            "The message contains a span of non-whitespace characters longer than 50 characters",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                for(int i=0; i<SplittedMess.size(); i++)
                {
                    MessageList.GetInstance().AddMessage(UserProfile.GetInstance().getUserName(), SplittedMess.get(i));
                    //mMessageAdapter.NotifyChanged(MessageList.GetInstance().getBaseMessageList());
                }
                mMessageAdapter.notifyDataSetChanged();
                mMessageRecycler.scrollToPosition(MessageList.GetInstance().getBaseMessageList().size()-1);
            }
        });

        return v;
    }

}
