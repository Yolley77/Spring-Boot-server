package com.lab3spring.Action;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Action implements Result {

    private String[] parsedText;
    private Map<String, Integer> repeats = new HashMap<>();
    private String TAG = "ACTION_MESSAGE: ";

    public Action() {

    }

    public Action(String s) {
        if (s != null) {
            System.out.println(TAG + "String in constructor");
            convert(s);
            compute();
        }
    }

    Action(List<String> s) {
        if(s != null) {
            System.out.println(TAG + "List<String> in constructor");
            convert(s);
            compute();
        }
    }

    Action(char[] s) {
        if (s != null) {
            System.out.println(TAG + "char[] in constructor");
            convert(s);
            compute();
        }
    }

    private void convert(String s) {
        parsedText = s.split(",");
    }

    private void convert(List<String> s) {
        parsedText = s.toArray(String[]::new);
    }

    private void convert(char[] s) {
        parsedText = Arrays.toString(s).split("[\\[,\\]]");
        for (int i = 0; i < parsedText.length; i++) {
            parsedText[i] = parsedText[i].trim();
        }
        //parsed_text = String.valueOf(s).chars().distinct().count();
    }

    private void compute() {
        for (int i = 0; i < parsedText.length; i++) {
            parsedText[i] = parsedText[i].trim();
        }
        for (String c : parsedText) {
            if (repeats.containsKey(c)) {
                int cnt = repeats.get(c);
                repeats.put(c, ++cnt);
            } else {
                repeats.put(c, 1);
            }
        }
    }

    @Override
    public void calculate(String s) {
        {
            if (s != null) {
                System.out.println(TAG + "String in constructor");
                convert(s);
                compute();
            }
        }
    }

    @Override
    public String getResult() {
        String mText = Arrays.toString(parsedText) + '\t';
        StringBuilder mRepeats = new StringBuilder();
        for (String s: repeats.keySet()) {
            if (repeats.get(s) > 1) {
                mRepeats.append(s).append(" - ").append(repeats.get(s)).append(" times,").append('\t');
            }
        }
        mText += mRepeats;
        System.out.println(TAG + mText);
        return mText;
    }
}
