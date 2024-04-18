package com.proj.EXP.exercise.entity;

import com.proj.EXP.target.entity.Target;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static jakarta.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long exId;

    @OneToOne
    @JoinColumn(name = "targetId")
    private Target targetId;

    private String exName;

}
