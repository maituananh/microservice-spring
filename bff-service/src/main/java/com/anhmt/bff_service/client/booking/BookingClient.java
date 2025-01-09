package com.anhmt.bff_service.client.booking;

import com.anhmt.bff_service.client.booking.response.BookingClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "${client.booking-client.name}", url = "${client.booking-client.url}", configuration = FeignClient.class)
public interface BookingClient {

    @GetMapping("api/v1/booking")
    List<BookingClientResponse> getAllBooking();

    @GetMapping("/api/v1/booking/{bookingId}")
    BookingClientResponse getBookingById(@PathVariable UUID bookingId);
}
