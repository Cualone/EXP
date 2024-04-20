package com.proj.EXP.memberEx.entity;

import com.proj.EXP.exercise.entity.Exercise;
import com.proj.EXP.member.entity.Member;
import com.proj.EXP.target.entity.Target;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Entity
public class MemberEx {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;

    @ManyToOne
    @JoinColumn(name = "memberId", referencedColumnName = "memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "exId", referencedColumnName = "exId")
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "targetId", referencedColumnName = "targetId")
    private Target target;

    private LocalDate date;

    private double weight;

    private int count;

    private int sets;


}
