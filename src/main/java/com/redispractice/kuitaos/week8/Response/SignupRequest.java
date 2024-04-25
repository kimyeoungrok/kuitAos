package com.redispractice.kuitaos.week8.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SignupRequest {
    private String userId;
    private String password;
    private String nickName;


}
