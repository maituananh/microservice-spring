package com.anhmt.bff_service.api.booking;

import com.anhmt.bff_service.api.booking.request.BookingRoomCreationInput;
import com.anhmt.bff_service.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @MutationMapping
    public String createBooking(@Argument BookingRoomCreationInput bookingRoomCreationInput) {
        bookingService.bookRoom(bookingRoomCreationInput);
        return "Your room are updating";
    }
}
