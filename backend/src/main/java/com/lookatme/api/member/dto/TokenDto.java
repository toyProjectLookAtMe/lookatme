package com.lookatme.api.member.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDto { // 20230211 hjh 토큰의 값을 헤더에서 뽑거나 헤더에서 삽입할때 쓰는 dto다.
    private String grantType;
    private String accessToken;
    private Long tokenExpiresIn;
}