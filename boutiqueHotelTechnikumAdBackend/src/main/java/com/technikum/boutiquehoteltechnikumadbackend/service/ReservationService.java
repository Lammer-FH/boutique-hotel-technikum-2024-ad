package com.technikum.boutiquehoteltechnikumadbackend.service;

import com.technikum.boutiquehoteltechnikumadbackend.domain.Guest;
import com.technikum.boutiquehoteltechnikumadbackend.domain.Reservation;
import com.technikum.boutiquehoteltechnikumadbackend.domain.Room;
import com.technikum.boutiquehoteltechnikumadbackend.model.ReservationDto;
import com.technikum.boutiquehoteltechnikumadbackend.model.ReservationRequestBody;
import com.technikum.boutiquehoteltechnikumadbackend.model.RoomDto;
import com.technikum.boutiquehoteltechnikumadbackend.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final RoomService roomService;
    private final GuestService guestService;
    private final RoomAvailabilityService roomAvailabilityService;

    public ReservationService(ReservationRepository reservationRepository, RoomService roomService, GuestService guestService, RoomAvailabilityService roomAvailabilityService) {
        this.reservationRepository = reservationRepository;
        this.roomService = roomService;
        this.guestService = guestService;
        this.roomAvailabilityService = roomAvailabilityService;
    }

    public ReservationDto bookRoom(Integer roomId, ReservationRequestBody reservationRequestBody) {
        Optional<Room> room = roomService.findRoomById(roomId);

        if(room.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Room not found"
            );
        }

        if(!roomAvailabilityService.isAvailAble(room.get(), reservationRequestBody.getFrom(), reservationRequestBody.getTo())) {
            throw new ResponseStatusException(
                    HttpStatus.UNPROCESSABLE_ENTITY, "Room is not available during the specified period"
            );
        }

        Guest guest;

        if (guestService.guestExists(reservationRequestBody.getEMail())) {
            guest = guestService.findByEmail(reservationRequestBody.getEMail());
        }

        else {
            guest = guestService.createGuest(reservationRequestBody);
        }

        Reservation reservation = new Reservation();
        reservation.setRoom(room.get());
        reservation.setFrom(reservationRequestBody.getFrom().atStartOfDay());
        reservation.setTo(reservationRequestBody.getTo().atStartOfDay());
        reservation.setDoBreakfast(reservationRequestBody.getDoBreakfast());
        reservation.setGuest(guest);
        reservation = reservationRepository.save(reservation);

        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setReservationId(reservation.getId());
        reservationDto.setRoomTitle(reservation.getRoom().getTitle());

        return reservationDto;
    }
}
