package uz.pdp.lms_project.entity.teacher;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.lms_project.entity.student.Student;
import uz.pdp.lms_project.entity.teacher.dto.TeacherDto;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    private final TeacherRepazitory teacherRepazitory;

    @GetMapping("/add-tiacher")
    public ModelAndView createTeacher(Model model) {
        return new ModelAndView("add-tiacher", model.asMap());
    }

    @PostMapping("/add-tiacher")
    public ModelAndView createTeacher(@ModelAttribute TeacherDto teacher, Model model) {
        for (Teacher teacher1 : teacherRepazitory.findAll()) {
            if (Objects.equals(teacher.getLogin(), teacher1.getLogin()) || Objects.equals(teacher.getParol(), teacher1.getParol())) {
                return new ModelAndView("exception", model.asMap());
            }
        }
        teacherService.saveTeacher(teacher);
        return new ModelAndView("add-tiacher", model.asMap());
    }


    @GetMapping("/all-teacher")
    public ModelAndView seeTeacher(Model model) {
        List<Teacher> teachers = teacherService.allTeacher();
        model.addAttribute("teacher", teachers);
        return new ModelAndView("all-teacher", model.asMap());
    }

    @PostMapping("/{id}")
    public ModelAndView deleateTeacher(@PathVariable("id") UUID id, Model model) {
        model.addAttribute(teacherService.deleteById(id));
        return new ModelAndView("teacher-succes", model.asMap());
    }

    @PostMapping("/update{id}")
    public ModelAndView update(@PathVariable(name = "id") UUID id, Model model) {
        List<Teacher> teachers = teacherService.getbyId(id);
        model.addAttribute("teachers", teachers);
        return new ModelAndView("update-teacher", model.asMap());
    }

    @Transactional
    @GetMapping("/{id}")
    public ModelAndView updateTeacher(@PathVariable("id") UUID id, @RequestParam(name = "fullname") String fullname
            , @RequestParam(name = "login") String login, @RequestParam(name = "parol") String parol, Model model) {
        Teacher teacher = teacherService.getbyId(id).get(0);
        teacher.setFullname(fullname);
        teacher.setLogin(login);
        teacher.setParol(parol);
        model.addAttribute(teacherRepazitory.findAll());

        return new ModelAndView("teacher-update", model.asMap());
    }

    @GetMapping("/back")
    public ModelAndView back(Model model) {
        return new ModelAndView("lessonAdmin", model.asMap());
    }

}
