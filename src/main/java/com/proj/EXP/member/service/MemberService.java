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
        Member member = Member
                .builder()
                .memberId(id)
                .memberName(name)
                .password(passwordEncoder.encode(password))
                .build();
        return memberRepository.save(member);
    }
}
