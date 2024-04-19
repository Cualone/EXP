package com.proj.EXP.exercise.service;

import com.proj.EXP.exercise.entity.Exercise;
import com.proj.EXP.exercise.repository.ExerciseRepository;
import com.proj.EXP.member.entity.Member;
import com.proj.EXP.target.entity.Target;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public Exercise create (Long exId, Target target, boolean isCommon, Member member, String exName) {
        Exercise exercise = Exercise
                .builder()
                .exId(exId)
                .target(target)
                .isCommon(isCommon)
                .creator(member)
                .exName(exName)
                .build();
        return exerciseRepository.save(exercise);
    }

    public List<Exercise> findAllExercises(Member member) {
        return exerciseRepository.findByIsCommonTrueOrCreator(member);
    }

    public List<Exercise> findExercisesByTarget(Target target, Member member) {
        return exerciseRepository.findByTargetAndIsCommonTrueOrCreator(target, member);
    }

}
