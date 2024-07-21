package com.thierno_ibrahima.job_app.user.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.thierno_ibrahima.job_app.user.model.User;
import com.thierno_ibrahima.job_app.user.repository.UserRepository;



@Service
public class UserService {

  private UserRepository userRepository;

  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public User addUser(User user) {
      return userRepository.addUser(user);
  }

  public User login(String user_email, String user_password) {
    return userRepository.login(user_email, user_password).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
  }


  


}
