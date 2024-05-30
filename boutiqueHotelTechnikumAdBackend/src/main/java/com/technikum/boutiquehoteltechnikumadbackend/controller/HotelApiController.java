package com.technikum.boutiquehoteltechnikumadbackend.controller;

import com.technikum.boutiquehoteltechnikumadbackend.model.RoomDto;
import com.technikum.boutiquehoteltechnikumadbackend.service.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HotelApiController {
    private final RoomService roomService;

    public HotelApiController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    List<RoomDto> getAllRooms(@RequestParam("from") LocalDate from, @RequestParam("to") LocalDate to) {
        return roomService.getAllRooms(from, to);
    }
}
