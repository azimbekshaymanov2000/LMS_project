package uz.pdp.lms_project.entity.lesson.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import uz.pdp.lms_project.entity.sciences.entity.Sciences;

import java.util.UUID;
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Lesson {
    @Getter
    @Id
    private UUID id;
    private Integer hourOfweek;
    private Integer minutOfweek;
    @Getter
    @ManyToOne
    private Sciences sciences;

    public void setTimeOfweek(Integer hourOfweek) {
        this.hourOfweek = hourOfweek;
    }


    public void setId(UUID id) {
        this.id = id;
    }


    public void setSciences(Sciences sciences) {
        this.sciences = sciences;
    }
}
