-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

-- CREATE statements go here
CREATE TABLE office (
	id serial NOT NULL,
	address varchar(200) NOT NULL,
	phone_number varchar(20) NOT NULL,
	image_name varchar(100) NOT NULL,
	hours varchar(30) NOT NULL,
	name varchar(30) NOT NULL,
	CONSTRAINT pk_office_id PRIMARY KEY (id)
);

CREATE TABLE doctor (
	id serial NOT NULL,
	name varchar(50) NOT NULL,
	office_id integer NOT NULL,
	fee varchar(16) NOT NULL,
	hours varchar(30) NOT NULL,
	admin boolean NOT NULL,
	user_name varchar(30) NOT NULL,
	password varchar (30) NOT NULL,
	CONSTRAINT pk_doctor_id PRIMARY KEY (id),
	CONSTRAINT fk_office_id FOREIGN KEY (office_id) REFERENCES office(id)
);

CREATE TABLE review (
	id serial NOT NULL,
	rating integer NOT NULL,
	doctor_id integer NOT NULL,
	message varchar(500) NOT NULL,
	CONSTRAINT pk_review_id PRIMARY KEY (id),
	CONSTRAINT fk_doctor_id FOREIGN KEY (doctor_id) REFERENCES doctor(id)
);

CREATE TABLE patient(
	id serial NOT NULL,
	name varchar(50) NOT NULL,
	date_of_birth varchar(20) NOT NULL,
	address varchar(200) NOT NULL,
	phone_number varchar(20) NOT NULL,
	email varchar(50) NOT NULL,
	user_name varchar(30) NOT NULL,
	password varchar(30) NOT NULL,
	CONSTRAINT pk_patient_id PRIMARY KEY (id)
);

CREATE TABLE appointment(
	id serial NOT NULL,
	doctor_id int NOT NULL,
	patient_id int NOT NULL,
	start_date timestamp default now(),
	end_date timestamp default now(),
	message varchar(200),
	CONSTRAINT pk_appointment_id PRIMARY KEY (id),
	CONSTRAINT fk_doctor_id FOREIGN KEY (doctor_id) REFERENCES doctor(id),
	CONSTRAINT fk_patient_id FOREIGN KEY (patient_id) REFERENCES patient(id)	
);


COMMIT;