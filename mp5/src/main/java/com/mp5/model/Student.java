package com.mp5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Student extends Person{

    @NotNull
    @Size(min = 2, max = 30)
    private String index;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_group_uni",joinColumns = @JoinColumn(name = "student_id"),inverseJoinColumns = @JoinColumn(name = "group_uni_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<GroupUni> submitTo = new HashSet<>();

}
