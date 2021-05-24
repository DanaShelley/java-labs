package edu.hav.labs.repository.scientist;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  ScientistRepository
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Scientist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScientistRepository extends MongoRepository<Scientist, String> {
}
