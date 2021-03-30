package org.example.repository;

import org.example.entity.Admin;
import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query(value = "SELECT * FROM Admin u Where u.name=?1 and u.password=?2", nativeQuery = true)
    Admin findByUserNameAndPasswordAdmin(String name, String password);
}
