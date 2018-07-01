package com.unicorn.assignment.Model;

import android.util.Log;

import java.util.ArrayList;

public class Util {
    private final int MAX_CHAR_PER_MESSAGE = 50;
    private static Util mInstance = new Util();

    public static Util GetInstance()
    {
        return mInstance;
    }

    public ArrayList<String> SplitMessage(String message)
    {
        ArrayList<String> SplittedMessageArr = new ArrayList<>();

        if(message.length()<=MAX_CHAR_PER_MESSAGE)
        {
            SplittedMessageArr.add(message);
        }
        else {
            int total = message.length() / MAX_CHAR_PER_MESSAGE + 1;
            int part = 1;
            String indicator = part + "/" + total + " ";
            String firstpart, lastpart = message;
            do
            {
                firstpart = lastpart.substring(0, MAX_CHAR_PER_MESSAGE - 1);
                //firstpart = lastpart.substring(0, MAX_CHAR_PER_MESSAGE - 1 - indicator.length());
                int lastspaceIdx;   // = firstpart.lastIndexOf(" ");
                //lastspaceIdx = FindLastIndex(firstpart, ' ', MAX_CHAR_PER_MESSAGE);
                lastspaceIdx = FindLastIndex(firstpart, ' ', MAX_CHAR_PER_MESSAGE - indicator.length()-1);
                if(lastspaceIdx == -1) {
                    return null;
                }

                /*if(lastspaceIdx==-1)
                {
                    lastpart = lastpart.substring(MAX_CHAR_PER_MESSAGE - indicator.length());
                }
                else*/
                {
                    firstpart = lastpart.substring(0, lastspaceIdx);
                    lastpart = lastpart.substring(lastspaceIdx+1);
                }
                SplittedMessageArr.add(indicator + firstpart);
                part++;
                indicator = part + "/" + total + " ";
            }
            while (lastpart.length()>MAX_CHAR_PER_MESSAGE - indicator.length());
            SplittedMessageArr.add(indicator + lastpart);

            while(part != total)
            {
                String AddToNext = "";
                String temp;
                for(int i=0; i<SplittedMessageArr.size(); i++)
                {
                    temp = SplittedMessageArr.get(i);
                    temp = temp.replaceFirst("/" + total, "/" + part + AddToNext);

                    if(temp.length()>MAX_CHAR_PER_MESSAGE)
                    {
                        int idx = FindLastIndex(temp, ' ', MAX_CHAR_PER_MESSAGE-1);
                        AddToNext = " " + temp.substring(idx);
                        temp = temp.substring(0, idx+1);
                        SplittedMessageArr.set(i, temp);
                    }
                    else
                    {
                        AddToNext="";
                    }
                }
                total=part;
                if(AddToNext != "")
                {
                    part++;
                    SplittedMessageArr.add(part + "/" + part + AddToNext);
                }
            }
        }

        return SplittedMessageArr;
    }
    public int FindLastIndex(String text, char c, int fromlastindex)
    {
        if(fromlastindex>text.length()-1 || fromlastindex<0)
        {
            return -1;
        }
        else
        {
            int idx=fromlastindex;
            while(idx>=0 && text.charAt(idx) != c)
            {
                //Log.d("FindLastIndex", "index " + idx + " string:" + text.charAt(idx-1));
                idx--;
            }
            return idx;
        }
    }
}