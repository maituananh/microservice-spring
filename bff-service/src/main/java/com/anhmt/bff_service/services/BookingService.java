package com.anhmt.bff_service.services;

import com.anhmt.bff_service.adapter.room.RoomAdapter;
import com.anhmt.bff_service.adapter.user.UserAdapter;
import com.anhmt.bff_service.api.booking.request.BookingRoomCreationRequest;
import com.anhmt.bff_service.domain.Room;
import com.anhmt.bff_service.domain.User;
import com.anhmt.bff_service.producer.booking.BookingProducer;
import com.anhmt.bff_service.producer.booking.mapper.BookingProducerMapper;
import com.anhmt.bff_service.producer.booking.model.BookingCreationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final RoomAdapter roomAdapter;
    private final UserAdapter userAdapter;
    private final BookingProducer bookingProducer;

    public void bookRoom(final BookingRoomCreationRequest req) {
        var roomCf = asyncGetRoomById(req.getRoomId());
        var userCf = asyncGetUserById(req.getUserId());

        CompletableFuture.allOf(userCf, roomCf);

        User user = userCf.join();
        Room room = roomCf.join();

        if (room == null || user == null) {
            return;
        }

        bookingProducer.send(BookingProducerMapper.INSTANCE.toBookingCreationProducer(req));
    }

    private CompletableFuture<Room> asyncGetRoomById(final UUID roomId) {
        return CompletableFuture.supplyAsync(() -> roomAdapter.getRoomById(roomId));
    }

    private CompletableFuture<User> asyncGetUserById(final UUID userId) {
        return CompletableFuture.supplyAsync(() -> userAdapter.getUserDetail(userId));
    }
}
