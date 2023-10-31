package uz.pdp.lms_project.entity.student.controller;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.lms_project.entity.student.Student;

import java.util.UUID;
@Repository
public interface StudentRepazitory extends JpaRepository<Student, UUID> {
    Student getByLogin(String login);
}
