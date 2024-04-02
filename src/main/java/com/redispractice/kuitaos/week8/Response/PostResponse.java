package com.redispractice.kuitaos.week8.Response;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostResponse {
    private String userProfileImage;
    private String nickName;
    private String postImage;
    private Integer like;
    private String contents;

    public static PostResponse of(
            String userProfileImage,
            String nickName,
            String postImage,
            Integer like,
            String contents
    ){
        return PostResponse.builder()
                .userProfileImage(userProfileImage)
                .nickName(nickName)
                .postImage(postImage)
                .like(like)
                .contents(contents)
                .build();
    }
}
