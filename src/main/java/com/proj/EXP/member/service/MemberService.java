package com.proj.EXP.member.service;

import com.proj.EXP.member.entity.Member;
import com.proj.EXP.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member create (String id, String name, String password, boolean gender, LocalDate birthDate, double height, double weight) {
        Member member = Member
                .builder()
                .memberId(id)
                .memberName(name)
                .password(passwordEncoder.encode(password))
                .gender(gender)
                .birthDate(birthDate)
                .height(height)
                .weight(weight)
                .build();
        return memberRepository.save(member);
    }

    public Optional<Member> findByMemberId(String memberId) {
        return memberRepository.findByMemberId(memberId);
    }
}
