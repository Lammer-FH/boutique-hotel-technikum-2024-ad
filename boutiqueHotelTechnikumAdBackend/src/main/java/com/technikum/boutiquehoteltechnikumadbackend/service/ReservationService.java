package com.technikum.boutiquehoteltechnikumadbackend.service;

import com.technikum.boutiquehoteltechnikumadbackend.domain.Guest;
import com.technikum.boutiquehoteltechnikumadbackend.domain.Reservation;
import com.technikum.boutiquehoteltechnikumadbackend.domain.Room;
import com.technikum.boutiquehoteltechnikumadbackend.model.ReservationConfirmationDto;
import com.technikum.boutiquehoteltechnikumadbackend.model.ReservationDto;
import com.technikum.boutiquehoteltechnikumadbackend.model.ReservationRequestBody;
import com.technikum.boutiquehoteltechnikumadbackend.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static com.technikum.boutiquehoteltechnikumadbackend.service.ExtrasHelper.createExtras;

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

    public ReservationConfirmationDto getConfirmation(Integer reservationId) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);

        if(reservation.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Reservation not found"
            );
        }

        ReservationConfirmationDto reservationRes = new ReservationConfirmationDto();
        reservationRes.setFrom(reservation.get().getFrom());
        reservationRes.setTo(reservation.get().getFrom());
        reservationRes.setRoomTitle(reservation.get().getRoom().getTitle());
        reservationRes.setRoomDescription(reservation.get().getRoom().getDescription());
        reservationRes.setRoomImage(reservation.get().getRoom().getImagePath());
        reservationRes.setRoomPrice(reservation.get().getRoom().getPrice());
        reservationRes.setFirstName(reservation.get().getGuest().getFirstName());
        reservationRes.setLastName(reservation.get().getGuest().getLastName());
        reservationRes.setEMail(reservation.get().getGuest().getEMail());
        reservationRes.setDoBreakfast(reservation.get().getDoBreakfast());
        reservationRes.setExtras(createExtras(reservation.get().getRoom().getExtras()));

        return reservationRes;
    }
}
