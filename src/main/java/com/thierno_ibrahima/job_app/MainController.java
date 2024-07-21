package com.thierno_ibrahima.job_app;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thierno_ibrahima.job_app.job.model.Job;
import com.thierno_ibrahima.job_app.job.service.JobService;
import com.thierno_ibrahima.job_app.user.model.User;
import com.thierno_ibrahima.job_app.user.service.UserService;


@Controller
@CrossOrigin
public class MainController {

  private final UserService userService;
  private final JobService jobService;

  public MainController(UserService userService, JobService jobService){
    this.userService = userService;
    this.jobService = jobService;
  }

  @GetMapping("/index")
  public String index(Model model){
    model.addAttribute("user", new User());
    return "index";
  }

  @PostMapping("/signInUser")
  public String signUpUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
      User signUpResult = userService.addUser(user);
      if(Objects.nonNull(signUpResult)){
        redirectAttributes.addFlashAttribute("user", user);
        return "redirect:/home"; // Redirect to the /home endpoint
      }
      else{
        redirectAttributes.addFlashAttribute("error", "There was an error during signup");
        return "redirect:/index";
      }
  }

  // @GetMapping("/loginUser")
  // public String loginUser(String user_email, String user_password, RedirectAttributes redirectAttributes) {
  //   User loginUserResult = userService.login(user_email, user_password);
  //   if(loginUserResult.isPresent()){
  //     redirectAttributes.addFlashAttribute("user", loginUserResult.get());
  //     return "redirect:/home"; // Redirect to the /home endpoint
  //   }
  //   else{
  //     redirectAttributes.addFlashAttribute("error", "There was an error during login");
  //     return "redirect:/index";
  //   }
  // }

  @GetMapping("/home")
  public String home(Model model, @ModelAttribute("user") User user) {
    List<Job> jobList = jobService.findAll();
    for(Job job: jobList){
      System.out.println(job);
    }
    model.addAttribute("jobList", jobList);
    model.addAttribute("user", user);
    return "home";
  }

  @PostMapping("/apply")
  public String apply(int job_id, @ModelAttribute("user") User user, Model model) {
    System.out.println("first");
    int applyResult = jobService.apply(user.getUser_id(), job_id);
    if (applyResult < 0) {
      model.addAttribute("error", "error while applying");
    } 
      return "home";
  }
  
}
