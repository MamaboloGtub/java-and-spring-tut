package com.mamabologtub.library_system.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mamabologtub.library_system.dtos.AdminDto;
import com.mamabologtub.library_system.entities.Admin;
import com.mamabologtub.library_system.repositories.AdminRepository;
import com.mamabologtub.library_system.services.AdminService;

/**
 * @Author Tshepo M Mahudu on Aug 6, 2025.
 */

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepo;

    public AdminServiceImpl(AdminRepository repo) {
        this.adminRepo = repo;
    }

    @Override
    public Admin createAdmin(AdminDto dto) {
        Admin admin = entityToDto(dto);
        return adminRepo.save(admin);
    }

    @Override
    public List<Admin> getAdmins() {
        return adminRepo.findAll();
    }

    @Override
    public Admin getAdmin(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Admin removeAdmin(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    private Admin entityToDto(AdminDto dto) {
        Admin admin = new Admin();
        admin.setFullName(dto.getFullName());;
        admin.setEmail(dto.getEmail());
        return admin;

    }
}
