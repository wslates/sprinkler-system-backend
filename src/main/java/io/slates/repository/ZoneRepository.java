package io.slates.repository;

import io.slates.model.Zone;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ZoneRepository extends MongoRepository<Zone, String> {
    Zone findByName(String name);
}
