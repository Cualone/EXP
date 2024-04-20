package com.proj.EXP.target.repository;

import com.proj.EXP.target.entity.Target;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TargetRepository extends JpaRepository<Target, Long> {
    Target findByTargetId(Long targetId);
}
