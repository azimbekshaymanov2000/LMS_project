package uz.pdp.lms_project.entity.lesson.repozitary;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.lms_project.entity.lesson.entity.Lesson;

import java.util.UUID;
@Repository
public interface LessonRepozitary extends JpaRepository<Lesson, UUID> {
}
