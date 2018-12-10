CREATE database IF NOT exists Bookings;

USE Bookings;


DROP TABLE IF exists Booking;


CREATE TABLE Booking (
	bId int NOT NULL,
	cId int NOT NULL,
	rNo varchar(30) NOT NULL,
	bookingdate Date NOT NULL,
    bookingEndDate Date NOT NULL,
	PRIMARY KEY (bId)
	
);

INSERT INTO booking VALUES (1, 1, '22-E-2000', '2011-01-31', '2012-03-5');


INSERT INTO booking VALUES (2, 2, '12-H-1997', '2008-04-31', '2009-10-22');


INSERT INTO booking VALUES (3, 3, '64-S-2008', '2010-06-31', '2016-05-12');


INSERT INTO booking VALUES (4, 4, '45-P-1999', '2014-02-31', '2016-01-30');

Select * from booking;