package com.unicorn.assignment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class ChatScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_screen);

        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.chat_screen_fragment);
        if(f==null)
        {
            f = ChatScreenFragment.newInstance();
            fm.beginTransaction()
                    .add(R.id.chat_screen_fragment, f)
                    .commit();
        }
    }
}
