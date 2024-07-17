package com.thierno_ibrahima.job_app.job.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.thierno_ibrahima.job_app.job.model.Job;
import com.thierno_ibrahima.job_app.job.model.Status;

@Repository
public class JobRepository {
  private JdbcTemplate jdbcTemplate;
  
  public JobRepository(JdbcTemplate jdbcTemplate){
    this.jdbcTemplate = jdbcTemplate;
  }

  public static Job mapRow(ResultSet res, int rowNum) throws SQLException{
    return new Job(res.getInt("job_id"), res.getString("job_title"), res.getString("job_description"), Status.valueOf(res.getString("job_status")));
  }

  public List<Job> findAll(){
    String sql = "SELECT * FROM Jobs";
    List<Job> jobList = jdbcTemplate.query(sql, JobRepository::mapRow);
    return jobList;
  }

  public int apply(int user_id, int job_id) {
    System.out.println("here");
    String query = "Update Jobs SET job_status = ? WHERE job_id = ?";
    return jdbcTemplate.update(query, Status.NO_LONGER_HIRING.name(), job_id);
  }

}
