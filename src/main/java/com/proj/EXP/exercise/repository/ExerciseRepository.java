package com.proj.EXP.exercise.repository;

import com.proj.EXP.exercise.entity.Exercise;
import com.proj.EXP.member.entity.Member;
import com.proj.EXP.target.entity.Target;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    List<Exercise> findByCreator_memberId(String memberId);

    List<Exercise> findByCreator_memberIdAndTarget(String memberId, Target target);

}
