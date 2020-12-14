package com.study.smartlearn.controller;

import com.study.smartlearn.dto.MemberDto;
import com.study.smartlearn.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/register")
    public String register() {
        return "/user/register";
    }

    @PostMapping("/register")
    public String register(MemberDto memberDto) {
        log.info("memberDto: " + memberDto);
        memberService.store(memberDto);

        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "/user/login";
    }

    @PostMapping("/checkNickName")
    public ResponseEntity<Boolean> verifyNickName(String nickName) {
        boolean isNickNameExisted = memberService.nickNameChecker(nickName);
        if (isNickNameExisted) {
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }

}
