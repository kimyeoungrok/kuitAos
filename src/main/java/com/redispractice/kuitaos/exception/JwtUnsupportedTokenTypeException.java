/**
 * JwtUnsupportedTokenTypeException
 *
 * 0.0.1
 *
 * 2024.01.28
 *
 * Majorfolio
 */
package com.redispractice.kuitaos.exception;

import lombok.Getter;
import com.redispractice.kuitaos.reponse.status.ResponseStatus;

/**
 * 지원하지 않는 토큰일때의 예외클래스 정의
 *
 * @author 김영록
 * @version 0.0.1
 */
@Getter
public class JwtUnsupportedTokenTypeException extends JwtUnauthorizedException{
    private final ResponseStatus responseStatus;

    public JwtUnsupportedTokenTypeException(ResponseStatus responseStatus) {
        super(responseStatus);
        this.responseStatus = responseStatus;
    }
}
