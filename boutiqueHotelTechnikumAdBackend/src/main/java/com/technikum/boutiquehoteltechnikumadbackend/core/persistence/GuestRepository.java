package com.technikum.boutiquehoteltechnikumadbackend.core.persistence;

import com.technikum.boutiquehoteltechnikumadbackend.core.domain.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Integer> {
}
