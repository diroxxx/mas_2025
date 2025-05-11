package com.mp5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Syllabus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 2, max = 100)
    private String description;
    @NotNull
    @Size(min = 2, max = 100)
    private String requirements;

    @OneToOne
    @JoinColumn(name = "subject_id", nullable = false, updatable = false)
    private Subject subject;

}
