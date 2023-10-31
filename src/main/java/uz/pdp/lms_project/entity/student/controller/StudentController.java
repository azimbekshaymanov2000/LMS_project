package uz.pdp.lms_project.entity.student.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.lms_project.entity.sciences.repozitary.SciencesRepazitory;
import uz.pdp.lms_project.entity.teacher.TeacherRepazitory;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final SciencesRepazitory repazitory;
    private final StudentRepazitory studentRepazitory;
    private final TeacherRepazitory teacherRepazitory;
    @GetMapping
    public ModelAndView getMenu(Model model)
    {
      return new ModelAndView("Sciences",model.asMap());
    }
}
