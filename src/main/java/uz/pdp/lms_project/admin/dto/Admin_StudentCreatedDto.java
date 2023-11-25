package uz.pdp.lms_project.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.lms_project.entity.sciences.entity.Sciences;
import uz.pdp.lms_project.type.Type;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin_StudentCreatedDto {

    private UUID id;
    private String name;
    private String Surname;
    private String login;
    private String password;

}
