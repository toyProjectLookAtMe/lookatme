package com.lookatme.api.jpatest.repository;

import com.lookatme.api.jpatest.entity.JpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTestRepositroy extends JpaRepository<JpaEntity, Object> {

    @Query(value = "SELECT jpa_number FROM jpa_test ORDER BY jpa_number DESC LIMIT 1", nativeQuery = true)
    Integer findByJpaNumber();

}
