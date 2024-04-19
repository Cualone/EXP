package com.proj.EXP.exercise.repository;

import com.proj.EXP.exercise.entity.Exercise;
import com.proj.EXP.member.entity.Member;
import com.proj.EXP.target.entity.Target;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    Optional<Exercise> findByExId(Long exId);

    List<Exercise> findByIsCommonTrueOrCreator(Member creator);

    List<Exercise> findByTargetAndIsCommonTrueOrCreator(Target target, Member creator);

}
