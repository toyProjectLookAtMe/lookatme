package com.lookatme.api.member.repository;

import com.lookatme.api.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    // 20230211 hjh 이메일 찾기
    Optional<Member> findByMemberEmail(String memberEmail);

    // 20230211 hjh 이메일 존재 여부(중복검사)
    boolean existsByMemberEmail(String memberEmail);

}
