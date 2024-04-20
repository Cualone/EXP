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

            memberService.create("admin", "admin", "123412", false, LocalDate.of(1999,1,27), 178, 87);

            Member admin = memberService.findByMemberName("admin");

            List<Target> exerciseTargets = Arrays.asList(
                    new Target(1L, "가슴"),
                    new Target(2L, "등"),
                    new Target(3L, "어깨"),
                    new Target(4L, "팔"),
                    new Target(5L, "하체")
            );
            targetRepository.saveAll(exerciseTargets);

            exerciseService.create(exerciseTargets.get(0), admin, "벤치프레스");
            exerciseService.create(exerciseTargets.get(1), admin, "데드리프트");
            exerciseService.create(exerciseTargets.get(2), admin, "사이드 레터럴 레이즈");
            exerciseService.create(exerciseTargets.get(3), admin, "바벨 컬");
            exerciseService.create(exerciseTargets.get(4), admin, "스쿼트");
        };
    }
}
