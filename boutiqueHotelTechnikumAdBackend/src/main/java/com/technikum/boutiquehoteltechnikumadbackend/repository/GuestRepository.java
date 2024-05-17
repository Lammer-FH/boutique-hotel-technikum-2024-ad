package com.technikum.boutiquehoteltechnikumadbackend.repository;

import com.technikum.boutiquehoteltechnikumadbackend.domain.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Integer> {
    Optional<Guest> findGuestByeMail(String email);
}
