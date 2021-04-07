package org.example.controller;

import org.example.entity.Admin;
import org.example.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;


    @GetMapping("")
    public List<Admin> getALLAdmins() {
        return adminRepository.findAll();
    }

    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable("id") Long id) {
        return adminRepository.findById(id).get();
    }

    @PostMapping("")
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminRepository.saveAndFlush(admin);
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable Long id) {

        adminRepository.deleteById(id);
    }

}
