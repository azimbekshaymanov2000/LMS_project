package uz.pdp.lms_project.entity.student.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.lms_project.admin.dto.Admin_StudentCreatedDto;
import uz.pdp.lms_project.entity.student.Student;


import java.rmi.AlreadyBoundException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepazitory studentRepazitory;
    private final ModelMapper modelMapper = new ModelMapper();


    public List<Student> allStudent() {
        return studentRepazitory.findAll();
    }

    @Transactional
    public Admin_StudentCreatedDto createStudent(Admin_StudentCreatedDto student) {
        Student student1 = modelMapper.map(student, Student.class);

        studentRepazitory.save(student1);

        return new Admin_StudentCreatedDto(student1.getId(), student1.getName(),
                student1.getSurname(), student1.getPassword(),
                student1.getPassword());

    }

    public List<Student> deleateById(UUID id) {
        studentRepazitory.deleteById(id);
        return studentRepazitory.findAll();
    }

    public List<Student> getbyId(UUID id) {
        Student student = studentRepazitory.findById(id).get();
        return List.of(student);
    }


}
