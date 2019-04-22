# Hotel Booking

[![Booking](http://localhost:8081/api)](http://localhost:8081/api)

#### Test Project for FoxmindEd

REST application Hotel booking

Endpoints:
 1. View list of available rooms (room have a number, category, price, additional options like
 breakfast, cleaning with additional cost) for specified dates.
 2. View rooms filtered by category.
 3. Create user.
 4. User can book the room for specified days.
 5. User can view his booking.
 6. User can get the total price of the booking (room for dates period + cost of additional options).
 7. View all bookings for the hotel.
 
The application use next frameworks and technologies: 
 - Spring Boot; 
 - ORM - Spring data JPA, Hibernate; 
 - DB - H2; 
 - Testing - Junit, Mockito, Spring, H2; 
 - Building - Apache Maven.
 Authentication and authorization are not included in the application.
 
 DB is initialised with two ways: with data.sql file and with /com/bookinghotel/utils/FillingDB.java file (@PostConstruct):
 creates 5 UserAccounts, 6 Hotels, 18 Rooms, 10 Bookings
 
 To run application, checkout it using the web URL https://github.com/MarynaKontar/booking-hotel.git, 
 run it on http://localhost:8081/api and test with Postman (in src/main/resources there is booking-postman_collection.json that you can import to Postman)

UML diagram is in src/main/resources/uml.png