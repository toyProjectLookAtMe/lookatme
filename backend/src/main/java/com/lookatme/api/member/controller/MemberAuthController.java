package com.lookatme.api.member.controller;

import com.lookatme.api.member.dto.MemberRequestDto;
import com.lookatme.api.member.dto.MemberResponseDto;
import com.lookatme.api.member.dto.TokenDto;
import com.lookatme.api.member.service.MemberAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class MemberAuthController {

    private final MemberAuthService memberAuthService;

    @PostMapping("/signup") // 회원가입
    public ResponseEntity<MemberResponseDto> memberSignup(@RequestBody MemberRequestDto requestDto) {
        return ResponseEntity.ok(memberAuthService.memberSignup(requestDto));
    }

    @PostMapping("/login") // 로그인시 토큰생성
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto requestDto) {
        return ResponseEntity.ok(memberAuthService.login(requestDto));
    }
}
