package com.lookatme.api.entity;


import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Table
@Entity
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Comment("회원 PK")
    private Long memberIndex;

    @Column(length = 100)
    @NotNull
    @Comment("회원 이메일")
    private String memberEmail;

    @Column // 암호화 예정 default varchar(255)
    @NotNull
    @Comment("회원 비밀번호")
    private String memberPassword;

    @Column(length = 30)
    @NotNull
    @Comment("회원 닉네임")
    private String memberNickname;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Comment("회원 회원가입 날짜")
    private Date memberJoinDate;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Comment("회원 로그인 날짜")
    private Date memberLoiginDate;

    @Column
    @ColumnDefault("1") // 0 : 탈퇴, 1 : 일반, 2 : 휴면
    @NotNull
    @Comment("회원 상태")
    private Integer memberState;

    @Column
    @ColumnDefault("0") // 0 : 사진 없음, 1 : 사진 있음
    @Comment("회원 프로필사진 유무")
    private Integer memberProfileImageState;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Member(Long memberIndex, String memberEmail, String memberPassword, String memberNickname, Authority authority) {
        this.memberIndex = memberIndex;
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberNickname = memberNickname;
        this.authority = authority;
    }

}
