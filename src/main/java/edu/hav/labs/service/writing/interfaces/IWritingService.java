package edu.hav.labs.service.writing.interfaces;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  IWritingService
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Writing;

import java.util.List;

public interface IWritingService {
    Writing getById(String id);
    Writing create(Writing writing);
    Writing update(Writing writing);
    Writing delete(String id);
    List<Writing> getAll();
}
