package com.redispractice.kuitaos.exception;

import com.redispractice.kuitaos.reponse.status.ResponseStatus;
import lombok.Getter;

@Getter
public class AuthException extends RuntimeException{

    private final ResponseStatus responseStatus;

    public AuthException(ResponseStatus responseStatus) {
        super(responseStatus.getMessage());
        this.responseStatus = responseStatus;
    }

}
