package io.ceylon.election.service.impl;

import io.ceylon.election.entity.Users;
import io.ceylon.election.service.JWTService;
import io.ceylon.election.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jWTService;


    @Override
    public String verify(Users user) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        return authentication.isAuthenticated()?jWTService.generateToken(user.getUsername()):"Failed";
    }
}
