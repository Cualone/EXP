package com.proj.EXP.exercise.entity;

import com.proj.EXP.member.entity.Member;
import com.proj.EXP.target.entity.Target;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.mapping.ToOne;

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

    @ManyToOne
    @JoinColumn(name = "targetId", referencedColumnName = "targetId")
    private Target target;

    @ManyToOne
    @JoinColumn(name = "memberId", referencedColumnName = "memberId")
    private Member creator;

    private String exName;

}
