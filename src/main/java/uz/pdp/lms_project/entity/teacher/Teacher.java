package uz.pdp.lms_project.entity.teacher;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.lms_project.entity.sciences.entity.Sciences;
import uz.pdp.lms_project.entity.student.Student;
import uz.pdp.lms_project.type.Type;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String fullname;
    @Column(unique = true)
    private String login;
    @Column(unique = true)
    private String parol;


    @ManyToOne
    private Sciences sciences;
    @ManyToMany
    @JoinTable(name = "teacher_student",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;


//    public Teacher(UUID id, String fullname,  Sciences sciences, List<Student> students) {
//        this.id = id;
//        fullname = fullname;
//       // this.type = type;
//        this.sciences = sciences;
//        this.students = students;
//    }
}
