package com.mamabologtub.jwt_practice.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.mamabologtub.jwt_practice.Entity.User;
import com.mamabologtub.jwt_practice.config.JwtConfig;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import lombok.AllArgsConstructor;

/**
 * @Author Tshepo M Mahudu on Jan 17, 2025.
 */

@Service
@AllArgsConstructor
public class TokenService {

    private final JwtConfig jwtConfig;

    @SuppressWarnings("deprecation")
    public String generateToken(Authentication authentication) {
        JWSHeader header = new JWSHeader.Builder(jwtConfig.getAlgorithm())
                .type(JOSEObjectType.JWT)
                .build();
        Instant now = Instant.now();
        var roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        var builder = new JWTClaimsSet.Builder()
                .issuer("tshepo")
                .issueTime(Date.from(now))
                .expirationTime(Date.from(now.plus(1, ChronoUnit.HOURS)));
        builder.claim("roles", roles);
        var user = (User) authentication.getPrincipal();
        builder.claim("name", user.getName());
        builder.claim("email", user.getEmail());
        builder.claim("id", user.getId());
        var claims = builder.build();

        var key = jwtConfig.getSecretKey();
        var jwt = new SignedJWT(header, claims);

        try {
            var signer = new MACSigner(key);
            jwt.sign(signer);
        } catch (JOSEException e) {
            throw new RuntimeException("Error generating JWT", e);
        }
        return jwt.serialize();
    }

}
