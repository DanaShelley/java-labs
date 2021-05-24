package edu.hav.labs.repository.membership;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  MembershipRepository
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Membership;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MembershipRepository extends MongoRepository<Membership, String> {
}
