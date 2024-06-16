package com.meogo.meogo_backend.global.security.jwt;

import com.meogo.meogo_backend.domain.user.model.UserEntity;
import com.meogo.meogo_backend.domain.user.model.UserModel;
import com.meogo.meogo_backend.domain.user.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TokenizerImpl implements Tokenizer {

    @Override
    public String createAccessToken(String userId) {
        Date now = new Date();

        return Jwts.builder()
                .setSubject(userId)
                .setIssuer(jwtProperties.issuer())
                .signWith(SignatureAlgorithm.HS256, jwtProperties.secret())
                .setIssuedAt(now)
                .setNotBefore(now)
                .setExpiration(new Date(now.getTime() + jwtProperties.exp()))
                .compact();
    }

    @Override
    public String createRefreshToken(String userId) {
        return null;
    }

    @Override
    public boolean validate(String token) {
        return getClaims(token)
                .getIssuer()
                .equals(jwtProperties.issuer());
    }

    @Override
    public Authentication getAuthentication(String token) {
        String subject = getClaims(token)
                .getSubject();

        UserModel user = userRepository.findByUserId(subject)
                .orElseThrow();

        UserDetails userDetails = new User(subject, "", List.of(
                new SimpleGrantedAuthority("ROLE_" + user.getRole().name())
        ));

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(jwtProperties.secret())
                .parseClaimsJws(token)
                .getBody();
    }

    private final JwtProperties jwtProperties;
    private final UserRepository userRepository;
}
