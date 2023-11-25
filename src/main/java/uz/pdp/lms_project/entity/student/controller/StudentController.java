package uz.pdp.lms_project.entity.student.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.lms_project.admin.dto.Admin_StudentCreatedDto;
import uz.pdp.lms_project.entity.sciences.repozitary.SciencesRepazitory;
import uz.pdp.lms_project.entity.student.Student;
import uz.pdp.lms_project.entity.teacher.TeacherRepazitory;

import java.rmi.AlreadyBoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final SciencesRepazitory repazitory;
    private final StudentService studentRepazitory;
    private final StudentRepazitory studentRepazitory1;
    private final TeacherRepazitory teacherRepazitory;

    @GetMapping
    public ModelAndView getMenu(Model model) {
        return new ModelAndView("Sciences", model.asMap());
    }

    @GetMapping("/add-student")
    public ModelAndView createStudent(Model model) {
        return new ModelAndView("add-student", model.asMap());
    }

    @PostMapping("/add-student")
    public ModelAndView createStudent(@ModelAttribute Admin_StudentCreatedDto dto, Model model) throws AlreadyBoundException {

        for (Student student : studentRepazitory1.findAll()) {

            if (dto.getLogin().equals(student.getLogin()) || dto.getPassword().equals(student.getPassword())) {
                return new ModelAndView("equals", model.asMap());
            }

        }
        studentRepazitory.createStudent(dto);

        return new ModelAndView("add-student", model.asMap());

    }

    @GetMapping("/all-student")
    public ModelAndView allStudent(Model model) {
        List<Student> students = studentRepazitory.allStudent();
        model.addAttribute("student", students);
        return new ModelAndView("all-student", model.asMap());
    }

    @PostMapping("/{id}")
    public ModelAndView deleateStudent(@PathVariable(name = "id") UUID id, Model model) {

        model.addAttribute(studentRepazitory.deleateById(id));
        return new ModelAndView("delet-succes", model.asMap());
    }

    @Transactional
    @GetMapping("/{id}")
    public ModelAndView update(@PathVariable("id") UUID id, @RequestParam("name") String name, @RequestParam("surname") String surname,
                               @RequestParam("login") String login, @RequestParam("password") String password, Model model) {
        System.out.println(id);
        Student student = studentRepazitory1.findById(id).get();
        student.setName(name);
        student.setPassword(password);
        student.setSurname(surname);
        student.setLogin(login);
        model.addAttribute(studentRepazitory1.findAll());
        return new ModelAndView("update-succes", model.asMap());
    }

    @PostMapping("/update{id}")
    public ModelAndView update(@PathVariable(name = "id") UUID id, Model model) {
        List<Student> students = studentRepazitory.getbyId(id);
        model.addAttribute("student", students);
        return new ModelAndView("update", model.asMap());
    }

    @GetMapping("/back")
    public ModelAndView back(Model model) {
        return new ModelAndView("lessonAdmin", model.asMap());
    }


}
