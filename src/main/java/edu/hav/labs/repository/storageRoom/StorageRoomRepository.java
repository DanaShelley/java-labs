package edu.hav.labs.repository.storageRoom;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  StorageRoomRepository
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.StorageRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRoomRepository extends MongoRepository<StorageRoom, String> {
}
