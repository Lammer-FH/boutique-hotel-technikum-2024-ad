package com.technikum.boutiquehoteltechnikumadbackend.service;

import com.technikum.boutiquehoteltechnikumadbackend.domain.Extra;
import com.technikum.boutiquehoteltechnikumadbackend.domain.Room;
import com.technikum.boutiquehoteltechnikumadbackend.model.ExtraDto;
import com.technikum.boutiquehoteltechnikumadbackend.model.RoomDto;
import com.technikum.boutiquehoteltechnikumadbackend.repository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomAvailabilityService roomAvailabilityService;

    public RoomService(RoomRepository roomRepository, RoomAvailabilityService roomAvailabilityService) {
        this.roomRepository = roomRepository;
        this.roomAvailabilityService = roomAvailabilityService;
    }

    public List<RoomDto> getAllRooms(LocalDate from, LocalDate to) {
        List<Room> rooms = (List<Room>) roomRepository.findAll();
        rooms = rooms.stream().filter(room -> roomAvailabilityService.isAvailAble(room, from, to)).toList();
        return createRoomDtos(rooms);
    }

    public RoomDto getRoomById(Integer roomId) {
        Optional<Room> room = roomRepository.findById(roomId);

        if(room.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Room not found"
            );
        }

        return createRoomDto(room.get());
    }

    private List<RoomDto> createRoomDtos(List<Room> rooms) {
        List<RoomDto> roomDtos = new ArrayList<>();
        for(Room room: rooms) {
            roomDtos.add(createRoomDto(room));
        }
        return roomDtos;
    }

    public RoomDto createRoomDto(Room room) {
        RoomDto roomDto = new RoomDto();
        roomDto.setId(room.getId());
        roomDto.setTitle(room.getTitle());
        roomDto.setDescription(room.getDescription());
        roomDto.setImagePath(room.getImagePath());
        roomDto.setPrice(room.getPrice());
        roomDto.setExtras(createExtras(room.getExtras()));
        return roomDto;
    }

    private List<ExtraDto> createExtras(List<Extra> extras) {
        List<ExtraDto> extraDtos = new ArrayList<>();

        for (Extra extra: extras) {
            ExtraDto extraDto = new ExtraDto();
            extraDto.setName(extra.getName().name());
            extraDtos.add(extraDto);
        }
        return extraDtos;
    }

    public Optional<Room> findRoomById(Integer roomId) {
        return roomRepository.findById(roomId);
    }
}
