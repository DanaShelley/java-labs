package edu.hav.labs.repository.library;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  LibraryRepository
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Library;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends MongoRepository<Library, String> {
}
