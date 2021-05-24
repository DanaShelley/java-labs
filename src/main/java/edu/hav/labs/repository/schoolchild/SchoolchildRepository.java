package edu.hav.labs.repository.schoolchild;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  SchoolchildRepository
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Schoolchild;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolchildRepository extends MongoRepository<Schoolchild, String> {
}
