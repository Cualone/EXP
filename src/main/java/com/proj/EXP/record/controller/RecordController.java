package com.proj.EXP.record.controller;


import com.proj.EXP.exercise.entity.Exercise;
import com.proj.EXP.exercise.service.ExerciseService;
import com.proj.EXP.record.RecordForm;
import com.proj.EXP.record.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/record")
public class RecordController {

    private final RecordService recordService;

    private final ExerciseService exerciseService;

    @GetMapping("/")
    public String record(Model model) {
        model.addAttribute("records", recordService.findAll());
        return "/exercise/record";
    }

    @PostMapping("/add")
    public String addRecords(RecordForm recordForm) {

        recordForm.getExNames().forEach(exName -> {
            Exercise exercise = exerciseService.findByExName(exName);
            if (exercise != null) {
                recordService.create(exercise);
            }
        });
        return "redirect:/"; // 성공적으로 처리한 후 리다이렉트할 페이지
    }
}
