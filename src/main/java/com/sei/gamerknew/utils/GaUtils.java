package com.sei.gamerknew.utils;

import com.sei.gamerknew.services.UserService;
import com.sei.gamerknew.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class GaUtils {

    public static String geneId(){
        return String.valueOf(new Random().nextInt(100000));
    }
}
