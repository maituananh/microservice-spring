package com.anhmt.bff_service.api.booking;

import com.anhmt.bff_service.api.booking.request.BookingRoomCreationRequest;
import com.anhmt.bff_service.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/booking")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public void createBooking(@RequestBody BookingRoomCreationRequest bookingRoomCreationRequest) {
        bookingService.bookRoom(bookingRoomCreationRequest);
    }
}
