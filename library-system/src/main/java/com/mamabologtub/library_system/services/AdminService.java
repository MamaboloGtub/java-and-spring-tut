package com.mamabologtub.library_system.services;

import java.util.List;

import com.mamabologtub.library_system.dtos.AdminDto;
import com.mamabologtub.library_system.entities.Admin;

/**
 * @Author Tshepo M Mahudu on Aug 6, 2025.
 */

public interface AdminService {

    Admin createAdmin(AdminDto dto);
    List<Admin> getAdmins();
    Admin getAdmin(String id);
    Admin removeAdmin(String id);

}
