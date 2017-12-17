package com.tr1nksgroup.model.components;

import com.tr1nksgroup.model.entities.UserEntity;
import com.tr1nksgroup.model.services.UserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Resource
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication auth) {
        String email = auth.getName();
        String password = auth.getCredentials().toString();
        UserEntity userEntity = userService.getByEmail(email);
        if (null != userEntity && userEntity.isEnabled() && password.equals(userEntity.getPassword())) {
            Set<GrantedAuthority> roles = new HashSet<>();
            roles.add(new SimpleGrantedAuthority(userEntity.getRole().getRoleWithPrefix()));
            return new UsernamePasswordAuthenticationToken(userEntity.getUserUUID(), userEntity.getPassword(), roles);
        } else {
            return null;//return if not authenticate
        }
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}