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


@RequiredArgsConstructor
@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    private final TargetRepository targetRepository;

    public Exercise create(Target target, Member member, String exName) {
        Exercise exercise = Exercise
                .builder()
                .target(target)
                .creator(member)
                .exName(exName)
                .build();
        return exerciseRepository.save(exercise);
    }

    public List<Exercise> findAllExercises(Member member) {
        if ("admin".equals(member.getMemberId())) {
            return exerciseRepository.findByCreator_memberId("admin");
        } else {
            List<Exercise> exercises = exerciseRepository.findByCreator_memberId(member.getMemberId());
            exercises.addAll(exerciseRepository.findByCreator_memberId("admin"));
            return exercises;
        }
    }
    
    public List<Exercise> findExercisesByTarget(Member member, Long targetId) {
        return targetRepository.findById(targetId)
                .map(target -> {
                    if ("admin".equals(member.getMemberId())) {
                        return exerciseRepository.findByCreator_memberIdAndTarget("admin", target);
                    }
                    List<Exercise> exercises = exerciseRepository.findByCreator_memberIdAndTarget(member.getMemberId(), target);
                    exercises.addAll(exerciseRepository.findByCreator_memberIdAndTarget("admin", target));
                    return exercises;
                })
                .orElseGet(ArrayList::new);
    }


}
