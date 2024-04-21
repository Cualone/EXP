package com.proj.EXP.record.controller;


import com.proj.EXP.base.rq.Rq;
import com.proj.EXP.exercise.entity.Exercise;
import com.proj.EXP.exercise.service.ExerciseService;
import com.proj.EXP.record.RecordForm;
import com.proj.EXP.record.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/exercise")
public class RecordController {

    private final RecordService recordService;

    private final ExerciseService exerciseService;

    private final Rq rq;

    @GetMapping("/record")
    public String record(@RequestParam(value = "selectedDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate selectedDate, Model model) {
        if (selectedDate == null) {
            selectedDate = LocalDate.now();
        }
        model.addAttribute("selectedDate", selectedDate);
        model.addAttribute("prevDate", selectedDate.minusDays(1)); // 이전 날짜 탐색 범위
        model.addAttribute("nextDate", selectedDate.plusDays(1)); // 다음 날짜 탐색 범위
        model.addAttribute("records", recordService.findByMemberAndDate(rq.getMember(), selectedDate));
        return "/exercise/record";
    }

    @PostMapping("/record/add")
    public String addRecords(RecordForm recordForm) {

        recordForm.getExNames().forEach(exName -> {
            Exercise exercise = exerciseService.findByExName(exName);
            if (exercise != null) {
                recordService.create(exercise, recordForm.getDate());
            }
        });
        return "redirect:/exercise/record"; // 성공적으로 처리한 후 리다이렉트할 페이지
    }
}
