package com.proj.EXP.exercise.controller;

import com.proj.EXP.base.rq.Rq;
import com.proj.EXP.exercise.ExerciseCreateForm;
import com.proj.EXP.exercise.entity.Exercise;
import com.proj.EXP.exercise.service.ExerciseService;
import com.proj.EXP.target.repository.TargetRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    private final Rq rq;
    private final TargetRepository targetRepository;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/list")
    public String list(@RequestParam(value = "target", required = false, defaultValue = "0") Long targetId,
                       @RequestParam(value = "selectedDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate selectedDate,
                       Model model) {
        List<Exercise> exercises;
        if (targetId == 0) {
            exercises = this.exerciseService.findAllExercises(rq.getMember());
        } else {
            exercises = this.exerciseService.findExercisesByTarget(rq.getMember(), targetId);
        }
        model.addAttribute("selectedDate", selectedDate);
        model.addAttribute("exercises", exercises);
        return "exercise/list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/add")
    public String showAdd(ExerciseCreateForm exerciseCreateForm) {
        return "exercise/add";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/add")
    public String add(@Valid ExerciseCreateForm exerciseForm,
                      @RequestParam("selectedDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate selectedDate) {
        exerciseService.create(targetRepository.findByTargetId(exerciseForm.getTargetId()),
                rq.getMember(),
                exerciseForm.getExName());
        return "redirect:/exercise/list?selectedDate=" + selectedDate;
    }

}