package com.lookatme.api.jpatest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "jpa_test")
public class JpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="jpa_number")
    Integer jpaNumber;

    @Column(name="jpa_text")
    String jpaText;

    @Column(name="jpa_age")
    int jpaAge;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="jpa_date")
    Date jpaDate;

}
