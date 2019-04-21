INSERT INTO HOTEL (name, city, hotel_rating) VALUES('Marriot', 'London', 5);
INSERT INTO HOTEL (name, city, hotel_rating) VALUES('Hayat', 'Paris', 4);
INSERT INTO HOTEL (name, city, hotel_rating) VALUES('Hilton', 'London', 5);

INSERT INTO ROOM (number, category, price, meals_type, meal_price, cleaning_price, hotel_id) VALUES (1, 'SUITE', 150, 'BREAKFAST', 100, null, 2);
INSERT INTO ROOM (number, category, price, meals_type, meal_price, cleaning_price, hotel_id) VALUES (1, 'BUSINESS', 350, 'BREAKFAST_DINNER', 100, 50, 1);
INSERT INTO ROOM (number, category, price, meals_type, meal_price, cleaning_price, hotel_id) VALUES (2, 'BUSINESS', 350, 'BREAKFAST', 100, 50, 1);
INSERT INTO ROOM (number, category, price, meals_type, meal_price, cleaning_price, hotel_id) VALUES (1, 'SUITE', 150, 'BREAKFAST', 100, 50, 3);
INSERT INTO ROOM (number, category, price, meals_type, meal_price, cleaning_price, hotel_id) VALUES (2, 'APARTMENT', 500, 'BREAKFAST', 100, 50, 2);
INSERT INTO ROOM (number, category, price, meals_type, meal_price, cleaning_price, hotel_id) VALUES (3, 'SUITE', 250, 'BREAKFAST', 100, null, 1);
INSERT INTO ROOM (number, category, price, meals_type, meal_price, cleaning_price, hotel_id) VALUES (2, 'APARTMENT', 500, 'BREAKFAST_DINNER', 100, 100, 3);
INSERT INTO ROOM (number, category, price, meals_type, meal_price, cleaning_price, hotel_id) VALUES (3, 'PRESIDENT', 1000, 'BREAKFAST_DINNER', 100, 200, 2);
INSERT INTO ROOM (number, category, price, meals_type, meal_price, cleaning_price, hotel_id) VALUES (3, 'PRESIDENT', 1000, 'BREAKFAST_DINNER', 100, 200, 3);

INSERT INTO USER (name, email, role) VALUES ('user1', 'user1@gmail.com', 'USER');
INSERT INTO USER (name, email, role) VALUES ('user2', 'user2@gmail.com', 'USER');
INSERT INTO USER (name, email, role) VALUES ('user3', 'user3@gmail.com', 'USER');

INSERT INTO user_account (user_id) VALUES (1);
INSERT INTO user_account (user_id) VALUES (2);
INSERT INTO user_account (user_id) VALUES (3);

INSERT INTO BOOKING (user_account_id, room_id, arrival, departure, total_price) VALUES (1, 2, '2019-10-25', '2019-10-30', 500);
INSERT INTO BOOKING (user_account_id, room_id, arrival, departure, total_price) VALUES (2, 1, '2019-09-25', '2019-09-30', 250);
INSERT INTO BOOKING (user_account_id, room_id, arrival, departure, total_price) VALUES (2, 1, '2019-11-15', '2019-11-25', 250);
INSERT INTO BOOKING (user_account_id, room_id, arrival, departure, total_price) VALUES (3, 1, '2019-11-10', '2019-11-14', 250);
INSERT INTO BOOKING (user_account_id, room_id, arrival, departure, total_price) VALUES (1, 9, '2019-09-11', '2019-09-24', 1300);
