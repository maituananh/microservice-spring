package com.anhmt.booking_service.presenter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "booking-rooms")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingRoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID roomId;
    private UUID userId;
}
