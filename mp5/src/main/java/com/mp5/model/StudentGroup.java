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
public class StudentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private LocalDate acceptedDate;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "group_id", nullable = false)
    private GroupUni studentGroupUni;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}
