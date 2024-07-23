package com.thierno_ibrahima.job_app.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thierno_ibrahima.job_app.job.model.Job;
import com.thierno_ibrahima.job_app.job.service.JobService;

@RestController
@RequestMapping("/jobs/")
@CrossOrigin
public class JobController {

  @Autowired
  private JobService jobService;

  @GetMapping("/jobPosts")
  public List<Job> findAll(){
    return jobService.findAll();
  }
}
