package com.anhmt.bff_service.adapter.booking;

import com.anhmt.bff_service.client.booking.BookingClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BookingAdapter {

    private final BookingClient bookingClient;

    public void findByBookingId(final UUID bookingId) {
        bookingClient.getBookingById(bookingId);
    }
}
