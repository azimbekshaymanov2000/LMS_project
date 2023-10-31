package uz.pdp.lms_project.admin.repozitary;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.lms_project.admin.Admin;

import java.util.UUID;

@Repository
public interface AdminRepozitary extends JpaRepository<Admin, UUID> {
    Admin findByLogin(String login);
}
