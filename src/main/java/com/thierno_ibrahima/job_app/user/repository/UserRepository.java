package com.thierno_ibrahima.job_app.user.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

  public User addUser(User user){
    String sql = "INSERT INTO Users (user_name, user_email, user_password, user_status) VALUES (?,?,?,?)";
    jdbcTemplate.update(sql, user.getUser_name(), user.getUser_email(), user.getUser_password(), user.getUser_status().name());
    return user;
  }

  public Optional<User> login(String user_email, String user_password) {
    String query = "SELECT * FROM Users WHERE user_email = ? AND user_password = ?";
    System.out.println("Executing query: " + query);
    System.out.println("With parameters: user_email = " + user_email + ", user_password = " + user_password);

    List<User> result = jdbcTemplate.query(query, ps -> {
        ps.setString(1, user_email);
        ps.setString(2, user_password);
    }, UserRepository::mapRow);

    System.out.println("Query result: " + result);

    if (result.isEmpty()) {
        return Optional.empty();
    } else {
        return Optional.of(result.get(0));
    }
}
}
