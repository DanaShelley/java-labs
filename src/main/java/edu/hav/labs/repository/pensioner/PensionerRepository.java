package edu.hav.labs.repository.pensioner;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  PensionerRepository
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Pensioner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PensionerRepository extends MongoRepository<Pensioner, String> {
}
