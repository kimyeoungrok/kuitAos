package com.redispractice.kuitaos.week8;

import com.redispractice.kuitaos.reponse.BaseResponse;
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
    @GetMapping("/test")
    public BaseResponse<String> doTest(){
        return new BaseResponse<>("success");
    }
}
