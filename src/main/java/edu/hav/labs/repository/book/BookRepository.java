package edu.hav.labs.repository.book;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  BookRepository
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Book;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
}
