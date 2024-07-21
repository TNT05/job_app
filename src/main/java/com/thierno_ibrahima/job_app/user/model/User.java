package com.thierno_ibrahima.job_app.user.model;

public class User {
  private int user_id;
  private String user_name;
  private String user_email;
  private String user_password;
  private Status user_status = Status.CLIENT;

    public User(String user_email, String user_password) {
        this.user_email = user_email;
        this.user_password = user_password;
    }

  public int getUser_id() {
    return user_id;
  }
  public User(String user_name, String user_email, String user_password) {
    System.out.println("in constructor 1");
    this.user_name = user_name;
    this.user_email = user_email;
    this.user_password = user_password;
    this.user_status = Status.CLIENT;
  }
  
  public User() {
    System.out.println("in constructor 2");
  }
  
  public User(int user_id, String user_name, String user_email, String user_password, Status user_status) {
    System.out.println("in constructor 3");
    this.user_id = user_id;
    this.user_name = user_name;
    this.user_email = user_email;
    this.user_password = user_password;
    this.user_status = user_status;
  }
  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }
  public String getUser_name() {
    return user_name;
  }
  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }
  public String getUser_email() {
    return user_email;
  }
  public void setUser_email(String user_email) {
    this.user_email = user_email;
  }
  public String getUser_password() {
    return user_password;
  }
  public void setUser_password(String user_password) {
    this.user_password = user_password;
  }
  public Status getUser_status() {
    return user_status;
  }
  public void setUser_status(Status user_status) {
    this.user_status = user_status;
  }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{");
        sb.append("user_id=").append(user_id);
        sb.append(", user_name=").append(user_name);
        sb.append(", user_email=").append(user_email);
        sb.append(", user_password=").append(user_password);
        sb.append(", user_status=").append(user_status);
        sb.append('}');
        return sb.toString();
    }
}
