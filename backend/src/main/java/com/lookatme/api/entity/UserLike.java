package com.lookatme.api.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Data
@Table
@Entity
public class UserLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Comment("좋아요 PK")
    Integer userLikeIndex;

    @Column
    @NotNull
    @Comment("좋아요 상태인 인덱스(컨텐츠, 리뷰, 댓글)")
    Integer userLikeStateIndex;

    @ManyToOne
    @JoinColumn(name = "code_info_index")
    private CodeInfo codeInfo;

    @ManyToOne
    @JoinColumn(name = "user_index")
    private User user;
}

