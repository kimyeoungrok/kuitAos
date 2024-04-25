package com.redispractice.kuitaos.week8;

import com.redispractice.kuitaos.exception.JwtUnsupportedTokenTypeException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import static com.redispractice.kuitaos.reponse.status.BaseExceptionStatus.UNSUPPORTED_TOKEN_TYPE;

@Slf4j
public class TokenValidator {
    public static String tokenValidator(ServletRequest servletRequest, ServletResponse servletResponse){
        final String BASIC_TYPE_PREFIX = "Bearer";
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final String authorization = request.getHeader("Authorization");
        log.info("authorization : " + authorization);
        final boolean isBasicAuthentication = authorization != null && authorization.toLowerCase().startsWith(BASIC_TYPE_PREFIX.toLowerCase());

        if (!isBasicAuthentication) {
            throw new JwtUnsupportedTokenTypeException(UNSUPPORTED_TOKEN_TYPE);
        }

        return authorization.substring(BASIC_TYPE_PREFIX.length()).trim();
    }
}
