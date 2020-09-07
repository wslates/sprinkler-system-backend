package io.slates.repository;

import io.slates.model.SprinklerProgram;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SprinklerProgramRepository extends MongoRepository<SprinklerProgram, String> {
}
