package edu.hav.labs.repository.writing;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  WritingRepository
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Writing;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WritingRepository extends MongoRepository<Writing, String> {
}
