package com.redispractice.kuitaos.week8.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginResponse {
    private String accessToken;

    public static LoginResponse of(
            String accessToken
    ){
        return LoginResponse.builder()
                .accessToken(accessToken)
                .build();
    }
}
