package com.proj.EXP.base.initData;

import com.proj.EXP.exercise.service.ExerciseService;
import com.proj.EXP.target.entity.Target;
import com.proj.EXP.target.repository.TargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class Init {

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private TargetRepository targetRepository;

    @Bean
    CommandLineRunner initData() {
        return args -> {
            List<Target> exerciseTargets = Arrays.asList(
                    new Target(1L, "가슴"),
                    new Target(2L, "등"),
                    new Target(3L, "어깨"),
                    new Target(4L, "팔"),
                    new Target(5L, "하체")
            );
            targetRepository.saveAll(exerciseTargets);

            exerciseService.create(null, exerciseTargets.get(0), "벤치프레스");
            exerciseService.create(null, exerciseTargets.get(1), "데드리프트");
            exerciseService.create(null, exerciseTargets.get(2), "사이드 레터럴 레이즈");
            exerciseService.create(null, exerciseTargets.get(3), "바벨 컬");
            exerciseService.create(null, exerciseTargets.get(4), "스쿼트");
        };
    }
}
