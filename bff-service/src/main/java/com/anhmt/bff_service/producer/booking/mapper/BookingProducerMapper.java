package com.anhmt.bff_service.producer.booking.mapper;

import com.anhmt.bff_service.api.booking.request.BookingRoomCreationRequest;
import com.anhmt.bff_service.producer.booking.model.BookingCreationProducer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookingProducerMapper {

    BookingProducerMapper INSTANCE = Mappers.getMapper(BookingProducerMapper.class);

    BookingCreationProducer toBookingCreationProducer(BookingRoomCreationRequest bookingRoomCreationRequest);
}
