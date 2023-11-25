package uz.pdp.lms_project.entity.teacher;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.lms_project.entity.student.Student;
import uz.pdp.lms_project.entity.teacher.dto.TeacherDto;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepazitory teacherRepazitory;
    private final ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public TeacherDto saveTeacher(TeacherDto teacher) {
        Teacher teacher1 = modelMapper.map(teacher, Teacher.class);

        teacherRepazitory.save(teacher1);
        return new TeacherDto(teacher1.getId(), teacher1.getFullname(), teacher1.getLogin(), teacher1.getParol());
    }

    private boolean verificationLogin(String login) {
        for (Teacher teacher : teacherRepazitory.findAll()) {
            if (!teacher.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public List<Teacher> allTeacher() {
        return teacherRepazitory.findAll();
    }

    public List<Teacher> deleteById(UUID id) {
        teacherRepazitory.deleteById(id);
        return teacherRepazitory.findAll();
    }

    public List<Teacher> getbyId(UUID id) {
        Teacher teacher = teacherRepazitory.findById(id).get();
        return List.of(teacher);
    }


}
