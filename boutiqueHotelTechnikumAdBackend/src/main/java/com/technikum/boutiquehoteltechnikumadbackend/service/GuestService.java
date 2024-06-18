package com.technikum.boutiquehoteltechnikumadbackend.service;

import com.technikum.boutiquehoteltechnikumadbackend.domain.Guest;
import com.technikum.boutiquehoteltechnikumadbackend.model.ReservationRequestBody;
import com.technikum.boutiquehoteltechnikumadbackend.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public boolean guestExists(String email) {
        Optional<Guest> guest = guestRepository.findGuestByeMail(email);
        return guest.isPresent();
    }

    public Guest findByEmail(String eMail) {
        return guestRepository.findGuestByeMail(eMail).get();
    }

    public Guest createGuest(ReservationRequestBody reservationRequestBody) {
        Guest guest = new Guest();
        guest.setFirstName(reservationRequestBody.getFirstName());
        guest.setLastName(reservationRequestBody.getLastName());
        guest.setEMail(reservationRequestBody.getEMail());
        return guestRepository.save(guest);
    }
}
