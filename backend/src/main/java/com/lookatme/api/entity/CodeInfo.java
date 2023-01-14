package com.lookatme.api.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Data
@Table
@Entity
public class CodeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Comment("코드 정보 PK")
    Integer codeInfoIndex;

    @Column(columnDefinition = "TEXT")
    @NotNull
    @Comment("코드 명")
    String codeInfoName;

    @Column(columnDefinition = "TEXT")
    @NotNull
    @Comment("코드 상세 내용")
    String codeInfoNameDetail;

    @Column
    @NotNull
    @Comment("코드 그룹 번호")
    Integer codeInfoGroupIndex;
}
