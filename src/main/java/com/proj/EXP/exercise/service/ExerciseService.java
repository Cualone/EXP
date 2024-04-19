package com.proj.EXP.exercise.service;

import com.proj.EXP.exercise.entity.Exercise;
import com.proj.EXP.exercise.repository.ExerciseRepository;
import com.proj.EXP.target.entity.Target;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public Exercise create (Long exId, Target target, String exName) {
        Exercise exercise = Exercise
                .builder()
                .exId(exId)
                .target(target)
                .exName(exName)
                .build();
        return exerciseRepository.save(exercise);
    }
}
