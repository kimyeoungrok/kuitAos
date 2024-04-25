package com.redispractice.kuitaos.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String profileUrl;
    private String nickName;



    public static Member of(
            String profileUrl,
            String nickName
    ){
        return Member.builder()
                .profileUrl(profileUrl)
                .nickName(nickName)
                .build();
    }
}
