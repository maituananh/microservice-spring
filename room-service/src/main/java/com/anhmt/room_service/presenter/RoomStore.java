package com.anhmt.room_service.presenter;

import com.anhmt.room_service.presenter.entity.RoomEntity;
import com.anhmt.room_service.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomStore {

    private final RoomRepository roomRepository;

    public Optional<RoomEntity> getById(final UUID id) {
        return roomRepository.findById(id);
    }

    public List<RoomEntity> getAll() {
        return roomRepository.findAll();
    }

    public RoomEntity save(final RoomEntity roomEntity) {
        return roomRepository.save(roomEntity);
    }
}
