package com.anhmt.booking_service.consumer.mapper;

import com.anhmt.booking_service.consumer.model.BookingRoomDto;
import com.anhmt.booking_service.domain.BookingRoom;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookingRoomConsumerMapper {
    BookingRoomConsumerMapper INSTANCE = Mappers.getMapper(BookingRoomConsumerMapper.class);

    BookingRoom toBookingRoom(BookingRoomDto bookingRoomDto);
}
