/* DELETE 'EasyBooking' database*/
DROP SCHEMA EasyBooking;
/* DELETE USER 'user' AT LOCAL SERVER*/
DROP USER 'user'@'%';

/* CREATE ''EasyBooking' DATABASE */
CREATE SCHEMA EasyBooking;
/* CREATE THE USER 'user' AT LOCAL SERVER WITH PASSWORD 'user' */
CREATE USER 'user'@'%' IDENTIFIED BY 'user';
/* GRANT FULL ACCESS TO THE DATABASE FOR THE USER 'user' AT LOCAL SERVER*/
GRANT ALL ON EasyBooking.* TO 'user'@'%';