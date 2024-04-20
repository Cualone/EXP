package com.proj.EXP.exercise;

import com.proj.EXP.target.entity.Target;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseCreateForm {

    @NotEmpty(message = "이름을 입력해주세요")
    private String exName;

    @NotNull
    private Long targetId;
}
