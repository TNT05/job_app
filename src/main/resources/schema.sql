CREATE TABLE IF NOT EXISTS Users (
  user_id INTEGER PRIMARY KEY AUTO_INCREMENT,
  user_name VARCHAR(30) NOT NULL,
  user_email VARCHAR(30) NOT NULL,
  user_password VARCHAR(255) NOT NULL,
  user_status VARCHAR(10) NOT NULL
);

INSERT INTO Users(user_name, user_email, user_password, user_status) VALUES('Thierno Barry', 'titi@hotmai.com', 'titi123', 'ADMIN');

CREATE TABLE IF NOT EXISTS Jobs (
  job_id INTEGER PRIMARY KEY AUTO_INCREMENT,
  job_title VARCHAR(20),
  job_description VARCHAR(50),
  job_status VARCHAR(30)
);

INSERT INTO Jobs(job_title, job_description, job_status) VALUES('SOFTWARE ENGINEER', 'We are looking for a Junior Software Engineer', 'HIRING');