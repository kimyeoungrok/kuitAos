package com.redispractice.kuitaos.week8.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ModifyNickNameResponse {
    private String state;

    public static ModifyNickNameResponse of(
            String state
    ){
        return ModifyNickNameResponse.builder()
                .state(state)
                .build();
    }
}
