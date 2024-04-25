package com.redispractice.kuitaos.exception;


import static com.redispractice.kuitaos.reponse.status.BaseExceptionStatus.INVALID_TOKEN;

public class JwtInvalidException extends JwtException{

    public JwtInvalidException() {
        super(INVALID_TOKEN);
    }
}
