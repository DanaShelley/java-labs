package edu.hav.labs.repository.position;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  PositionRepository
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Position;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends MongoRepository<Position, String> {
}
