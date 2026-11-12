package com.imlyb.tlias.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtils {

    private static final String SECRET_KEY = "aXRoZWltYQ==";
    private static final long EXPIRATION_TIME = 12*60*60*1000;

    /*生成令牌
    * @param claims传入自定义信息
    * @return 返回通过算法密钥计算后的token字符串
    * */

    public static String generateToken(Map<String,Object> claims){
        return Jwts.builder().signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact();
    }

    /*
    * 解析token 返回claims对象
    * @throws Exception 如果令牌超时或无效 则抛出异常
    */
    public static Claims parseToken(String token) throws Exception{
        return Jwts.parser().setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
