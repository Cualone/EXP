package com.proj.EXP.member.controller;

import com.proj.EXP.member.MemberCreateForm;
import com.proj.EXP.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("join")
    public String signup(MemberCreateForm memberCreateForm) {
        return "member/join";
    }

    @PostMapping("join")
    public String signup(@Valid MemberCreateForm memberCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "member/join";
        }

        memberService.create(memberCreateForm.getMemberId(), memberCreateForm.getMemberName(), memberCreateForm.getPassword());

        return "redirect:/";
    }
}
