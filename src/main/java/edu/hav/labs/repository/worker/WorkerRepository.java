package edu.hav.labs.repository.worker;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  WorkerRepository
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Worker;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends MongoRepository<Worker, String> {
}
