package edu.hav.labs.repository.bookLog;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  BookLogRepository
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.BookLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLogRepository extends MongoRepository<BookLog, String> {
}
