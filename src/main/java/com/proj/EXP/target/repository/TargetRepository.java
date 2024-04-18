package com.proj.EXP.target.repository;

import com.proj.EXP.target.entity.Target;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TargetRepository extends JpaRepository<Target, Long> {
    Optional<Target> findByTargetId(Long targetId);
}
