CREATE TABLE DISTRICT (
	zipcode INTEGER(5) not null,
	state varchar(2) not null,
	district INTEGER(2) not null
) AS SELECT * FROM CSVREAD('src/main/resources/data/districts.csv');
