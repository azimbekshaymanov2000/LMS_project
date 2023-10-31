package uz.pdp.lms_project.entity.student;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.lms_project.entity.sciences.entity.Sciences;
import uz.pdp.lms_project.type.Type;

import java.util.List;
import java.util.UUID;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    @Id
    private UUID id;
    private String name;
    private String Surname;
     private Type UserType;
     private String login;
     private String password;
     @ManyToMany
     @JoinTable(name = "student_sciences" ,
     joinColumns = @JoinColumn(name = "student_id"),
     inverseJoinColumns = @JoinColumn(name = "sciences_id"))
    private List<Sciences>sciences;
}
