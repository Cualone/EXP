package com.proj.EXP.exercise.repository;

import com.proj.EXP.exercise.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    Optional<Exercise> findByExId(Long exId);
}
