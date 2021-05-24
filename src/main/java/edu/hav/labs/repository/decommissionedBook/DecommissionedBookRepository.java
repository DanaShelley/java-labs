package edu.hav.labs.repository.decommissionedBook;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  DecommissionedBookRepository
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.DecommissionedBook;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecommissionedBookRepository extends MongoRepository<DecommissionedBook, String> {
}
