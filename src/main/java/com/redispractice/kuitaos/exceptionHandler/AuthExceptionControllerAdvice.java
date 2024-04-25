package com.redispractice.kuitaos.exceptionHandler;

import com.redispractice.kuitaos.exception.AuthException;
import com.redispractice.kuitaos.exception.JwtUnsupportedTokenTypeException;
import com.redispractice.kuitaos.reponse.BaseErrorResponse;
import jakarta.annotation.Priority;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@Priority(0)
@RestControllerAdvice
public class AuthExceptionControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AuthException.class)
    public BaseErrorResponse handle_authException(AuthException e){
        return new BaseErrorResponse(e.getResponseStatus());
    }
}
