package com.technikum.boutiquehoteltechnikumadbackend.controller;

import com.technikum.boutiquehoteltechnikumadbackend.model.ReservationConfirmationDto;
import com.technikum.boutiquehoteltechnikumadbackend.model.ReservationDto;
import com.technikum.boutiquehoteltechnikumadbackend.model.ReservationRequestBody;
import com.technikum.boutiquehoteltechnikumadbackend.model.RoomDto;
import com.technikum.boutiquehoteltechnikumadbackend.service.ReservationService;
import com.technikum.boutiquehoteltechnikumadbackend.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class HotelApiController {
    private final RoomService roomService;
    private final ReservationService reservationService;

    public HotelApiController(RoomService roomService, ReservationService reservationService) {
        this.roomService = roomService;
        this.reservationService = reservationService;
    }

    @GetMapping("/rooms")
    List<RoomDto> getAllRooms(@RequestParam("from") LocalDate from, @RequestParam("to") LocalDate to) {
        return roomService.getAllRooms(from, to);
    }

    @GetMapping("/rooms/{roomId}")
    RoomDto getRoomById(@PathVariable("roomId") Integer roomId) {
        return roomService.getRoomById(roomId);
    }

    @PostMapping("/reservation/{roomId}")
    ReservationDto createReservation(@PathVariable("roomId") Integer roomId, @RequestBody ReservationRequestBody reservationRequestBody) {
        return reservationService.bookRoom(roomId, reservationRequestBody);
    }

    @GetMapping("/reservation/confirmation/{reservationId}")
    ReservationConfirmationDto getReservationConfirmation(@PathVariable("reservationId") Integer reservationId) {
        return reservationService.getConfirmation(reservationId);
    }
}
