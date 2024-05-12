package com.technikum.boutiquehoteltechnikumadbackend.core.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Extra")
@Data
public class Extra {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idExtra")
    private Integer id;

    @Column(name = "name")
    String name;

    @ManyToMany(mappedBy = "extras")
    List<Room> rooms;
}
