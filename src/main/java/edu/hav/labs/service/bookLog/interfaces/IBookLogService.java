package edu.hav.labs.service.bookLog.interfaces;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  IBookLogService
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.BookLog;

import java.util.List;

public interface IBookLogService {
    BookLog getById(String id);
    BookLog create(BookLog bookLog);
    BookLog update(BookLog bookLog);
    BookLog delete(String id);
    List<BookLog> getAll();
}
