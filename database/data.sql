-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

-- INSERT statements go here

INSERT INTO office (address, phone_number, image_name, hours, name) VALUES ('1234 Memory Lane Columbus, OH 43228', '614-555-1234', 'office1', '8:00AM - 6:00PM', 'North Office');
INSERT INTO office (address, phone_number, image_name, hours, name) VALUES ('124 Super Road Columbus, OH 43228', '614-555-1534', 'office2', '7:00AM - 5:00PM', 'South Office');
INSERT INTO office (address, phone_number, image_name, hours, name) VALUES ('1555 Awesome Drive Columbus, OH 43228', '614-555-1444', 'office3', '8:00AM - 9:00PM', 'West Office');
INSERT INTO office (address, phone_number, image_name, hours, name) VALUES ('125 Epic Valley Columbus, OH 43228', '614-555-2444', 'office4', '7:00AM - 6:00PM', 'East Office');

INSERT INTO doctor (name, office_id, fee, start_time, end_time, admin, user_name, password, email, salt) VALUES ('Dr. John', 1, '$50', '8:00', '17:00', false, 'Drjohn','JdJ+dg7r+HYcI3uYVoUVsQ==', 'laura@neutralspace.org', '59TFbOCNVF2OT/0Ofhx2J6ZcRiI6zGvLeoz5UQUJPEoIJ8yX8UwR0vL5biuie2Iv6JWR/G6I0yfWqa/rdkpOtLhnctuyvoBmBoFE5Be2TqwXMU8fqbnNsOXHOrGh6e3hH7mbmGWlxmbFNRF0xN14pLqNGjDvt7EFuFuEL07rO3Y=');
INSERT INTO doctor (name, office_id, fee, start_time, end_time, admin, user_name, password, email, salt) VALUES ('Dr. Admin', 1, '$55', '8:00', '17:30', true, 'Dradmin','2Ea0SsaX3L9w31UKhXIFJQ==', 'laura@neutralspace.org', 'tSrBR+Oh7Z87sN5Lux3SoYQzei9xc7WOvXo1Hk5Wpo0rla7w30AClrHWgJNE4HrSDG/RM3Ttgkr+nhLXsr97I9Ya94kgqWjtN9lAd6lu1qtAtnDYoyh2AUn6QefR54iajnG+UCn7+gwYrHgtx3u6OhPyyx4X++9iScFpN9n3wJ4=');
INSERT INTO doctor (name, office_id, fee, start_time, end_time, admin, user_name, password, email, salt) VALUES ('Dr. Cool', 1, '$65', '9:00',  '16:00', false, 'Drcool','0JwD+VqgnwD+B/wCf7koZA==', 'laura@neutralspace.org', 'So+RfSkiyzjrqsB7WyMVxx2M5AA66SPvp0HXvV3yzdbdOBCsNYVN7OSrJ7KbV3KMMwlLx73S/lXdNlyh3oK98JjqfTWBK0EOj5lB2mIVBYQFCNJqxj0ob/PpJTHA7H6wTxM0w/TIGgv+Pi2V0bBtGU7ydYlMkqg7A5vdqUSaGGc=');
INSERT INTO doctor (name, office_id, fee, start_time, end_time, admin, user_name, password, email, salt) VALUES ('Dr. Smith', 2, '$50', '9:00', '17:00', true, 'Drsmith','SIAQyPW4AaPFtBZUXhuoXA==', 'laura@neutralspace.org', '6blU6XFjVYcVpfzBecmnZ6iVogA5c2ijTyz2t4Iy/UGXKqRme76Jb2uTJazLYD4TPBjJ+DmiWhG7RVKnj98fxKONHCFUcow7A80P2C7jv7PsbceZxbRdtbdiiv9lveVt2hnp9jimIM5u4NqTr5k6Yz/lA3xjT/MiS6owFthFZnI=');
INSERT INTO doctor (name, office_id, fee, start_time, end_time, admin, user_name, password, email, salt) VALUES ('Dr. Low', 2, '$50', '7:00', '15:00', false, 'Drlow','EBuM/qidQtfaiMX/LC3dZg==', 'laura@neutralspace.org', 'IsRJ6sbEPwpD1fpCXyZQH7mpCmq9BkNcitpTt9jNcKZXQfesPZQIZi6k0Yu/2orizuBTObbZoGv0CYe4pGmV//V/RzAyz3adxwulIRbLKfQjPeWG4UGIQKG9tx+7fGBC0dMLGW70pPjNsBKuWuXYSmX9ORgyEH0I3hoBaxuVp2U=');
INSERT INTO doctor (name, office_id, fee, start_time, end_time, admin, user_name, password, email, salt) VALUES ('Dr. High', 2, '$60', '9:00', '17:00', false, 'Drhigh','mLz9dAXsDpFyImkLys0xgQ==', 'laura@neutralspace.org','xoXx8THHFeGCrmQWfwbFSr8PgmqQjAdQS9jAFz3RJneQhrT+9Vmr2EjNQIp1H4iKsCUPdzCnzQuvNl+jLf3RdA/K35oav91Yncly5dikPGRlvUQK8T9fYgcf3t0lMkqxboeJuh4cDkFHue8C5iIJ6lJ1HmD5lm8SaBU6BRD+vGM=');
INSERT INTO doctor (name, office_id, fee, start_time, end_time, admin, user_name, password, email, salt) VALUES ('Dr. Joe', 3, '$40', '11:00', '21:00', false, 'Drjoe','KSqcJyO00k3mKrltRHifdw==', 'laura@neutralspace.org','EmswGadBnEXKCrisGMadpP7kwJI1KSUdGmRSEFtth6o8t/csGNL0lJK4na13eJRKGA8h9jWXRI6km+zORG9DkQ7PJRbzEjQGgsKKN9U/tgIaLAXyoGV+iY/Vuq2GvvkWMdVH/xpFjKl6aEiyqvJ1n4sIAYo+vivItBIsqpqkIso=');
INSERT INTO doctor (name, office_id, fee, start_time, end_time, admin, user_name, password, email, salt) VALUES ('Dr. Ben', 3, '$50', '9:00', '17:00', true, 'Drben','bjpcT6RBbPSssfnRNGe8iQ==', 'laura@neutralspace.org', 'Rc8kBEZ8iWX4KQC2UhFaZC6Bjyzscf6BDDIl+9bvNKLhyINvpMf/SEzteILNz6gMla5U7LMHoj0TUFXlOy/Vvb11udy5UJ/HnwHdk8x4q3blAHPuZpTMRd0UMT/AwUx7b2pI+j6cwskRsXFRRIc76JAxuKIyNByxwkwIrObd8GA=');
INSERT INTO doctor (name, office_id, fee, start_time, end_time, admin, user_name, password, email, salt) VALUES ('Dr. Yu', 3, '$60', '8:00', '16:00', false, 'Dryu','bqAyAxOjSIuWKNxVY0k93g==', 'laura@neutralspace.org', 'DwLAhWQ+7a7Nzw7zuXLdAsYkZIa/02yWk+IYVD+y68AW1ZVkLeor/y17d1O3m0/n59s+CPYUWhQSLVrAW4eekFOJ3jCpJDmG0OPqJri0DbzfXpVwTtQH9aFNyk5F0ZPjeR5WHZUAJx+H119zYTb5v5x24GDjbTJVur+VeyFgUpU=');
INSERT INTO doctor (name, office_id, fee, start_time, end_time, admin, user_name, password, email, salt) VALUES ('Dr. Chen', 4, '$50', '9:00','17:00', false, 'Drchen','ZFlE4xhg/N3sYN6MBfNzKQ==', 'laura@neutralspace.org', 'dtpHxsvZ3zl19OSDBETGND80Gtuqi/tIThOJS0ZyMWUXrru4Yp7SByNXQYMbHAM0QRy5yzAICZ46psYL3RyDQkoz8x247xXgi3RFX/pWRpXMBD40xKjFdxJVsk4j95XQ8Mvt5y6FUdPQk5jozxo4hCMN0yqj9EGZpE8CwrwJdvA=');
INSERT INTO doctor (name, office_id, fee, start_time, end_time, admin, user_name, password, email, salt) VALUES ('Dr. Lu', 4, '$75', '7:00', '15:00', true, 'Drlu','u+PZh35q/N19K8i5WyWIKw==', 'laura@neutralspace.org', 'CARJCB2LwJbu0cns3ikc4slf8ugblOrRdv3msGxJZu8OmkL3T4c2BN4rIFyTjtrKr40Z8ALDQyVG98Jas6uds8ZFX7rTWT48TgWb8Wous6dinKqNDs7ArRCufvtx3i070PobQS7vGhwTPizCHfa73p6YbXqn/wkEjtvmBaLSLBo=');
INSERT INTO doctor (name, office_id, fee, start_time, end_time, admin, user_name, password, email, salt) VALUES ('Dr. Pent', 4, '$80', '9:00','18:00', false, 'Drpent','hzyqUMGQDbyFqba4pOgsAA==', 'laura@neutralspace.org', 'tW7p1qP0/mrP1vXRQh4nJDiUMrnkJsByr2CuF+fYjGcJaq2Uk7vcFKJmxCA7GnFJorrOTg6d1iZJ9pbL/1Rr6NKedhIx/rwhAW3QEZVvN7YWd47Br/13mOMkDfF9x4NH9Net1UE6s/q/Gwm7e0xzMoU89Oi42uXsiAzgeLSREt4=');


