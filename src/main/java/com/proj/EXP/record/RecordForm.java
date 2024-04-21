package com.proj.EXP.record;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecordForm {

    @NotNull
    private List<String> exNames;
}
