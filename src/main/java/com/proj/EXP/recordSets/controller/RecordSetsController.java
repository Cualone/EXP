package com.proj.EXP.recordSets.controller;

import com.proj.EXP.recordSets.service.RecordSetsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("/exercise")
public class RecordSetsController {
    private final RecordSetsService recordSetsService;

    @GetMapping("/set")
    public String recordset(@RequestParam("recordId") Long recordId, Model model) {
        model.addAttribute("sets", recordSetsService.findSetsByRecordId(recordId));
        model.addAttribute("recordId", recordId);
        return "/exercise/set";
    }

    @PostMapping("/addSet")
    public String addSet(@RequestParam("recordId") Long recordId,
                         @RequestParam("weight") double weight,
                         @RequestParam("count") int count,
                         @RequestParam("sets") int sets) {

        recordSetsService.addSet(recordId, weight, count, sets);
        return "redirect:/exercise/set?recordId=" + recordId;
    }
}
