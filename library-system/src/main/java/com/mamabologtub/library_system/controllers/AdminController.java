package com.mamabologtub.library_system.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mamabologtub.library_system.dtos.AdminDto;
import com.mamabologtub.library_system.entities.Admin;
import com.mamabologtub.library_system.services.AdminService;

/**
 * @Author Tshepo M Mahudu on Sep 7, 2025.
 */

@RestController
@RequestMapping("api/v2/admin")
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService service) {
        this.adminService = service;
    }

    @GetMapping
    public List<Admin> getAdmins() {
        return adminService.getAdmins();
    }

    @PostMapping("/stuff")
    public ResponseEntity<Admin> creatAdmin(@RequestBody AdminDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adminService.createAdmin(dto));
    }

}
