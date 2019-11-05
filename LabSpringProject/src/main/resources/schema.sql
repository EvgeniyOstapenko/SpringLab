--DROP TABLE IF EXISTS USERS;
--CREATE TABLE USERS (
--    id long PRIMARY KEY AUTO_INCREMENT,
--    name varchar(255),
--    surname varchar(255),
--    email varchar(255),
--    number varchar(255),
--    password varchar(255),
--    subscription varchar(255),
--    userRole varchar(255)
--);

DROP TABLE IF EXISTS TASKS;
CREATE TABLE TASKS (
    id long PRIMARY KEY AUTO_INCREMENT,
    description varchar(255),
    isDone varchar(8),
    priority varchar(255),
    userId long
--    FOREIGN KEY (userId) REFERENCES USERS(id)
);
