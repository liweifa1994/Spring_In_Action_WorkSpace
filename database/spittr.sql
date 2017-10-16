CREATE SCHEMA spittr DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
create table Spittle (
	id INT AUTO_INCREMENT PRIMARY KEY ,
	message VARCHAR(140) not null,
	created_at timestamp not null,
	latitude double,
	longitude double
);

create table Spitter (
	id INT AUTO_INCREMENT PRIMARY KEY ,
	username VARCHAR(20) unique not null,
	password VARCHAR(20) not null,
	first_name VARCHAR(30) not null,
	last_name VARCHAR(30) not null,
	email VARCHAR(30) not null
);