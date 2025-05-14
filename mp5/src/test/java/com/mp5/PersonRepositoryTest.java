package com.mp5;

import com.mp5.model.Student;
import com.mp5.model.Teacher;
import com.mp5.repository.PersonRepository;
import com.mp5.repository.StudentRepository;
import com.mp5.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    Student student1;
    Teacher teacher1;

    @BeforeEach
    public void init() {
        student1 = Student.builder()
                .firstName("Dominik")
                .lastName("Kowalksi")
                .email("che-dom@wp.pl")
                .phoneNumber("123123123")
                .index("s267123")
                .build();
        teacher1 = Teacher.builder()
                .firstName("Tomek")
                .lastName("Ksadasdsi")
                .email("tomek@wp.pl")
                .phoneNumber("123123111")
                .hireDate(LocalDate.of(2022, 2, 2))
                .academicTitle("Dr")
                .build();
    }

    @Test
    void testSaveAll() {
        teacherRepository.save(teacher1);
        studentRepository.save(student1);
        assertEquals(3, personRepository.count());
    }

}
