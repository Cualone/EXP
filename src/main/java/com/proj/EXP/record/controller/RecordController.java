package com.proj.EXP.record.controller;


import com.proj.EXP.base.rq.Rq;
import com.proj.EXP.exercise.entity.Exercise;
import com.proj.EXP.exercise.service.ExerciseService;
import com.proj.EXP.record.RecordForm;
import com.proj.EXP.record.repository.RecordRepository;
import com.proj.EXP.record.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private final RecordRepository recordRepository;

    @PreAuthorize("isAuthenticated()")
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

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/record/add")
    public String addRecords(RecordForm recordForm) {

        recordForm.getExNames().forEach(exName -> {
            Exercise exercise = exerciseService.findByExName(exName);
            if (exercise != null) {

                boolean isRecorded = recordService.isExerciseRecordedOnDate(exercise, recordForm.getDate());

                if (!isRecorded) {
                    recordService.create(exercise, recordForm.getDate());
                }
            }
        });
        return "redirect:/exercise/record?selectedDate=" + recordForm.getDate();
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/record/delete")
    public String delRecords(@RequestParam("recordId") Long recordId, @RequestParam("selectedDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate selectedDate) {
        recordService.delete(recordId);
        return "redirect:/exercise/record?selectedDate=" + selectedDate;
    }

}