package com.mp5;

import com.mp5.model.GroupUni;
import com.mp5.model.Student;
import com.mp5.repository.GroupUniRepository;
import com.mp5.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
@RequiredArgsConstructor
public class Mp5Application implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final GroupUniRepository groupRepository;

    @Override
    public void run(String... args) throws Exception {
        if (studentRepository.count() == 0 && groupRepository.count() == 0) {
            GroupUni group = GroupUni.builder()
                    .name("sem5_a")
                    .type("Lecture")
                    .build();

            Student student = Student.builder()
                    .firstName("Anna")
                    .lastName("Kowalska")
                    .email("anna@wp.pl")
                    .phoneNumber("123123123")
                    .index("s12345")
                    .build();


            group.setSubmitedBy(Set.of(student));
            student.setSubmitTo(Set.of(group));
            groupRepository.save(group);
            studentRepository.save(student);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Mp5Application.class, args);
    }

}
