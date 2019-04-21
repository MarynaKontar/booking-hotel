package com.bookinghotel.service.impl;

import com.bookinghotel.model.entity.Booking;
import com.bookinghotel.model.entity.Room;
import com.bookinghotel.model.entity.UserAccount;
import com.bookinghotel.repository.BookingRepository;
import com.bookinghotel.service.BookingService;
import com.bookinghotel.service.RoomService;
import com.bookinghotel.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final UserAccountService userAccountService;
    private final RoomService roomService;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, UserAccountService userAccountService, RoomService roomService) {
        this.bookingRepository = bookingRepository;
        this.userAccountService = userAccountService;
        this.roomService = roomService;
    }

    @Override
    @Transactional
    public Booking add(Booking booking, UserAccount userAccount) {
        userAccount = userAccountService.findById(userAccount.getId());
        Room room = roomService.findById(booking.getRoom().getId());
        validateIfCanBeBooking(booking);
        booking.setRoom(room);
        userAccount.addBooking(booking);
        booking.setUserAccount(userAccount);
        booking.setTotalPrice(getTotalPrice(booking));
        return bookingRepository.save(booking);
    }

    @Override
    public Booking findById(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("booking not found " + id));
    }

    private void validateIfCanBeBooking(Booking booking) {
        List<Booking> bookings = bookingRepository
                .findAllByRoomAndDepartureGreaterThanEqualAndArrivalLessThanEqual(booking.getRoom(), booking.getArrival(), booking.getDeparture());
        if (!bookings.isEmpty()) {
            throw new RuntimeException("can't book for these dates " + booking.getArrival() + " : " + booking.getDeparture() + "; room is reserved");
        }
    }

    @Override
    public BigDecimal getTotalPrice(Booking booking) {
        Room room = booking.getRoom();
        BigDecimal breakfastPrice = (room.getBreakfast() == null) ? BigDecimal.valueOf(0) : room.getBreakfast().getPrice();
        BigDecimal cleaningPrice = (room.getCleaningWithAdditionalCost() == null) ?
                BigDecimal.valueOf(0) : room.getCleaningWithAdditionalCost().getPrice();
        return room.getPrice().add(breakfastPrice).add(cleaningPrice);
    }

    @Override
    public List<Booking> findAllByUserAccountId(Long userAccountId) {
        return bookingRepository.findAllByUserAccountId(userAccountId);
    }

    @Override
    public List<Booking> findAllByHotelId(Long hotelId) {
        return bookingRepository.findAllByHotelIdOrderByArrival(hotelId);
    }

    @Override
    public List<Booking> findAllByArrivalGreaterThanEqualAndDepartureLessThanEqual(Long roomId, LocalDate checkIn,
                                                                                   LocalDate checkOut) {
        Room room = roomService.findById(roomId);
        return bookingRepository.findAllByRoomAndDepartureGreaterThanEqualAndArrivalLessThanEqual(room, checkIn, checkOut);
    }
}
