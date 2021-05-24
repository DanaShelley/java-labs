package edu.hav.labs.service.library.interfaces;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  ILibraryService
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Library;

import java.util.List;

public interface ILibraryService {
    Library getById(String id);
    Library create(Library library);
    Library update(Library library);
    Library delete(String id);
    List<Library> getAll();
}
