package uz.pdp.lms_project.entity.lesson.repozitary;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.lms_project.entity.sciences.entity.Sciences;
import uz.pdp.lms_project.entity.sciences.repozitary.SciencesRepazitory;

import java.util.UUID;

@Controller
@RequestMapping("/{id}")
@RequiredArgsConstructor
public class GetCantroller {
    private final LessonRepozitary lessonRepozitary;
    private final SciencesRepazitory sciences;
    @GetMapping()
    public ModelAndView getAll(@PathVariable("id") UUID id, Model model)
    {
        System.out.println("id = " + id);
        System.out.println("salom");
        return new ModelAndView("Lesson");
    }
    @PostMapping
    private ModelAndView viewAndStudent(@PathVariable("id")UUID id, Model model)
    {
        Sciences sciences1 = sciences.findById(id).get();
        model.addAttribute(sciences1);
        return new ModelAndView("Amaliyot",model.asMap());
    }

}
