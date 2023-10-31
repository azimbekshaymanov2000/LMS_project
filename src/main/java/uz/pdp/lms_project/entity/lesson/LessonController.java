package uz.pdp.lms_project.entity.lesson;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.lms_project.entity.lesson.repozitary.LessonRepozitary;

@Controller
@RequestMapping("/lesson")
@RequiredArgsConstructor
public class LessonController {
    private final LessonRepozitary lessonRepozitary;

}
