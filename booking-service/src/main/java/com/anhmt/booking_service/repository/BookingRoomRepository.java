package com.anhmt.booking_service.repository;

import com.anhmt.booking_service.presenter.entities.BookingRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookingRoomRepository extends JpaRepository<BookingRoomEntity, UUID> {
}
