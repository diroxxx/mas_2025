package com.mp5;

import com.mp5.model.GroupUni;
import com.mp5.model.Student;
import com.mp5.model.StudentGroup;
import com.mp5.repository.GroupUniRepository;
import com.mp5.repository.StudentGroupRepository;
import com.mp5.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class StudentGroupRepositoryTest {


    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentGroupRepository studentGroupRepository;
    @Autowired
    private GroupUniRepository groupUniRepository;

    Student student1;
    Student student2;
    StudentGroup studentGroup1;
    StudentGroup studentGroup2;
    GroupUni groupUni1;


    @BeforeEach
    public void init() {
        student1 = Student.builder()
                .firstName("Dominik")
                .lastName("Kowalksi")
                .email("che-dom@wp.pl")
                .phoneNumber("123123123")
                .index("s267123")
                .build();
        student2 = Student.builder()
                .firstName("Tomek")
                .lastName("wqfdeasi")
                .email("chdfdsfsdf@wp.pl")
                .phoneNumber("123123123")
                .index("s2231")
                .build();
        groupUni1 = GroupUni.builder()
                .name("sem3_12c")
                .type("Lecture")
                .build();
        studentGroup1 = StudentGroup.builder()
                .student(student1)
                .acceptedDate(LocalDate.now())
                .studentGroupUni(groupUni1)
                .build();
        studentGroup2 = StudentGroup.builder()
                .student(student2)
                .acceptedDate(LocalDate.now())
                .studentGroupUni(groupUni1)
                .build();
        studentRepository.saveAll(List.of(student1, student2));
        groupUniRepository.save(groupUni1);
        studentGroupRepository.save(studentGroup1);
        studentGroupRepository.save(studentGroup2);
    }


    @Test
    public void checkIfStudentGroupIsSaved() {
        assertEquals(2,studentGroupRepository.count());
    }

}
