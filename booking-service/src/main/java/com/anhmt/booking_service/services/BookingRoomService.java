package com.anhmt.booking_service.services;

import com.anhmt.booking_service.domain.BookingRoom;
import com.anhmt.booking_service.presenter.store.BookingRoomStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingRoomService {

    private final BookingRoomStore bookingRoomStore;

    public void bookRoom(final BookingRoom bookingRoom) {
        bookingRoomStore.save(bookingRoom);
    }
}
