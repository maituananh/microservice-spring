package com.anhmt.booking_service.presenter.store;

import com.anhmt.booking_service.domain.BookingRoom;
import com.anhmt.booking_service.presenter.mapper.BookingRoomMapper;
import com.anhmt.booking_service.repository.BookingRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookingRoomStore {

    private final BookingRoomRepository bookingRoomRepository;

    @Transactional
    public UUID save(final BookingRoom bookingRoom) {
        var entity = BookingRoomMapper.INSTANCE.toBookingRoomEntity(bookingRoom);
        return bookingRoomRepository.save(entity).getId();
    }
}
