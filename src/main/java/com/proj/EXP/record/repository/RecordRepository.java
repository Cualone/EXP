package com.proj.EXP.record.repository;

import com.proj.EXP.member.entity.Member;
import com.proj.EXP.record.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecordRepository extends JpaRepository<Record, Long> {
    Optional<Record> findByMember(Member member);
}
