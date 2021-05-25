package edu.hav.labs.repository.bookHeldByMembership;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  BookHeldByMembership
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Book;
import edu.hav.labs.model.BookHeldByMembership;
import edu.hav.labs.model.Membership;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookHeldByMembershipRepository extends MongoRepository<BookHeldByMembership, String> {
    List<BookHeldByMembership> findAllByBook_Edition_Id(String id);
    List<BookHeldByMembership> findAllByDeliveryDateAfter(LocalDate date);
}
