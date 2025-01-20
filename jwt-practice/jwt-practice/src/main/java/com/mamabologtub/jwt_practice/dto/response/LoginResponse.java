package com.mamabologtub.jwt_practice.dto.response;


/**
 * @Author Tshepo M Mahudu on Jan 17, 2025.
 */

public record LoginResponse(String token, String name, String email, String profilePhoto) {

}
