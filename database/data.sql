-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

-- INSERT statements go here

INSERT INTO office (address, phone_number, image_name, hours, name) VALUES ('1234 Memory Lane Columbus, OH 43228', '614-555-1234', 'office1', '8:00AM - 6:00PM', 'North Office');
INSERT INTO office (address, phone_number, image_name, hours, name) VALUES ('124 Super Road Columbus, OH 43228', '614-555-1534', 'office2', '7:00AM - 5:00PM', 'South Office');
INSERT INTO office (address, phone_number, image_name, hours, name) VALUES ('1555 Awesome Drive Columbus, OH 43228', '614-555-1444', 'office3', '8:00AM - 9:00PM', 'West Office');
INSERT INTO office (address, phone_number, image_name, hours, name) VALUES ('125 Epic Valley Columbus, OH 43228', '614-555-2444', 'office4', '7:00AM - 6:00PM', 'East Office');

INSERT INTO doctor (name, office_id, fee, hours, admin, user_name, password) VALUES ('Dr. John', 1, '$50', '8:00AM -5:00 PM', false, 'Drjohn','doctorNUmber1');
INSERT INTO doctor (name, office_id, fee, hours, admin, user_name, password) VALUES ('Dr. Admin', 1, '$55', '8:00AM -5:30 PM', true, 'Dradmin','doctorNUmber2');
INSERT INTO doctor (name, office_id, fee, hours, admin, user_name, password) VALUES ('Dr. Cool', 1, '$65', '9:00AM -4:00 PM', false, 'Drcool','doctorNUmber3');
INSERT INTO doctor (name, office_id, fee, hours, admin, user_name, password) VALUES ('Dr. Smith', 2, '$50', '9:00AM -5:00 PM', true, 'Drsmith','doctorNUmber4');
INSERT INTO doctor (name, office_id, fee, hours, admin, user_name, password) VALUES ('Dr. Low', 2, '$50', '7:00AM -3:00 PM', false, 'Drlow','doctorNUmber5');
INSERT INTO doctor (name, office_id, fee, hours, admin, user_name, password) VALUES ('Dr. High', 2, '$60', '9:00AM -5:00 PM', false, 'Drhigh','doctorNUmber6');
INSERT INTO doctor (name, office_id, fee, hours, admin, user_name, password) VALUES ('Dr. Joe', 3, '$40', '11:00AM -9:00 PM', false, 'Drjoe','doctorNUmber7');
INSERT INTO doctor (name, office_id, fee, hours, admin, user_name, password) VALUES ('Dr. Ben', 3, '$50', '9:00AM -5:00 PM', true, 'Drben','doctorNUmber8');
INSERT INTO doctor (name, office_id, fee, hours, admin, user_name, password) VALUES ('Dr. Yu', 3, '$60', '8:00AM -4:00 PM', false, 'Dryu','doctorNUmber9');
INSERT INTO doctor (name, office_id, fee, hours, admin, user_name, password) VALUES ('Dr. Chen', 4, '$50', '9:00AM -5:00 PM', false, 'Drchen','doctorNUmber10');
INSERT INTO doctor (name, office_id, fee, hours, admin, user_name, password) VALUES ('Dr. Lu', 4, '$75', '7:00AM -3:00 PM', true, 'Drlu','doctorNUmber11');
INSERT INTO doctor (name, office_id, fee, hours, admin, user_name, password) VALUES ('Dr. Pent', 4, '$80', '9:00AM -6:00 PM', false, 'Drpent','doctorNUmber12');

INSERT INTO patient (name, date_of_birth, address, phone_number, email, user_name, password) VALUES ('Matt Kress', '04/04/1994', '585 Nowhere Dr.', '614-555-4567', 'matt@gmail.com', 'Mkress','12345ABCDe');
INSERT INTO patient (name, date_of_birth, address, phone_number, email, user_name, password) VALUES ('Josh Hanf', '05/23/1986', '678 Cool Road', '614-555-4555', 'josh@gmail.com', 'Jhanf','12345ABCDe');
INSERT INTO patient (name, date_of_birth, address, phone_number, email, user_name, password) VALUES ('Laura Stephens', '04/20/1982', '633 Number Road', '614-555-5643', 'laura@gmail.com', 'Lstephens','12345ABCDe');
INSERT INTO patient (name, date_of_birth, address, phone_number, email, user_name, password) VALUES ('John Smith', '04/05/1992', '600 Hidden Valley', '614-555-9999', 'john@gmail.com', 'Jsmith','12345ABCDE');
INSERT INTO patient (name, date_of_birth, address, phone_number, email, user_name, password) VALUES ('Joe Schmoe', '12/25/2000', '500 Nightmare Lane', '614-555-9898', 'joe@aol.com', 'Jschmoe','12345ABCDE');
INSERT INTO patient (name, date_of_birth, address, phone_number, email, user_name, password) VALUES ('Matt Chen', '11/22/1956', '585 New Drive', '614-555-5757', 'matt@hotmail.com', 'Mchen','12345ABCDE');
INSERT INTO patient (name, date_of_birth, address, phone_number, email, user_name, password) VALUES ('Jackie Chan', '02/22/1980', '56432 Remember Road', '614-555-9444', 'jackiechan@gmail.com', 'Jchan','12345ABCDE');
INSERT INTO patient (name, date_of_birth, address, phone_number, email, user_name, password) VALUES ('Michael Jordan', '08/05/1970', '58999 Basketball Road', '614-555-6868', 'mj@aol.com', 'Mjordan','12345ABCDE');
INSERT INTO patient (name, date_of_birth, address, phone_number, email, user_name, password) VALUES ('Sue Moose', '05/04/1990', '600 Foreign Drive', '614-555-5533', 'sue@gmail.com', 'Smoose','12345ABCDE');
INSERT INTO patient (name, date_of_birth, address, phone_number, email, user_name, password) VALUES ('Martha Stewart', '03/02/1970', '520 Prison Road', '614-555-6765', 'martha@yahoo.com', 'Mstewart','12345ABCDE');

