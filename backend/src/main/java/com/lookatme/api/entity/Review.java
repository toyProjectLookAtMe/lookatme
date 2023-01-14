package com.lookatme.api.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Table
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Comment("리뷰 PK")
    Integer reviewIndex;

    @Column(length = 200)
    @NotNull
    @Comment("리뷰 제목")
    String reviewTitle;

    @Column(columnDefinition = "TEXT")
    @NotNull
    @Comment("리뷰 내용")
    String reviewContent;

    @Column
    @ColumnDefault("0")
    @NotNull
    @Comment("리뷰 평점")
    Double reviewGrade;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Comment("리뷰 생성 시간")
    Date reviewCreateDate;

    @Column
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Comment("리뷰 수정 시간")
    Date reviewUpdateDate;

    @Column
    @ColumnDefault("1") // 0 : 비공개, 1 : 공개, 2 : 스포일러
    @NotNull
    @Comment("리뷰 상태")
    Integer reviewState;


    @ManyToOne
    @JoinColumn(name = "user_index")
    private User user;

    @ManyToOne
    @JoinColumn(name = "contents_index")
    private Contents contents;
}
