package uz.pdp.lms_project.security;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import uz.pdp.lms_project.entity.student.controller.StudentRepazitory;
import uz.pdp.lms_project.entity.teacher.TeacherRepazitory;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final StudentRepazitory repazitory;
    private final TeacherRepazitory teacherRepazitory;

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

}
