package com.proj.EXP.base.initData;

import com.proj.EXP.target.entity.Target;
import com.proj.EXP.target.repository.TargetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class Init {
    @Bean
    CommandLineRunner initData(TargetRepository targetRepository) {
        return args -> {
            List<Target> exerciseTargets = Arrays.asList(
                    new Target(1L, "가슴"),
                    new Target(2L, "등"),
                    new Target(3L, "어깨"),
                    new Target(4L, "팔"),
                    new Target(5L, "하체")
            );
            targetRepository.saveAll(exerciseTargets);
        };
    }
}
