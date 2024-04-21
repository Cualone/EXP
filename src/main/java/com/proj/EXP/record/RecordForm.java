package com.proj.EXP.record;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class RecordForm {

    @NotNull
    private List<String> exNames;

    private LocalDate date;
}
