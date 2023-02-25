/*
 * Author : Anisha Palei
 * Date : 11-02-2023
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.bej.security;

import com.niit.bej.domain.Customer;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityGeneratorTokenImpl implements SecurityGeneratorToken{

    @Override
    public Map<String, String> generateToken(Customer customer) {
        Map<String,String> tokenMap=new HashMap<String,String>();
        customer.setPassword("");
        Map<String,Object> userData=new HashMap<>();
        userData.put("emailId",customer.getEmailId());

        String jwtTokenString= Jwts.builder().setClaims(userData).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS512,"mySecretKey").compact();
        tokenMap.put("token",jwtTokenString);
        tokenMap.put("message","Login Successful");
//        tokenMap.put("emailId", customer.getEmailId());

        return tokenMap;
    }
}
