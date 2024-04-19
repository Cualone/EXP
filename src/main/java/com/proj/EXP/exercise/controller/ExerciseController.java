package com.proj.EXP.exercise.controller;

import com.proj.EXP.base.rq.Rq;
import com.proj.EXP.exercise.entity.Exercise;
import com.proj.EXP.exercise.service.ExerciseService;
import com.proj.EXP.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    private final Rq rq;

    @GetMapping("/list")
    public String list(@RequestParam(value = "target", required = false, defaultValue = "0") Long targetId, Model model) {
        List<Exercise> exercises;
        if (targetId == 0) {
            exercises = this.exerciseService.findAllExercises(rq.getMember());
        } else {
            exercises = this.exerciseService.findExercisesByTarget(rq.getMember(), targetId);
        }
        model.addAttribute("exercises", exercises);
        return "exercise/list";
    }

}
