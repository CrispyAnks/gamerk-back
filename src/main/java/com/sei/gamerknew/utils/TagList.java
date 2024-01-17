package com.sei.gamerknew.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class TagList {
    static private ArrayList<String> tag01List = new ArrayList<>();
    static private ArrayList<String> tag02List = new ArrayList<>();
    static private ArrayList<String> tag03List = new ArrayList<>();

    static {
        String[] tag01 = {" ", "ARPG", "JRPG", "CRPG"};
        String[] tag02 = {" ", "Adventure", "Rouge-like", "Racing"};
        String[] tag03 = {" ", "Funny", "Classic", "Touching"};
        for (String tag : tag01) {
            tag01List.add(tag);
        }
        for (String tag : tag02) {
            tag02List.add(tag);
        }
        for (String tag : tag03) {
            tag03List.add(tag);
        }
    }

    public static ArrayList<String> getTag01List() {
        return tag01List;
    }

    public static ArrayList<String> getTag02List() {
        return tag02List;
    }

    public static ArrayList<String> getTag03List() {
        return tag03List;
    }

    public static HashMap<Integer, String> getTagList(int tag01, int tag02, int tag03){
        HashMap<Integer, String> tagList = new HashMap<>();
        tagList.put(tag01, tag01List.get(tag01));
        tagList.put(tag02, tag02List.get(tag02));
        tagList.put(tag03, tag03List.get(tag03));
        return tagList;
    }

    public static HashMap<String ,Integer> getTagCode(String tag01, String tag02, String tag03){
        HashMap<String, Integer> tagList = new HashMap<>();
        tagList.put(tag01, tag01List.indexOf(tag01));
        tagList.put(tag02, tag03List.indexOf(tag02));
        tagList.put(tag03, tag03List.indexOf(tag03));
        return tagList;
    }
}
