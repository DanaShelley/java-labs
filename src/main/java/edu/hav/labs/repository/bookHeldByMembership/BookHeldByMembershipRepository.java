package edu.hav.labs.repository.bookHeldByMembership;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  BookHeldByMembership
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.BookHeldByMembership;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookHeldByMembershipRepository extends MongoRepository<BookHeldByMembership, String> {
}
