package com.proj.EXP.recordSets.entity;

import com.proj.EXP.exercise.entity.Exercise;
import com.proj.EXP.member.entity.Member;
import com.proj.EXP.record.entity.Record;
import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Entity
public class RecordSets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long setId;

    @ManyToOne
    @JoinColumn(name = "recordId", referencedColumnName = "recordId")
    private Record record;

    @ManyToOne
    @JoinColumn(name = "memberId", referencedColumnName = "memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "exId", referencedColumnName = "exId")
    private Exercise exercise;

    private double weight;
    private int count;
    private int sets;
}