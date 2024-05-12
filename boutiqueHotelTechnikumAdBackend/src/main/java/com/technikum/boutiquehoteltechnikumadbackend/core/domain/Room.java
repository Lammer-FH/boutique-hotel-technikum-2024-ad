package com.technikum.boutiquehoteltechnikumadbackend.core.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Room")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idRoom")
    private Integer id;

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    @Column(name = "imagePath")
    String imagePath;

    @Column(name = "price")
    BigDecimal price;

    @OneToMany(mappedBy = "room")
    List<Reservation> reservations;

    @ManyToMany
    @JoinTable(name = "Room_has_Extra",
            joinColumns = @JoinColumn(name = "extra_IdExtra"),
            inverseJoinColumns = @JoinColumn(name = "room_IdRoom"))
    List<Extra> extras;
}
