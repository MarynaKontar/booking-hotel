package com.bookinghotel.service.impl;

import com.bookinghotel.model.entity.Booking;
import com.bookinghotel.model.entity.Hotel;
import com.bookinghotel.model.entity.Room;
import com.bookinghotel.model.entity.UserAccount;
import com.bookinghotel.repository.BookingRepository;
import com.bookinghotel.service.BookingService;
import com.bookinghotel.service.RoomService;
import com.bookinghotel.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Service
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
//        userAccount = userAccountService.findById(userAccount.getId());
//        Room room = roomService.getById(booking.getRoom().getId());
//        booking.setRoom(room);
//       UserAccount userAccount = booking.getUserAccount();
//       userAccount.addBooking(booking);
//       booking.setUserAccount(userAccount);
        return bookingRepository.save(booking);
    }

    @Override
    public BigDecimal getTotalPrice(Room room) {
        return room.getPrice().add(room.getBreakfast().getPrice()).add(room.getCleaningWithAdditionalCost().getPrice());
    }

    @Override
    public List<Booking> findAllByUserAccountId(Long userAccountId) {
        return bookingRepository.findAllByUserAccountId(userAccountId);
    }

    @Override
    public List<Booking> findAllByHotelId(Long hotelId) {
        return bookingRepository.findAllByHotelId(hotelId);
    }
}
