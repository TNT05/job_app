package com.thierno_ibrahima.job_app.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thierno_ibrahima.job_app.user.model.User;
import com.thierno_ibrahima.job_app.user.service.UserService;



@RestController
@RequestMapping("/user/")
@CrossOrigin
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping("signup")
  public User signUp(@RequestBody User user) {
    return userService.addUser(user);
  }

  @PostMapping("login")
  public User login(@RequestBody User user) {
      return userService.login(user.getUser_email(), user.getUser_password());
  }
  
  
}
