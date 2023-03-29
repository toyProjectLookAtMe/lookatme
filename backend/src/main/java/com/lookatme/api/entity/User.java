package com.lookatme.api.entity;


import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.Date;

@Data
@Table
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Comment("회원 PK")
    Integer userIndex;

    @Column(unique = true, length = 100)
    @NotNull
    @Comment("회원 이메일")
    String userEmail;

    @Column(unique = true) // 암호화 예정 default varchar(255)
    @NotNull
    @Comment("회원 비밀번호")
    String userPassword;

    @Column(length = 30)
    @NotNull
    @Comment("회원 닉네임")
    String userNickname;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Comment("회원 회원가입 날짜")
    Date userJoinDate;

    @Column
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Comment("회원 로그인 날짜")
    Date userLoiginDate;

    @Column
    @ColumnDefault("1") // 0 : 탈퇴, 1 : 일반, 2 : 휴면
    @NotNull
    @Comment("회원 상태")
    Integer userState;

    @Column
    @ColumnDefault("0") // 0 : 사진 없음, 1 : 사진 있음
    @Comment("회원 프로필사진 유무")
    Integer userProfileImageState;

    @Column
    @Comment("회원 토큰")
    String userToken;

    @Column
    @Comment("회원 권한")
    @Enumerated(EnumType.STRING)
    Authority authority;
}
