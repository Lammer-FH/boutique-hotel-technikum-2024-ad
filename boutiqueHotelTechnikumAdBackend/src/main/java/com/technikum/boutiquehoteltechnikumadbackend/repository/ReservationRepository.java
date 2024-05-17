package com.technikum.boutiquehoteltechnikumadbackend.repository;

import com.technikum.boutiquehoteltechnikumadbackend.domain.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
}
