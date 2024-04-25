package com.redispractice.kuitaos.exception;


import static com.redispractice.kuitaos.reponse.status.BaseExceptionStatus.EXPIRED_TOKEN;

public class JwtExpiredException extends JwtException{

    public JwtExpiredException() {
        super(EXPIRED_TOKEN);
    }
}
