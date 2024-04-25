package com.redispractice.kuitaos.week8.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SignupResponse {
    private String state;

    public static SignupResponse of(
            String state
    ){
        return SignupResponse.builder()
                .state(state)
                .build();
    }
}
