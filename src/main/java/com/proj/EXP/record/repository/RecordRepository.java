package com.proj.EXP.record.repository;

import com.proj.EXP.member.entity.Member;
import com.proj.EXP.record.entity.Record;
import com.proj.EXP.target.entity.Target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RecordRepository extends JpaRepository<Record, Long> {
    Optional<Record> findByMember(Member member);

    List<Record> findByMemberAndDate(Member member, LocalDate date);


    @Query("SELECT r.target, COUNT(DISTINCT r.date) " +
            "FROM Record r " +
            "WHERE r.member.memberId = :memberId AND r.date BETWEEN :startDate AND :endDate " +
            "GROUP BY r.target")
    List<Object[]> findTargetsInLastWeek(String memberId, LocalDate startDate, LocalDate endDate);
}
