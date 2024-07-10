package com.thierno_ibrahima.job_app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.thierno_ibrahima.job_app.user.model.User;
import com.thierno_ibrahima.job_app.user.service.UserService;



@Controller
@CrossOrigin
public class MainController {

  private UserService userService;

  public MainController(UserService userService){
    this.userService = userService;
  }

  @GetMapping("/index")
  public String index(Model model){
    model.addAttribute("user", new User());
    return "index";
  }

  @PostMapping("/signUpUser")
  public String signUpUser(@ModelAttribute User user, Model model) {
      boolean signUpResult = userService.addUser(user);
      if(signUpResult){
        return "redirect:/home";
      }
      else{
        model.addAttribute("error", "There was an error during signup");
        return "index";
      }
  }

  @GetMapping("/home")
  public String home() {
      return "home";
  }
  
  
}
