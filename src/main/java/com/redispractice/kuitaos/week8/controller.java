package com.redispractice.kuitaos.week8;

import com.redispractice.kuitaos.reponse.BaseResponse;
import com.redispractice.kuitaos.week8.Response.PostResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/week")
@RequiredArgsConstructor
@Slf4j
public class controller {

    private final Week8Service week8Service;

    @GetMapping("/test")
    public BaseResponse<String> doTest() {
        return new BaseResponse<>("success");
    }

    @GetMapping("/post")
    public BaseResponse<PostResponse> getPost(){
        return new BaseResponse<>(week8Service.getPost());
    }
}
