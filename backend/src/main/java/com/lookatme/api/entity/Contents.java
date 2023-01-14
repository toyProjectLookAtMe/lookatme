package com.lookatme.api.entity;

import com.sun.istack.NotNull;
import lombok.Data;
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
public class Contents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Comment("컨텐츠 PK")
    Integer contentsIndex;

    @Column(length = 200)
    @NotNull
    @Comment("컨텐츠 제목")
    String contentsTitle;

    @Column(columnDefinition = "TEXT")
    @NotNull
    @Comment("컨텐츠 상세 내용")
    String contentsDetail;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Comment("컨텐츠 업로드 날짜")
    Date contentsUploadDate;

    @Column
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Comment("컨텐츠 수정 날짜")
    Date contentsUpdateDate;

    @Column
    @ColumnDefault("0")
    @NotNull
    @Comment("컨텐츠 조회수")
    Integer contentsViewCount;

    @Column
    @ColumnDefault("1") // 1 : 공개 , 0 : 비공개
    @NotNull
    @Comment("컨텐츠 상태")
    Integer ContentsState;
}
