package com.lookatme.api.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Data
@Table
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Comment("이미지 PK")
    Integer imageIndex;

    @Column(columnDefinition = "TEXT")
    @NotNull
    @Comment("이미지 원본명")
    String imageOriginName;

    @Column(columnDefinition = "TEXT")
    @NotNull
    @Comment("이미지명 UUID")
    String imageUuidName;

    @Column(columnDefinition = "TEXT")
    @NotNull
    @Comment("이미지 저장 경로")
    String imagePath;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Comment("이미지 업로드 날짜")
    Date imageUploadDate;

    @Column
    @NotNull
    @Comment("이미지 업로드한 상태인 인덱스(컨텐츠, 리뷰, 댓글)")
    Integer imageStateIndex;

    @Column
    @ColumnDefault("1") // 0 : 비공개, 1 : 공개, 2 : 스포일러
    @NotNull
    @Comment("이미지 상태")
    Integer imageState;

    @ManyToOne
    @JoinColumn(name = "code_info_index")
    private CodeInfo codeInfo;

    @ManyToOne
    @JoinColumn(name = "user_index")
    private User user;
}
