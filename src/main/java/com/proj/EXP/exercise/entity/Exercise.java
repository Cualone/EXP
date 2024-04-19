package com.proj.EXP.exercise.entity;

import com.proj.EXP.target.entity.Target;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exId;

    @OneToOne
    @JoinColumn(name = "targetId", referencedColumnName = "targetId")
    private Target target;

    private String exName;

}
