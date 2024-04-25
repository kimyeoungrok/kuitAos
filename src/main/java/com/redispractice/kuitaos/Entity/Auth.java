package com.redispractice.kuitaos.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auth_id")
    private Long id;

    private String userId;
    private String password;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;


    public static Auth of(
            String userId,
            String password,
            Member member

    ){
        return Auth.builder()
                .userId(userId)
                .password(password)
                .member(member)
                .build();
    }
}
