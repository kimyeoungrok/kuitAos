package com.redispractice.kuitaos.week8;

import com.redispractice.kuitaos.Entity.Auth;
import com.redispractice.kuitaos.Entity.Member;
import com.redispractice.kuitaos.Entity.Picture;
import com.redispractice.kuitaos.Entity.Post;
import com.redispractice.kuitaos.exception.AuthException;
import com.redispractice.kuitaos.repository.AuthRepository;
import com.redispractice.kuitaos.repository.MemberRepository;
import com.redispractice.kuitaos.repository.PictureRepository;
import com.redispractice.kuitaos.repository.PostRepository;
import com.redispractice.kuitaos.week8.Response.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.redispractice.kuitaos.reponse.status.BaseExceptionStatus.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class Week8Service {
    @Value("${jwt.secret}")
    private String secretKey;
    private final PictureRepository pictureRepository;
    private final PostRepository postRepository;
    private final AuthRepository authRepository;
    private final MemberRepository memberRepository;
    public PostResponse getPost() {
        Post post = postRepository.findById(1L).get();
        Picture picture = pictureRepository.findByPost(post);
        Member member = post.getMember();

        return PostResponse.of(
                member.getProfileUrl(),
                member.getNickName(),
                picture.getPictureUrl(),
                post.getLikeCount(),
                post.getContents()
        );
    }

    public SignupResponse signup(SignupRequest signupRequest) {
        String userId = signupRequest.getUserId();
        String password = signupRequest.getPassword();
        String nickName = signupRequest.getNickName();

        if(userId.isEmpty() || password.isEmpty() || nickName.isEmpty()){
            throw new AuthException(USER_INFO_EMPTY);
        }

        if(authRepository.findByUserId(userId) != null){
            throw new AuthException(ID_DUPLICATE);
        }



        Member member = Member.of(null, nickName);
        memberRepository.save(member);

        Auth auth = Auth.of(userId, password, member);
        authRepository.save(auth);

        return SignupResponse.of("회원가입 성공");
    }

    public LoginResponse login(LoginRequest loginRequest) {
        String userId = loginRequest.getUserId();
        String password = loginRequest.getPassword();

        Auth auth = authRepository.findByUserId(userId);
        if(auth == null){
            throw new AuthException(ID_NOT_EXIST);
        }
        if(!auth.getPassword().equals(password)){
            throw new AuthException(PASSWORD_NOT_MATCH);
        }

        Long memberId = auth.getMember().getId();

        String accessToken = JwtUtils.createJwt(secretKey, memberId);

        return LoginResponse.of(accessToken);

    }


    public ModifyNickNameResponse modifyNickName(ModifyNickNameRequest modifyNickNameRequest,
                                                 Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        member.setNickName(modifyNickNameRequest.getNickName());
        memberRepository.save(member);

        return ModifyNickNameResponse.of("닉네임 변경 성공");
    }

    public GetNickNameResponse getNickName(Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        return GetNickNameResponse.of(member.getNickName());
    }
}
