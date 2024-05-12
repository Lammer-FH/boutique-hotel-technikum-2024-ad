package com.technikum.boutiquehoteltechnikumadbackend.core.persistence;

import com.technikum.boutiquehoteltechnikumadbackend.core.domain.Extra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraRepository extends CrudRepository<Extra, Integer> {
}
