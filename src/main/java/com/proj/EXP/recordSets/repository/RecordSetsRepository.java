package com.proj.EXP.recordSets.repository;

import com.proj.EXP.recordSets.entity.RecordSets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordSetsRepository extends JpaRepository<RecordSets, Long> {
    List<RecordSets> findByRecordRecordId(Long recordId);
}
