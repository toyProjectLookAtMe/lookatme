package com.lookatme.api.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Table
@Entity
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Comment("댓글 PK")
    Integer commentsIndex;

    @Column(columnDefinition = "TEXT")
    @NotNull
    @Comment("댓글 내용")
    String commentsContent;

    @Column
    @Comment("댓글 그룹 키")
    Integer commentsGroupIndex;

    @Column
    @ColumnDefault("0") // 0 : 멘션 아님, 1 : 멘션
    @Comment("댓글 멘션 여부")
    Integer commentsMentionState;

    @Column
    @ColumnDefault("0") // 0 : 최상위 댓글(멘션 x)
    @Comment("댓글 멘션 순서")
    Integer commentsMentionNumber;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Comment("댓글 생성(수정) 시간")
    Date commentsDate;

    @Column
    @ColumnDefault("1") // 0 : 비공개, 1 : 공개, 2 : 스포일러
    @NotNull
    @Comment("댓글 상태")
    Integer commentState;

    @ManyToOne
    @JoinColumn(name = "member_index")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "review_index")
    private Review review;
}
