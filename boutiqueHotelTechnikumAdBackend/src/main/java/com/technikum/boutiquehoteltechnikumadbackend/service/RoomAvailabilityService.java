package com.technikum.boutiquehoteltechnikumadbackend.service;

import com.technikum.boutiquehoteltechnikumadbackend.domain.Reservation;
import com.technikum.boutiquehoteltechnikumadbackend.domain.Room;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RoomAvailabilityService {

    public boolean isAvailAble(Room room, LocalDate from, LocalDate to) {
        for(Reservation reservation : room.getReservations()) {
            if(reservation.getFrom().isBefore(to.atStartOfDay()) &&
                    from.atStartOfDay().isBefore(reservation.getTo())) {
                return false;

            }
        }
        return true;
    }
}
