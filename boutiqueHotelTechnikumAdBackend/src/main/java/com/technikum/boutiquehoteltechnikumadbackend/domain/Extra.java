package com.technikum.boutiquehoteltechnikumadbackend.domain;

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
    private String name;

    @ManyToMany(mappedBy = "extras")
    private List<Room> rooms;
}
