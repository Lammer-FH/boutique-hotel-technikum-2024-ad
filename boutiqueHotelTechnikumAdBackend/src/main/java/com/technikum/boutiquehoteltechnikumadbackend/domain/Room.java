package com.technikum.boutiquehoteltechnikumadbackend.domain;

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
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "imagePath")
    private String imagePath;

    @Column(name = "price")
    private BigDecimal price;

    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations;

    @ManyToMany
    @JoinTable(name = "Room_has_Extra",
            joinColumns = @JoinColumn(name = "extra_IdExtra"),
            inverseJoinColumns = @JoinColumn(name = "room_IdRoom"))
    private List<Extra> extras;
}
