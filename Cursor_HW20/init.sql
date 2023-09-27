CREATE DATABASE IF NOT EXISTS Cursor_HW20_HennadiiBulava;

USE Cursor_HW20_HennadiiBulava;

CREATE TABLE IF NOT EXISTS info (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data VARCHAR(255) NOT NULL
);

INSERT INTO info (data) VALUES ('data1'), ('data2'), ('data3');
