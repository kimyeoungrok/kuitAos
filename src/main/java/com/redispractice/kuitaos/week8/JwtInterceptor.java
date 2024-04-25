package com.redispractice.kuitaos.week8;

import com.redispractice.kuitaos.exception.JwtExpiredException;
import com.redispractice.kuitaos.exception.JwtInvalidException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {
    @Value("${jwt.secret}")
    private String secretKey;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userToken = TokenValidator.tokenValidator(request, response);


        if(JwtUtils.isExpired(userToken, secretKey)){
            // 토큰이 만료되었다면 예외 던지기
            throw new JwtExpiredException();
        }


        Long memberId = JwtUtils.getMemberId(userToken, secretKey);
        request.setAttribute("memberId", memberId);

        return true;
    }
}
