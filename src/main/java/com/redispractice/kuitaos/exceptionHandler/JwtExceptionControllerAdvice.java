/**
 * JwtExceptionControllerAdvice
 *
 * 0.0.1
 *
 * 2024.01.23
 *
 * Majorfolio
 */
package com.redispractice.kuitaos.exceptionHandler;

import com.redispractice.kuitaos.exception.JwtException;
import com.redispractice.kuitaos.exception.JwtUnsupportedTokenTypeException;
import jakarta.annotation.Priority;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.redispractice.kuitaos.reponse.BaseErrorResponse;

/**
 * Jwt관련 예외처리하는 ControllerAdvice임
 * @author 김영록
 * @version 0.0.1
 */
@Slf4j
@Priority(0)
@RestControllerAdvice
public class JwtExceptionControllerAdvice {

    /**
     * 지원하지 않는 토큰 타입일때의 예외처리
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(JwtUnsupportedTokenTypeException.class)
    public BaseErrorResponse handle_jwtUnauthorizedException(JwtUnsupportedTokenTypeException e){
        return new BaseErrorResponse(e.getResponseStatus());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(JwtException.class)
    public BaseErrorResponse handle_jwtException(JwtUnsupportedTokenTypeException e){
        return new BaseErrorResponse(e.getResponseStatus());
    }




}
