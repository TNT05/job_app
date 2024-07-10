package com.thierno_ibrahima.job_app.user.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.thierno_ibrahima.job_app.user.model.Status;
import com.thierno_ibrahima.job_app.user.model.User;


@Repository
public class UserRepository {

  private JdbcTemplate jdbcTemplate;

  public UserRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate =  jdbcTemplate;
  }

  public static User mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("user_email"), rs.getString("user_password"), Status.valueOf(rs.getString("user_status")));
  }

  public boolean addUser(User user){
    String sql = "INSERT INTO Users (user_name, user_email, user_password, user_status) VALUES (?,?,?,?)";
    return jdbcTemplate.update(sql, user.getUser_name(), user.getUser_email(), user.getUser_password(), user.getUser_status()) > 0;
  }
}
