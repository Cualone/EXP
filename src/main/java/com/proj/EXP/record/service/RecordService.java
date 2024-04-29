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

    public Record create(Exercise exercise, LocalDate date) {
        Record record = Record
                .builder()
                .member(rq.getMember())
                .exercise(exercise)
                .target(exercise.getTarget())
                .date(date)
                .build();
        return recordRepository.save(record);
    }


    public List<Record> findByMemberAndDate(Member member, LocalDate date) {
        return recordRepository.findByMemberAndDate(member, date);
    }

    public void delete(Long recordId) {
        this.recordRepository.deleteById(recordId);
    }

    public List<Target> getTargetsInLastWeek() {
        LocalDate endDate = LocalDate.now(); // 현재 날짜
        LocalDate startDate = endDate.minusWeeks(1); // 일주일 전

        return recordRepository.findTargetsInLastWeek(rq.getMember().getMemberId(), startDate, endDate);
    }
}
