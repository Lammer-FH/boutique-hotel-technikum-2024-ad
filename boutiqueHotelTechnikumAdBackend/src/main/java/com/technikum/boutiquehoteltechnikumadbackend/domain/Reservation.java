package com.technikum.boutiquehoteltechnikumadbackend.domain;

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

    @Column(name = "`from`")
    private LocalDateTime from;

    @Column(name = "`to`")
    private LocalDateTime to;

    @Column(name = "doBreakfast",  columnDefinition = "TINYINT(1)")
    private Boolean doBreakfast;

    @ManyToOne
    @JoinColumn(name = "guest_idGuest")
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "room_idRoom")
    private Room room;

}
