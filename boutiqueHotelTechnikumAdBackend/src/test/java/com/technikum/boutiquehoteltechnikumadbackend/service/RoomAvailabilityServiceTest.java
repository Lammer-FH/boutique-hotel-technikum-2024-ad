package com.technikum.boutiquehoteltechnikumadbackend.service;

import com.technikum.boutiquehoteltechnikumadbackend.domain.Reservation;
import com.technikum.boutiquehoteltechnikumadbackend.domain.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class RoomAvailabilityServiceTest {
    @InjectMocks
    private RoomAvailabilityService roomAvailabilityService;

    Room room = new Room();
    Reservation reservation = new Reservation();

    @BeforeEach
    void setUp() {
        reservation.setFrom(LocalDateTime.of(2024,7,1,0,0));
        reservation.setTo(LocalDateTime.of(2024,7,5,0,0));
        room.setReservations(List.of(reservation));
    }

    @Test
    void isAvailAbleTest_True() {
        boolean result = roomAvailabilityService.isAvailAble(room, LocalDate.of(2024, 7, 5),
                LocalDate.of(2024, 7 ,10));
        assertThat(result).isTrue();
    }

    @Test
    void isAvailAbleTest_False() {
        boolean result = roomAvailabilityService.isAvailAble(room, LocalDate.of(2024, 7, 4),
                LocalDate.of(2024, 7 ,10));
        assertThat(result).isFalse();
    }

    @Test
    void isAvailAbleTest_False_2() {
        boolean result = roomAvailabilityService.isAvailAble(room, LocalDate.of(2024, 7, 2),
                LocalDate.of(2024, 7 ,4));
        assertThat(result).isFalse();
    }

    @Test
    void isAvailAbleTest_False_3() {
        Reservation reservation1 = new Reservation();
        reservation1.setFrom(LocalDateTime.of(2024,7,20,0,0));
        reservation1.setTo(LocalDateTime.of(2024,7,20,0,0));
        room.setReservations(List.of(reservation1));

        boolean result = roomAvailabilityService.isAvailAble(room, LocalDate.of(2024, 7, 20),
                LocalDate.of(2024, 7 ,20));
        assertThat(result).isFalse();
    }
}
