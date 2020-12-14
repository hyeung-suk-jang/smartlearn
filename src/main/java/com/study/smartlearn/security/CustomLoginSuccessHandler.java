package com.study.smartlearn.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException {
        List<String> roles = new ArrayList<>();
        authentication.getAuthorities().forEach(authority -> {
            roles.add(authority.getAuthority());
        });

        if (roles.contains("ROLE_MEMBER")) {
            response.sendRedirect("/");
        }
    }
}