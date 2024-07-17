package com.thierno_ibrahima.job_app.job.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thierno_ibrahima.job_app.job.model.Job;
import com.thierno_ibrahima.job_app.job.repository.JobRepository;

@Service
public class JobService {
  private JobRepository jobRepository;

  public JobService(JobRepository jobRepository){
    this.jobRepository = jobRepository;
  }

  public List<Job> findAll(){
    return jobRepository.findAll();
  }

  public int apply(int user_id, int job_id) { 
    System.out.println("there");
    return jobRepository.apply(user_id, job_id); 
  }
  
}
