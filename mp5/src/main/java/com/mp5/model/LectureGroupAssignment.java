package com.mp5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LectureGroupAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate assignmentDate;
    private boolean isMadatory;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "group_uni_id", nullable = false)
    private GroupUni groupUni;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "lecture_id", nullable = false)
    private Lecture lecture;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "classrom_id", nullable = false)
    private Classrom classrom;
}