INSERT INTO patient (name, date_of_birth, address, phone_number, email, user_name, password, salt) VALUES ('Matt Kress', '04/04/1994', '585 Nowhere Dr.', '614-555-4567', 'mkress@crimson.ua.edu', 'Mkress','WixSE3hzHCrhXB6Q0avm3A==', 'LaOCQSfGxyuCmSRu/OGuGJQ2or3On9ccTwGoGQdtybwGrv6LyMxYFW1nb9ynioIWs7WYkfSnk8y/0EPU5WJ1aHMKeAgrJXJJAg6+Abdl6kZjAnaSHa7wjzTZAyZtCaBgbEbpWmpg/k3VWqBzps0hzmzlX+0Pp6GLa3WzbXwEV+4=');
INSERT INTO patient (name, date_of_birth, address, phone_number, email, user_name, password, salt) VALUES ('Josh Hanf', '05/23/1986', '678 Cool Road', '614-555-4555', 'jhanf05@gmail.com', 'Jhanf','M6WJHPjaVBVu1Oe2yG7SuQ==', 'Uw3lH2p60BSDzPeKeGBj4sGDSljjj3iIORnIlZcbCn5qlP5KeZM6FMwScyb9CN01rDc5bh0vLllb/lWkS4OS1kKdvC/mg8hf5LWxuANv4CymztzUEIbI6Wkcuskk/iMdGBzfLXR9FggQWw4W9/0cAlVpdPxjCbIYlajPzlqrcVs=');
INSERT INTO patient (name, date_of_birth, address, phone_number, email, user_name, password, salt) VALUES ('Laura Stephens', '04/20/1982', '633 Number Road', '614-555-5643', 'lauracomstockstephens@gmail.com', 'Lstephens','STPHaAhbx/Gh0XEh7dSUpg==', 'Bt6tyZa04JPbgmMuNyF6kTv5TMjgElhUs9luPIdWg54m1tyXYh5bYGtZBAhVoLXw0e/ZgGcUJge9DnO9d9F8rJFj2cbz/03MiCAA4IDa9ZMQi9YOMFxAvyeWglITUIo0Zu1HTVwlwDVZjxUx8rr4Ok0YjheKLZ1r2EmD2ccWxD8=');
INSERT INTO patient (name, date_of_birth, address, phone_number, email, user_name, password, salt) VALUES ('Casey Borders', '04/05/1992', '600 Hidden Valley', '614-555-9999', 'casey@techelevator.com', 'Cborders','BrfnK93GZszI9jXeDAZxFg==', '/SvKtfat0cEve/GTfZuzxrM6K2Pq9JLNpTZGMYMfch6U77fapowEk10vMSQcFXn1I803yiIfpCc5v92nKoMO3r43DDbO91YuV08O0a+VM8F2GrNQ2sdIhytFHQ1Zzlcq4GIQNLxiWOprqPsTNpKUg2fiYMyOX+00EukRxo1vzXM=');
INSERT INTO patient (name, date_of_birth, address, phone_number, email, user_name, password, salt) VALUES ('Joe Schmoe', '12/25/2000', '500 Nightmare Lane', '614-555-9898', 'lauracomstockstephens@gmail.com', 'Jschmoe','eIDBXA7mNcWuj2NbX1zWYw==', 'u3yzBe8OdrdaEofK4q/pqqgtdRsqbFsXfowK9HPvs6gRwubHKdHSZ7kC7RR6DS6XDw2pyUVHINkiwcDyPZDAqP2RG+A3dElEg1R7GKlpDxchEmh5/PR4o/ImQTn67s+Fnmv3eQLfmT9VT0F8g5a5Wicor6/9c9nGmHzYUhApXfg=');
INSERT INTO patient (name, date_of_birth, address, phone_number, email, user_name, password, salt) VALUES ('Matt Chen', '11/22/1956', '585 New Drive', '614-555-5757', 'lauracomstockstephens@gmail.com', 'Mchen','EsQFUIYqdc3E4JD9ISLVtw==', 'OmLE6SKCHi/rf706DqawoKf2AkARbIVVHYqyDvqOL+I4XRlN7oN4AonsrjdrGdxtTbDRpqF/GGFeGs1ICJV/0wMu43MP79LSdTdYjH13D9PC9xrqF4ua1nFVVVyHizVqT3dn9SMPuMluARlDa9oNe6BX4iJdDN8IfRxCymbUH2U=');
INSERT INTO patient (name, date_of_birth, address, phone_number, email, user_name, password, salt) VALUES ('Jackie Chan', '02/22/1980', '56432 Remember Road', '614-555-9444', 'lauracomstockstephens@gmail.com', 'Jchan','ZpcD/BKPtaZom99k0pLlkg==', 'wO1MZ6q5e228dyJcY6A8g4jybFQY1OmlwseMF1FG3GvltdCV3FanPMtW1YVz1evF4lm3Ig3iRk9gvZBKadzSgZ9jvQ2yviHfEg+7tTrNv1ld2NAraejDpZ9Z8vURgo+VL6RYCVi/YAytpZnLl4kQN/xch5K0QZi445kFIzyY9kE=');
INSERT INTO patient (name, date_of_birth, address, phone_number, email, user_name, password, salt) VALUES ('Michael Jordan', '08/05/1970', '58999 Basketball Road', '614-555-6868', 'lauracomstockstephens@gmail.com', 'Mjordan','cUEOyjbecGr1sKi37piu4w==', '3YSC/B6uvR+OdOK7oFGHlc3iixncbR80uFO6hWOjA8SqQqPO9sB676B5qT761Q9RHIub7CI9Q6Ra433CwhxERQJIImgpuKut9OXpYg4OFepxuL3GHppmN7KrrjKVvwuIsiWn9inWbkTCMiNbCMjvsd1srth7sjdvceJu8RGSyv0=');
INSERT INTO patient (name, date_of_birth, address, phone_number, email, user_name, password, salt) VALUES ('Sue Moose', '05/04/1990', '600 Foreign Drive', '614-555-5533', 'lauracomstockstephens@gmail.com', 'Smoose','M7CD4i17yiQZrSBN6+5cNQ==', 'K0Ks3lwVHPZlyOhL6tCGftXckFgi15bkP7MB9Q0dhaJRBrNxdGKRHNwMu/H1h6Z6c9vDH+WnbydL4yQsX+DBadleQ8FqPIdBGqEKaMGlsjaKS9i0rzIZ+7NFkDu79zcztxMXaMrHmfjAE0eCCaaefcTvdLumKfNO8xISCf+yofg=');
INSERT INTO patient (name, date_of_birth, address, phone_number, email, user_name, password, salt) VALUES ('Martha Stewart', '03/02/1970', '520 Prison Road', '614-555-6765', 'lauracomstockstephens@gmail.com', 'Mstewart','I/nnOi89T9fM4WPAGu37zQ==', '7VYNJvvkmancai8wDUxMX5i2lWNLFyRuonO5zUaFEe+CH5u2IidtAU0enx5fQ5FvKmo/LoArC8u/XN2v73ReXTcfwDvV+VRwXMUrlpdqW/9V63wU4ZEZem9qkGbWKFysjiy/o3S/ouEhexACMCI6QjJre8lW04sOrAQxh9j85cI=');
INSERT INTO patient (id, name, date_of_birth, address, phone_number, email, user_name, password, salt) VALUES ('-1','Doctor Note', '04/04/1994', 'test', '614-555-4567', 'lauracomstockstephens@gmail.com', 'tes','Z8qC2rpT7uo5tCovYZfoag==', 'UttbP35D94ayvJa7+OLa+Sh+9wk2w6JDoky6hQ0tuJ/ku/DulEBl6QTR1NQv0YFK+XaPVIeZkKFjIMs7reOVA05ul4RZFrCm93hb+Oqsb9WEZTpWY72WWE484kkvrwmbxn9Otl8IwGuq4N8ATT3wTknsDU+syRTt/UCxdng6QWQ=');


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
INSERT INTO appointment (doctor_id, patient_id, start_date, end_date, message) VALUES (1, 1, '2017-04-20T8:00', '2017-04-20T8:30', 'HAPPY BIRTHDAY LAURA!!');
INSERT INTO appointment (doctor_id, patient_id, start_date, end_date, message) VALUES (1, 5, '2017-04-13T10:00', '2017-04-13T10:30', 'My finger hurts5');
INSERT INTO appointment (doctor_id, patient_id, start_date, end_date, message) VALUES (1, 6, '2017-04-13T10:30', '2017-04-13T11:00', 'My finger hurts6');
INSERT INTO appointment (doctor_id, patient_id, start_date, end_date, message) VALUES (1, 7, '2017-04-13T14:30', '2017-04-13T15:00', 'My finger hurts6');
INSERT INTO appointment (doctor_id, patient_id, start_date, end_date, message) VALUES (1, 7, '2017-04-13T15:30', '2017-04-13T16:00', 'My finger hurts6');
INSERT INTO appointment (doctor_id, patient_id, start_date, end_date, message) VALUES (1, 7, '2017-04-13T11:30', '2017-04-13T12:00', 'My finger hurts6');
INSERT INTO appointment (doctor_id, patient_id, start_date, end_date, message) VALUES (2, 1, '2017-04-13T8:00', '2017-04-13T8:30', 'My finger hurts');

COMMIT;