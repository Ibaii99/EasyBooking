/* DELETE 'accountsDB' database*/
DROP SCHEMA accountsDB;
/* DELETE USER 'sd' AT LOCAL SERVER*/
DROP USER 'accounts_user'@'%';

/* CREATE ''accountsDB' DATABASE */
CREATE SCHEMA EasyBooking;
/* CREATE THE USER 'accounts_user' AT LOCAL SERVER WITH PASSWORD 'password' */
CREATE USER 'user'@'%' IDENTIFIED BY 'user';
/* GRANT FULL ACCESS TO THE DATABASE FOR THE USER 'accounts_user' AT LOCAL SERVER*/
GRANT ALL ON EasyBooking.* TO 'user'@'%';