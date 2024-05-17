package com.technikum.boutiquehoteltechnikumadbackend.domain;

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
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String eMail;

    @OneToMany(mappedBy = "guest")
    private List<Reservation> reservations;
}
