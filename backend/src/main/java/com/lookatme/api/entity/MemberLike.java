package com.lookatme.api.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Data
@Table
@Entity
public class MemberLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Comment("좋아요 PK")
    Integer memberLikeIndex;

    @Column
    @NotNull
    @Comment("좋아요 상태인 인덱스(컨텐츠, 리뷰, 댓글)")
    Integer memberLikeStateIndex;

    @ManyToOne
    @JoinColumn(name = "code_info_index")
    private CodeInfo codeInfo;

    @ManyToOne
    @JoinColumn(name = "member_index")
    private Member member;
}

