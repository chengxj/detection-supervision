package com.ultrapower.detection.supervision.service.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTService {
	
	private final static Logger LOG = LoggerFactory.getLogger(JWTService.class);
	
	// 过期时间30分钟
    private static final long EXPIRE_TIME = 30*60*1000;
    private static final String ISSUSER = "ultrapower";
    private static final String USER_NAME = "name";
    
    /**
     * 获取令牌
     * @param name 用户名
     * @param pwd 密码
     * @return String 令牌
     */
    public static String getToken(String name, String pwd) {
    	String token = null;
    	try {
    		Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
    	    Algorithm algorithm = Algorithm.HMAC256(pwd);
    	    token = JWT.create().withIssuer(ISSUSER).withClaim(USER_NAME, name).withExpiresAt(date).sign(algorithm);
    	} catch (JWTCreationException e) {
    		LOG.error("创建令牌出错");
    	}
    	return token;
    }

   /**
     * 验证token
     * @param token 令牌
     * @param name 用户名
     * @param pwd 密码
     * @return boolean true令牌有效/flase令牌无效
     */
    public static boolean verifyToken(String token, String name, String pwd) {
    	boolean flag = false;
    	try {
    	    Algorithm algorithm = Algorithm.HMAC256(pwd);
    	    JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUSER).withClaim(USER_NAME, name).build();
    	    verifier.verify(token);
    	    flag = true;
    	} catch (JWTVerificationException exception){
    	    LOG.error("验证令牌出错");
    	}
    	return flag;
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
    	String name = null;
        try {
            DecodedJWT jwt = JWT.decode(token);
            name = jwt.getClaim(USER_NAME).asString();
        } catch (JWTDecodeException e) {
            LOG.error("获取用户失败");
        }
        return name;
    }

}
