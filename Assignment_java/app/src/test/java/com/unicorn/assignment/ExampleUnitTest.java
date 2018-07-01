package com.unicorn.assignment;

import com.unicorn.assignment.Model.Util;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void SplitText() throws Exception {
        String message = "I can't believe Tweeter now supports chunking my messages, so I don't have to do it myself.";

        ArrayList<String> arr = Util.GetInstance().SplitMessage(message);
        for(String str: arr)
        {
            System.out.println(str);
            assertTrue(str.length()<= 50);
        }
    }

    @Test
    public void SplitText1() throws Exception {
        String message = "I can't believe Tweeter now supports chunking my messages, so I don't have to do it myself. " +
                "I can't believe Tweeter now supports chunking my messages, so I don't have to do it myself.";

        ArrayList<String> arr = Util.GetInstance().SplitMessage(message);
        for(String str: arr)
        {
            System.out.println(str);
            assertTrue(str.length()<= 50);
        }
    }
}