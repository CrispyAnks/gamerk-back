package com.sei.gamerknew.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;


import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GetToken {
    private static final String KEY = "ilovemia";

    public static String genToken(Map<String, Object> claims){
        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000*60*60*12))
                .sign(Algorithm.HMAC256(KEY));
    }

    public static Map<String, Object> verifyToken(String token){
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
}
