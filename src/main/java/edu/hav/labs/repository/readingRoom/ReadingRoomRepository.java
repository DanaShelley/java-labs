package edu.hav.labs.repository.readingRoom;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  ReadingRoomRepository
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.ReadingRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingRoomRepository extends MongoRepository<ReadingRoom, String> {
}
