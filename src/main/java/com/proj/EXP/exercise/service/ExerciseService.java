package com.proj.EXP.exercise.service;

import com.proj.EXP.exercise.entity.Exercise;
import com.proj.EXP.exercise.repository.ExerciseRepository;
import com.proj.EXP.member.entity.Member;
import com.proj.EXP.target.entity.Target;
import com.proj.EXP.target.repository.TargetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    private final TargetRepository targetRepository;

    public Exercise create (Target target, boolean isCommon, Member member, String exName) {
        Exercise exercise = Exercise
                .builder()
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

    public List<Exercise> findExercisesByTarget(Member member, Long targetId) {

        Optional<Target> target = targetRepository.findById(targetId);
        if (target.isPresent()) {
            List<Exercise> arr = exerciseRepository.findByTargetAndIsCommonTrue(target.get());
            arr.addAll(exerciseRepository.findByTargetAndIsCommonFalseAndCreator(target.get(), member));
            return arr;
        } else {
            return new ArrayList<>();
        }
    }

}
