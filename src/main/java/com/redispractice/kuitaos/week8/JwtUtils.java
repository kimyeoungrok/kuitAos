package com.redispractice.kuitaos.week8;

import com.redispractice.kuitaos.exception.JwtExpiredException;
import com.redispractice.kuitaos.exception.JwtInvalidException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;

import java.time.Duration;
import java.util.*;

import static com.redispractice.kuitaos.reponse.status.BaseExceptionStatus.EXPIRED_TOKEN;

@Slf4j
public class JwtUtils {
    public static String createJwt(String secretKey, Long memberId){
        long expiredMs = Duration.ofHours(2).toMillis();
        Claims claims = Jwts.claims();
        claims.put("memberId", memberId);

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiredMs))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        return token;
    }

    public static Map<String, Object> getTokenHeader(String token){
        JsonParser jsonParser = new BasicJsonParser();
        Map<String, String> requestInfo = getTokenInfo(token);
        log.info(requestInfo.toString());

        Base64.Decoder decoder = Base64.getUrlDecoder();

        String decodedHeader = new String(decoder.decode(requestInfo.get("header")));

        Map<String, Object> headerArray = jsonParser.parseMap(decodedHeader);
        log.info(headerArray.toString());
        return headerArray;
    }

    public static Map<String, Object> getTokenPayload(String token){
        JsonParser jsonParser = new BasicJsonParser();
        Map<String, String> requestInfo = getTokenInfo(token);

        Base64.Decoder decoder = Base64.getUrlDecoder();

        String decodedPayload = new String(decoder.decode(requestInfo.get("payload")));

        Map<String, Object> payloadArray = jsonParser.parseMap(decodedPayload);
        return payloadArray;
    }
    public static boolean isExpired(String token, String secretKey){
        try {
            return Jwts.parserBuilder().setSigningKey(secretKey)
                    .build().parseClaimsJws(token).getBody()
                    .getExpiration().before(new Date()); // expired 된게 지금보다 전인가? -> 그러면 만료된거임
        }catch (ExpiredJwtException e){
            throw new JwtExpiredException();
        }catch (SignatureException e){
            throw new JwtInvalidException();
        }
    }

    public static Map<String, String> getTokenInfo(String token){

        StringTokenizer st = new StringTokenizer(token, ".");

        Map<String, String> requestInfo = new HashMap<>();

        requestInfo.put("header",st.nextToken());
        requestInfo.put("payload", st.nextToken());

        return requestInfo;
    }

    public static Long getMemberId(String token, String secretKey){
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().get("memberId", Long.class);
    }



}
