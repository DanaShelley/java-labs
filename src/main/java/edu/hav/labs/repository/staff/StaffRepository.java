package edu.hav.labs.repository.staff;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  StaffRepository
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends MongoRepository<Staff, String> {
}
