package com.thierno_ibrahima.job_app.user.service;

import org.springframework.stereotype.Service;

import com.thierno_ibrahima.job_app.user.model.User;
import com.thierno_ibrahima.job_app.user.repository.UserRepository;



@Service
public class UserService {

  private UserRepository userRepository;

  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public boolean addUser(User user) {
      return userRepository.addUser(user);
  }
  


}
