package com.proj.EXP;

import com.proj.EXP.base.rq.Rq;
import com.proj.EXP.record.service.RecordService;
import com.proj.EXP.target.entity.Target;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@RequiredArgsConstructor
@ControllerAdvice
public class StatusController {

    private final Rq rq;

    private final RecordService recordService;

    @ModelAttribute
    public void status(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            List<Object[]> targets = recordService.getTargetsInLastWeek();
            model.addAttribute("targets", targets);
        }
    }
}
