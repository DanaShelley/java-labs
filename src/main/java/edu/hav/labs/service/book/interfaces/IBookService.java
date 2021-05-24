package edu.hav.labs.service.book.interfaces;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  IBookService
  @version  1.0.0 
  @since 20.04.2021
*/


import edu.hav.labs.model.Book;

import java.util.List;

public interface IBookService {
    Book getById(String id);
    Book create(Book book);
    Book update(Book book);
    Book delete(String id);
    List<Book> getAll();
}
