package edu.hav.labs.repository.bookLog;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  BookLogRepository
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.BookLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookLogRepository extends MongoRepository<BookLog, String> {
    List<BookLog> findAllByMembership_IdAndDateBetweenOrDateEqualsOrDateEquals(String id, LocalDate date1, LocalDate date2, LocalDate date3, LocalDate date4);
    List<BookLog> findAllByMembership_IdAndBook_StorageRoom_Library_IdAndDateBetweenOrDateEqualsOrDateEquals(String membershipId, String libraryId, LocalDate date1, LocalDate date2, LocalDate date3, LocalDate date4);
    List<BookLog> findAllByStaff_IdAndDateBetweenOrDateEqualsOrDateEquals(String id, LocalDate date1, LocalDate date2, LocalDate date3, LocalDate date4);
    List<BookLog> findAllByStaff_Id(String id);
}
