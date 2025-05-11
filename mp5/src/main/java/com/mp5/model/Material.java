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
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30)
    private String title;
    @NotNull
    @Size(min = 2, max = 30)
    private String type;
    @NotNull
    @Size(min = 2, max = 30)
    private String fileUrl;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    @NotNull
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    @NotNull
    private Subject subject;

}
