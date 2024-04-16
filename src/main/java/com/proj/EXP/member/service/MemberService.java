package com.proj.EXP.member.service;

import com.proj.EXP.member.entity.Member;
import com.proj.EXP.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member create (String id, String name, String password) {
        Member member = new Member();
        member.setMemberId(id);
        member.setMemberName(name);
        member.setPassword(passwordEncoder.encode(password));
        this.memberRepository.save(member);
        return member;
    }
}
