package com.mamabologtub.jwt_practice.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author Tshepo M Mahudu on Jan 17, 2025.
 */

public record UserDto(String name, String email, String password, MultipartFile profilePhoto) {

}
