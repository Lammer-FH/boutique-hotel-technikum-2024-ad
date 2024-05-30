ALTER TABLE boutique_hotel_technikum.Room AUTO_INCREMENT = 0;
ALTER TABLE boutique_hotel_technikum.Extra AUTO_INCREMENT = 0;

INSERT INTO boutique_hotel_technikum.Room (imagePath, title, description, price) VALUES ('0.jpg', 'Room 1', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.', 50);
INSERT INTO boutique_hotel_technikum.Room (imagePath, title, description, price) VALUES ('1.jpg', 'Room 2', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.', 65);
INSERT INTO boutique_hotel_technikum.Room (imagePath, title, description, price) VALUES ('2.jpg', 'Room 3', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.', 45);

INSERT INTO boutique_hotel_technikum.Extra (name) VALUES ('Air conditioning');
INSERT INTO boutique_hotel_technikum.Extra (name) VALUES ('Free WiFi');
INSERT INTO boutique_hotel_technikum.Extra (name) VALUES ('Balcony');
INSERT INTO boutique_hotel_technikum.Extra (name) VALUES ('Flat-screen TV');

INSERT INTO boutique_hotel_technikum.Room_has_Extra (room_idRoom, extra_idExtra) VALUES (1, 1);
INSERT INTO boutique_hotel_technikum.Room_has_Extra (room_idRoom, extra_idExtra) VALUES (2, 1);
INSERT INTO boutique_hotel_technikum.Room_has_Extra (room_idRoom, extra_idExtra) VALUES (1, 2);
INSERT INTO boutique_hotel_technikum.Room_has_Extra (room_idRoom, extra_idExtra) VALUES (2, 2);
INSERT INTO boutique_hotel_technikum.Room_has_Extra (room_idRoom, extra_idExtra) VALUES (3, 2);
INSERT INTO boutique_hotel_technikum.Room_has_Extra (room_idRoom, extra_idExtra) VALUES (3, 3);
INSERT INTO boutique_hotel_technikum.Room_has_Extra (room_idRoom, extra_idExtra) VALUES (3, 4);
