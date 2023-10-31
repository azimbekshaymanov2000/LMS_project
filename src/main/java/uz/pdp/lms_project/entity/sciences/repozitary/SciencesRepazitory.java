package uz.pdp.lms_project.entity.sciences.repozitary;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lms_project.entity.sciences.entity.Sciences;

import java.util.UUID;

public interface SciencesRepazitory extends JpaRepository<Sciences, UUID> {
}
