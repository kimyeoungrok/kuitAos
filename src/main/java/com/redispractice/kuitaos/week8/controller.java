package com.redispractice.kuitaos.week8;

import com.redispractice.kuitaos.reponse.BaseResponse;
import com.redispractice.kuitaos.week8.Response.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/week")
@RequiredArgsConstructor
@Slf4j
public class controller {

    private final Week8Service week8Service;

    @GetMapping("/test")
    public BaseResponse<String> doTest() {
        return new BaseResponse<>("fail");
    }

    @GetMapping("/post")
    public BaseResponse<PostResponse> getPost(){
        return new BaseResponse<>(week8Service.getPost());
    }

    @PostMapping("/sign")
    public BaseResponse<SignupResponse> signup(@RequestBody SignupRequest signupRequest){
        return new BaseResponse<>(week8Service.signup(signupRequest));
    }

    @PostMapping("/login")
    public BaseResponse<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        return new BaseResponse<>(week8Service.login(loginRequest));
    }

    @PatchMapping("/nick-name")
    public BaseResponse<ModifyNickNameResponse> modifyNickName(HttpServletRequest httpServletRequest,  @RequestBody ModifyNickNameRequest modifyNickNameRequest){
        Long memberId = Long.parseLong(httpServletRequest.getAttribute("memberId").toString());
        return new BaseResponse<>(week8Service.modifyNickName(modifyNickNameRequest, memberId));
    }

    @GetMapping("/nick-name")
    public BaseResponse<GetNickNameResponse> getNickName(HttpServletRequest httpServletRequest){
        Long memberId = Long.parseLong(httpServletRequest.getAttribute("memberId").toString());
        return new BaseResponse<>(week8Service.getNickName(memberId));
    }
}
