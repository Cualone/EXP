package com.proj.EXP.member;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class MemberCreateForm {

    @Size(min = 4, max = 10)
    @NotEmpty(message = "ID는 필수항목입니다.")
    private String memberId;

    @Size(min = 2, max = 10)
    @NotEmpty(message = "닉네임을 입력해 주세요.")
    private String memberName;

    @Size(min = 6, max = 25)
    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password;

    private boolean gender;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private double height;

    @NotNull
    private double weight;
}
