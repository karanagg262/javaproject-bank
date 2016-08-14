CREATE TABLE adminlogin(
name varchar(20),
email varchar(20),
phone varchar(20),
address varchar(30),
userid varchar(20) PRIMARY KEY,
password varchar(20)
);
CREATE TABLE userlogin(
name varchar(20),
email varchar(20),
phone varchar(20),
address varchar(30),
account varchar(20) PRIMARY KEY,
balance int
);
DROP TABLE userlogin;


