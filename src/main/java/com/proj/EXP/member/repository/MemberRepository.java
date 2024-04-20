package com.proj.EXP.member.repository;

import com.proj.EXP.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMemberId(String memberId);

    Member findByMemberName(String memberName);
}
