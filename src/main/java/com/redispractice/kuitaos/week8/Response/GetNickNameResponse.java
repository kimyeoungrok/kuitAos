package com.redispractice.kuitaos.week8.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GetNickNameResponse {
    private String nickName;

    public static GetNickNameResponse of(
            String nickName
    ){
        return GetNickNameResponse.builder()
                .nickName(nickName)
                .build();
    }
}
