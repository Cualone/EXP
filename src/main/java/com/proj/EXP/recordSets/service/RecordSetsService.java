package com.proj.EXP.recordSets.service;

import com.proj.EXP.base.rq.Rq;
import com.proj.EXP.exercise.service.ExerciseService;
import com.proj.EXP.record.entity.Record;
import com.proj.EXP.record.service.RecordService;
import com.proj.EXP.recordSets.entity.RecordSets;
import com.proj.EXP.recordSets.repository.RecordSetsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RecordSetsService {
    private final RecordSetsRepository recordSetsRepository;
    private final ExerciseService exerciseService;
    private final RecordService recordService;
    private final Rq rq;

    public void addSet(Long recordId, double weight, int count, int sets) {
        Record record = recordService.findById(recordId);

        RecordSets set = RecordSets.builder()
                .record(record)
                .exercise(record.getExercise())
                .member(rq.getMember())
                .weight(weight)
                .count(count)
                .sets(sets)
                .build();

        recordSetsRepository.save(set);
    }

    public List<RecordSets> findSetsByRecordId(Long recordId) {
        return recordSetsRepository.findByRecordRecordId(recordId);
    }

    public void deleteSetById(Long setId) {
        recordSetsRepository.deleteById(setId);
    }
}
