package com.technikum.boutiquehoteltechnikumadbackend.core.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Guest")
@Data
public class Guest {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idGuest")
    private Integer id;

    @Column(name = "firstname")
    String firstName;

    @Column(name = "lastname")
    String lastName;

    @Column(name = "email")
    String eMail;

    @OneToMany(mappedBy = "guest")
    List<Reservation> reservations;
}
