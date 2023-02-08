# hotelreservation

# Design a hotel reservation system

# Status:
Docker image creation and run the service
Fix sql join statements - done
Handle race condition ( integrate redis )


# Functional requirements
Users can find rooms availability by city and room type.
Users can book a room
System should support concurrency ( more than 2 users can book same room )
Users can give ratings/reviews
Users can select reviews of a hotel

# Non functional requirements
Highly available
Highly scalable
High concurrancy
Consistent 

#API
/hotel/by-city 
{
	city, from, to, typeOfroom
} 

#HLD
	In progress


# SQL tables

create database hotelreservationsystem;
show databases;
use  hotelreservationsystem;

CREATE TABLE hotels (
	hotel_id INT NOT NULL PRIMARY KEY,
	hotel_name TEXT NOT NULL,
	hotel_address_line TEXT NOT NULL,
    hotel_city TEXT NOT NULL,
    hotel_state TEXT NOT NULL,
    hotel_country TEXT NOT NULL,
    hotel_pincode INT NOT NULL
);

INSERT INTO hotels VALUES (0, 'taj banjara', 'road no 1', 'hyderabad', 'telangana', 'INDIA', 500019)
INSERT INTO hotels VALUES (1, 'grand kakateeya', 'begumpet', 'hyderabad', 'telangana', 'INDIA', 500032)
INSERT INTO hotels VALUES (2, 'leela palace', 'white field', 'bangalore', 'karnataka', 'INDIA', 500027)

CREATE TABLE guests (
	guest_id INT NOT NULL PRIMARY KEY,
	guest_name TEXT NOT NULL,
	guest_address_line TEXT NOT NULL,
	guest_phone_number TEXT NOT NULL
);

INSERT INTO `guests` VALUES (0, ‘narendra’, ‘aparnacyberzon, hyderebad’,’97414XXXXX’);
INSERT INTO `guests` VALUES (1, ‘anitha’, ‘aparna saroval, hyderebad’, ‘97414YYYYY’);
INSERT INTO `guests` VALUES (2, ‘satya’, ‘my home villas hyderebad’, ‘97414ZZZZZ’);

CREATE TABLE room_types (
	room_type_id INT NOT NULL PRIMARY KEY,
	room_type TEXT NOT NULL
);

INSERT INTO `room_types` VALUES (0, `single`)
INSERT INTO `room_types` VALUES (1, `double`)
INSERT INTO `room_types` VALUES (2, `triple`)

CREATE TABLE rooms (
	room_id INT NOT NULL PRIMARY KEY,
	room_number int NOT NULL,
	room_name TEXT,
	hotel_id INT,
	room_type_id INT,
	FOREIGN KEY (hotel_id)
		REFERENCES hotels(hotel_id),
	FOREIGN KEY (room_type_id)
		REFERENCES room_types(room_type_id)
);

/*2 single in taj */
INSERT INTO `rooms` VALUES(0, 1, `taj-single-1`, 0, 0);
INSERT INTO `rooms` VALUES(1, 2, `taj-single-2`, 0, 0);

/*1 double in taj */
INSERT INTO `rooms` VALUES(2, 3, `raj-double-1`, 0, 1);

/*1 triple in taj */
INSERT INTO rooms VALUES(3, 4, `taj-triple-1`, 0, 2);

/*1 single in grand kakateeya  */
INSERT INTO `rooms` VALUES(4, 1, `grand-single-1`, 1, 0);

/*1 double in grand kakateeya  */
INSERT INTO `rooms` VALUES(5, 3, `grand-double-1`, 1, 1);

/*1 triple in grand kakateeya  */
INSERT INTO `rooms` VALUES(6, 4, `grand kakateeya-triple-1`, 1, 2);

/*1 triple in leela palace */
INSERT INTO `rooms` VALUES(7, 4, `leela palace-single-1`, 2, 3);


CREATE TABLE reservations (
	reservation_id INT NOT NULL PRIMARY KEY,
	reservation_time TIME NOT NULL,
	in_date DATETIME NOT NULL,
	out_date DATETIME NOT NULL,
	room_id INT,
	guest_id INT,
	FOREIGN KEY (room_id)
		REFERENCES rooms(room_id),
	FOREIGN KEY (guest_id)
		REFERENCES guests(guest_id)
);


INSERT INTO `hotels` VALUES (0, 'taj banjara', 'road no 1', 'hyderabad' , 'telangana' , 'INDIA' , 500019);
INSERT INTO `hotels` VALUES (1, 'grand kakateeya', 'begumpet', 'hyderabad' , 'telangana' , 'INDIA' , 500032);
INSERT INTO `hotels` VALUES (2, 'leela palace', 'white field', 'bangalore' , 'karnataka' , 'INDIA' , 500027);



/*available rooms in a city*/
got room id's need to search in resevations

SELECT room_id FROM rooms INNER JOIN  hotels ON rooms.hotel_id = hotels.hotel_id WHERE hotel_city = 'hyderebad'


SELECT * FROM rooms 
INNER JOIN  hotels ON rooms.hotel_id = hotels.hotel_id
INNER JOIN room_types ON room_types.room_type_id = rooms.room_type_id
WHERE hotel_city = 'hyderabad'
and room_types.room_type = 'single'
and rooms.room_id not in (select room_id from reservations 
     where  reservations.in_date between '2023-02-05 11:00:00' and '2023-02-06 11:00:00'
     or reservations.out_date between '2023-02-04 16:21:00' and '2023-02-04 16:21:00'
     or (reservations.in_date < '2023-02-04 16:21:00' and reservations.out_date>'2023-02-04 16:21:00'));


