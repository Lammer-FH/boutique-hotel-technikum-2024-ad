package com.technikum.boutiquehoteltechnikumadbackend.core.persistence;

import com.technikum.boutiquehoteltechnikumadbackend.core.domain.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {
}
