package com.proj.EXP;

import com.proj.EXP.base.rq.Rq;
import com.proj.EXP.exercise.entity.Exercise;
import com.proj.EXP.record.entity.Record;
import com.proj.EXP.record.service.RecordService;
import com.proj.EXP.target.entity.Target;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class HomeController {

    private final Rq rq;

    private final RecordService recordService;

    @GetMapping
    public String home() {

        if (rq.isLogin()) {
            return "redirect:/exercise/record";
        }

        return "/index";
    }

}
