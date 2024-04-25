package com.redispractice.kuitaos.exception;


import com.redispractice.kuitaos.reponse.status.ResponseStatus;
import org.springframework.http.HttpStatus;

public class JwtException extends RuntimeException {

    private final ResponseStatus responseStatus;

    public JwtException(ResponseStatus responseStatus) {
        super(responseStatus.getMessage());
        this.responseStatus = responseStatus;
    }}
