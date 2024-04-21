package com.proj.EXP.record.service;

import com.proj.EXP.base.rq.Rq;
import com.proj.EXP.exercise.entity.Exercise;
import com.proj.EXP.member.entity.Member;
import com.proj.EXP.record.entity.Record;
import com.proj.EXP.record.repository.RecordRepository;
import com.proj.EXP.target.entity.Target;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RecordService {
    private final RecordRepository recordRepository;

    private final Rq rq;

    public Record create(Exercise exercise) {
        Record record = Record
                .builder()
                .member(rq.getMember())
                .exercise(exercise)
                .target(exercise.getTarget())
                .date(LocalDate.now())
                .build();
        return recordRepository.save(record);
    }

    public List<Record> findAll() {
        return recordRepository.findAll();
    }
}
