package io.ceylon.election.controller;

import io.ceylon.election.entity.Users;
import io.ceylon.election.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

   @PostMapping("/login")
    public String login(@RequestBody Users user){
        return userService.verify(user);
    }
}
