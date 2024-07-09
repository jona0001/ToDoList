CREATE DATABASE IF NOT EXISTS todoapp;

USE todoapp;

DROP TABLE IF EXISTS task;
CREATE TABLE task (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(50) NOT NULL,
                      description VARCHAR(250),
                      creatingDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      deadline DOUBLE,
                      isComplete BOOLEAN,
                      priority ENUM('Low', 'Medium', 'High') NOT NULL
);
