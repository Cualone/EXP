package com.proj.EXP;

import com.proj.EXP.base.rq.Rq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RequiredArgsConstructor
@Controller
public class HomeController {

    private final Rq rq;

    @GetMapping
    public String home() {

        if (rq.isLogin()) {
            return "redirect:/exercise/record";
        }

        return "/index";
    }
}