INSERT INTO review (rating, doctor_id, message) VALUES (5, 1, 'Outstanding bed-side presence. Could not recommend enough');
INSERT INTO review (rating, doctor_id, message) VALUES (4, 1, 'Very busy, but worth the wait');
INSERT INTO review (rating, doctor_id, message) VALUES (1, 2, 'Always feel like one foot is out the door when we are together. I think retirement is near.');
INSERT INTO review (rating, doctor_id, message) VALUES (4, 3, 'When I was very ill I felt like all my needs were met.');
INSERT INTO review (rating, doctor_id, message) VALUES (3, 4, 'Surprised by the service. Usually expect more from this office');
INSERT INTO review (rating, doctor_id, message) VALUES (5, 5, 'Have nothing but good things to say');
INSERT INTO review (rating, doctor_id, message) VALUES (5, 6, 'So very kind and attentive');
INSERT INTO review (rating, doctor_id, message) VALUES (2, 7, 'I will be going elsewhere next time');
INSERT INTO review (rating, doctor_id, message) VALUES (4, 8, 'Always pleasant, but sometimes a bit late');
INSERT INTO review (rating, doctor_id, message) VALUES (5, 9, 'So very pleased');
INSERT INTO review (rating, doctor_id, message) VALUES (2, 10, 'I expect more from this office. I will be taking my business elsewhere');
INSERT INTO review (rating, doctor_id, message) VALUES (5, 11, 'Very professional and understanding');
INSERT INTO review (rating, doctor_id, message) VALUES (1, 12, 'Could not be bothered with my issues');
INSERT INTO review (rating, doctor_id, message) VALUES (5, 1, 'I always enjoy coming here...even if I am sick');
INSERT INTO review (rating, doctor_id, message) VALUES (4, 1, 'Thumbs up');
INSERT INTO review (rating, doctor_id, message) VALUES (1, 2, 'F- performance');
INSERT INTO review (rating, doctor_id, message) VALUES (4, 3, 'Solid doctor. Will keep coming back');
INSERT INTO review (rating, doctor_id, message) VALUES (3, 4, 'Meh, kind of a C performer');
INSERT INTO review (rating, doctor_id, message) VALUES (5, 5, 'A++++++');
INSERT INTO review (rating, doctor_id, message) VALUES (5, 6, 'Genuine and kind');
INSERT INTO review (rating, doctor_id, message) VALUES (2, 7, 'Why even bother showing up for work if you are not going to help me?');
INSERT INTO review (rating, doctor_id, message) VALUES (4, 8, 'This office and their doctors are always nice and helpful');
INSERT INTO review (rating, doctor_id, message) VALUES (5, 9, 'Cannot recommend enough');
INSERT INTO review (rating, doctor_id, message) VALUES (2, 10, 'Very poor bedside manners');
INSERT INTO review (rating, doctor_id, message) VALUES (5, 11, 'Does not get any better than this!');
INSERT INTO review (rating, doctor_id, message) VALUES (1, 12, 'After being late for the 3rd time, I think I will just go elsewhere');

INSERT INTO appointment (doctor_id, patient_id, start_date, end_date, message) VALUES (1, 1, '2017-04-13T8:00', '2017-04-13T8:30', 'My finger hurts');
INSERT INTO appointment (doctor_id, patient_id, start_date, end_date, message) VALUES (1, 2, '2017-04-13T8:30', '2017-04-13T9:00', 'My finger hurts2');
INSERT INTO appointment (doctor_id, patient_id, start_date, end_date, message) VALUES (1, 3, '2017-04-13T9:00', '2017-04-13T9:30', 'My finger hurts3');
INSERT INTO appointment (doctor_id, patient_id, start_date, end_date, message) VALUES (1, 4, '2017-04-13T9:30', '2017-04-13T10:00', 'My finger hurts4');
INSERT INTO appointment (doctor_id, patient_id, start_date, end_date, message) VALUES (1, 5, '2017-04-13T10:00', '2017-04-13T10:30', 'My finger hurts5');
INSERT INTO appointment (doctor_id, patient_id, start_date, end_date, message) VALUES (1, 6, '2017-04-13T10:30', '2017-04-13T11:00', 'My finger hurts6');
INSERT INTO appointment (doctor_id, patient_id, start_date, end_date, message) VALUES (1, 7, '2017-04-13T14:30', '2017-04-13T15:00', 'My finger hurts6');
INSERT INTO appointment (doctor_id, patient_id, start_date, end_date, message) VALUES (1, 7, '2017-04-13T15:30', '2017-04-13T16:00', 'My finger hurts6');
INSERT INTO appointment (doctor_id, patient_id, start_date, end_date, message) VALUES (1, 7, '2017-04-13T11:30', '2017-04-13T12:00', 'My finger hurts6');

COMMIT;