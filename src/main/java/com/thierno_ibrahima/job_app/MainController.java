package com.thierno_ibrahima.job_app;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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

  @PostMapping("/signInUser")
  public String signUpUser(@ModelAttribute User user, Model model) {
      boolean signUpResult = userService.addUser(user);
      if(signUpResult){
        return "home";
      }
      else{
        model.addAttribute("error", "There was an error during signup");
        return "index";
      }
  }

  @GetMapping("/loginUser")
  public ModelAndView loginUser(String user_email, String user_password, ModelAndView mv) {
    Optional<User> loginUserResult = userService.login(user_email, user_password);
    if(loginUserResult.isPresent()){
      mv.addObject("user",loginUserResult.get());
      mv.setViewName("home");
    }
    else{
      mv.addObject("error", "There was an error during login");
      mv.setViewName("index");
    }
    return mv;
  }
  

  @GetMapping("/home")
  public String home() {
      return "home";
  }

  
  
  
  
}
