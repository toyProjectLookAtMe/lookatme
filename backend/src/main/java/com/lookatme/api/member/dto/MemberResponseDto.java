package com.lookatme.api.member.dto;

import com.lookatme.api.entity.Member;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResponseDto {
    private String email;
    private String nickname;

    public static MemberResponseDto of(Member member) {
        return MemberResponseDto.builder()
                .email(member.getMemberEmail())
                .nickname(member.getMemberNickname())
                .build();
    }
}