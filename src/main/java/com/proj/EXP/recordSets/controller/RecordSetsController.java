package com.proj.EXP.recordSets.controller;

import com.proj.EXP.record.service.RecordService;
import com.proj.EXP.recordSets.service.RecordSetsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequiredArgsConstructor
@Controller
@RequestMapping("/exercise")
public class RecordSetsController {
    private final RecordSetsService recordSetsService;
    private final RecordService recordService;

    @GetMapping("/set")
    public String recordset(@RequestParam("recordId") Long recordId, Model model) {
        model.addAttribute("sets", recordSetsService.findSetsByRecordId(recordId));
        model.addAttribute("record", recordService.findById(recordId));
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

    @PostMapping("/deleteSet")
    public String deleteSet(@RequestParam("setId") Long setId, @RequestParam("recordId") Long recordId, RedirectAttributes redirectAttributes) {
        recordSetsService.deleteSetById(setId);
        redirectAttributes.addFlashAttribute("message", "세트가 삭제되었습니다.");
        return "redirect:/exercise/set?recordId=" + recordId;
    }
}
