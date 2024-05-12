package com.technikum.boutiquehoteltechnikumadbackend.core.persistence;

import com.technikum.boutiquehoteltechnikumadbackend.core.domain.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
}
