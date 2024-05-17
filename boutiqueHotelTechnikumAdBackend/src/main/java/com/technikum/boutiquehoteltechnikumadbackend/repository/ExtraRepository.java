package com.technikum.boutiquehoteltechnikumadbackend.repository;

import com.technikum.boutiquehoteltechnikumadbackend.domain.Extra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraRepository extends CrudRepository<Extra, Integer> {
}
