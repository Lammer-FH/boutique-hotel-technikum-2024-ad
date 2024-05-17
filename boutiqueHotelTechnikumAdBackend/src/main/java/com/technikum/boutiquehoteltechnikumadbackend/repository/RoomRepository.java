package com.technikum.boutiquehoteltechnikumadbackend.repository;

import com.technikum.boutiquehoteltechnikumadbackend.domain.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {
}
