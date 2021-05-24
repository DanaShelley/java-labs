package edu.hav.labs.repository.staffLog;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  StaffLogRepository
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.StaffLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffLogRepository extends MongoRepository<StaffLog, String> {
}
