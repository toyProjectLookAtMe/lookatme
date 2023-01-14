package com.lookatme.api.entity;

import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Data
@Table
@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Comment("플랫폼 PK")
    Integer staffIndex;
    @ManyToOne
    @JoinColumn(name = "code_info_index")
    private CodeInfo codeInfo;

    @ManyToOne
    @JoinColumn(name = "contents_index")
    private Contents contents;
}
