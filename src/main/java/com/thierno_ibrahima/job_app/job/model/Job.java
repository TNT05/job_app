package com.thierno_ibrahima.job_app.job.model;

public class Job {
  private int job_id;
  private String job_title;
  private String job_description;
  private Status job_status = Status.HIRING;
  
  public Job() {
  }

  public Job(int job_id, String job_title, String job_description, Status job_status) {
    this.job_id = job_id;
    this.job_title = job_title;
    this.job_description = job_description;
    this.job_status = job_status;
  }

  public Job(String job_title, String job_description) {
    this.job_title = job_title;
    this.job_description = job_description;
  }
  
  @Override
  public String toString() {
    return "job [job_id=" + job_id + ", job_title=" + job_title + ", job_description=" + job_description
        + ", job_status=" + job_status + "]";
  }
  public int getJob_id() {
    return job_id;
  }
  public void setJob_id(int job_id) {
    this.job_id = job_id;
  }
  public String getJob_title() {
    return job_title;
  }
  public void setJob_title(String job_title) {
    this.job_title = job_title;
  }
  public String getJob_description() {
    return job_description;
  }
  public void setJob_description(String job_description) {
    this.job_description = job_description;
  }
  public Status getJob_status() {
    return job_status;
  }
  public void setJob_status(Status job_status) {
    this.job_status = job_status;
  }
  
}
