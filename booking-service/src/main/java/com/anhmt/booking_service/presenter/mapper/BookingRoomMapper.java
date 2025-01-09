package com.anhmt.booking_service.presenter.mapper;

import com.anhmt.booking_service.domain.BookingRoom;
import com.anhmt.booking_service.presenter.entities.BookingRoomEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookingRoomMapper {
    BookingRoomMapper INSTANCE = Mappers.getMapper(BookingRoomMapper.class);

    BookingRoomEntity toBookingRoomEntity(BookingRoom bookingRoom);
}
