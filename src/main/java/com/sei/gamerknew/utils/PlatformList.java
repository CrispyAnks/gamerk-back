package com.sei.gamerknew.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class PlatformList {
    static private ArrayList<String> platformList = new ArrayList<>();

    static {
        String[] platforms = {"Nintendo Switch", "PS5", "PC"};
        for (String platform : platforms) {
            platformList.add(platform);
        }
    }
    public static String getPlatform(int platform){
        return platformList.get(platform);
    }

    public static int getPlatformCode(String plaform){
        return platformList.indexOf(plaform);
    }
}
