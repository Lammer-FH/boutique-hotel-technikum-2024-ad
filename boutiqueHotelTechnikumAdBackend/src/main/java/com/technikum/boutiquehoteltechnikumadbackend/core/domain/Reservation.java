package com.technikum.boutiquehoteltechnikumadbackend.core.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "Reservation")
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idReservation")
    private Integer id;

    @Column(name = "from")
    LocalDateTime from;

    @Column(name = "to")
    LocalDateTime to;

    @Column(name = "doBreakfast",  columnDefinition = "TINYINT(1)")
    Boolean doBreakfast;

    @ManyToOne
    @JoinColumn(name = "guest_idGuest")
    Guest guest;

    @ManyToOne
    @JoinColumn(name = "room_idRoom")
    Room room;

}
