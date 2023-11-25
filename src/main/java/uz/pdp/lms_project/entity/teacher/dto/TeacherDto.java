package uz.pdp.lms_project.entity.teacher.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.lms_project.type.Type;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherDto {

    private UUID id;
    private String Fullname;

    private String Login;

    private String parol;
}
