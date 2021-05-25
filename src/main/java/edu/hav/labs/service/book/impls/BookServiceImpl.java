package edu.hav.labs.service.book.impls;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  BookServiceImpl
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Book;
import edu.hav.labs.repository.book.BookRepository;
import edu.hav.labs.repository.bookHeldByMembership.BookHeldByMembershipRepository;
import edu.hav.labs.service.book.interfaces.IBookService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class BookServiceImpl implements IBookService {

    final
    BookRepository repository;

    final
    BookHeldByMembershipRepository bookHeldByMembershipRepository;


    public BookServiceImpl(BookRepository repository, BookHeldByMembershipRepository bookHeldByMembershipRepository) {
        this.repository = repository;
        this.bookHeldByMembershipRepository = bookHeldByMembershipRepository;
    }

    @Override
    public Book getById(String id) {
        return repository.findById(id)
                         .orElse(null);
    }

    @Override
    public Book create(Book book) {
        return repository.save(book);
    }

    @Override
    public Book update(Book book) {
        return repository.save(book);
    }

    @Override
    public Book delete(String id) {
        repository.deleteById(id);
        return null;

    }

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Book> getBookGivenFromLibraryShelf(int shelfNumber, int stellageNumber, String libraryId) {
        List<Book> books = new ArrayList<>();
        bookHeldByMembershipRepository.findAll()
                                      .forEach(bookHeldByMembership -> {
                                          if (bookHeldByMembership.getBook()
                                                                  .getShelveNumber() == shelfNumber &&
                                                  bookHeldByMembership.getBook()
                                                                      .getStorageRoom()
                                                                      .getLibrary()
                                                                      .getId()
                                                                      .equals(libraryId) &&
                                                  bookHeldByMembership.getBook()
                                                                      .getStellageNumber() == stellageNumber) {
                                              books.add(bookHeldByMembership.getBook());
                                          }
                                      });
        return books;
    }
}
