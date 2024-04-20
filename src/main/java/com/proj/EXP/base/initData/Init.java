package com.proj.EXP.base.initData;

import com.proj.EXP.exercise.service.ExerciseService;
import com.proj.EXP.member.entity.Member;
import com.proj.EXP.member.service.MemberService;
import com.proj.EXP.target.entity.Target;
import com.proj.EXP.target.repository.TargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Init {

    @Bean
    CommandLineRunner initData(
            ExerciseService exerciseService,
            TargetRepository targetRepository,
            MemberService memberService
    ) {
        return args -> {

            memberService.create("1234", "1234", "123412", false, LocalDate.of(1999,1,27), 123, 123);


            List<Target> exerciseTargets = Arrays.asList(
                    new Target(1L, "가슴"),
                    new Target(2L, "등"),
                    new Target(3L, "어깨"),
                    new Target(4L, "팔"),
                    new Target(5L, "하체")
            );
            targetRepository.saveAll(exerciseTargets);

            exerciseService.create(exerciseTargets.get(0),true, null, "벤치프레스");
            exerciseService.create(exerciseTargets.get(1),true, null, "데드리프트");
            exerciseService.create(exerciseTargets.get(2),true, null, "사이드 레터럴 레이즈");
            exerciseService.create(exerciseTargets.get(3),true, null, "바벨 컬");
            exerciseService.create(exerciseTargets.get(4),true, null, "스쿼트");
        };
    }
}
