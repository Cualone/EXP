package com.proj.EXP.member.controller;

import com.proj.EXP.member.MemberCreateForm;
import com.proj.EXP.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
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
    public String join(MemberCreateForm memberCreateForm) {
        return "member/join";
    }

    @PostMapping("join")
    public String join(@Valid MemberCreateForm memberCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "member/join";
        }


        try {
            memberService.create(memberCreateForm.getMemberId(), memberCreateForm.getMemberName(), memberCreateForm.getPassword());
        }catch(DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "member/join";
        }catch(Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "member/join";
        }

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }
}
