package edu.hav.labs.service.library.interfaces;

/*
  @author   Havaleshko Bohdana
  @project   labs
  @version  1.0.0
  @since 13.04.2021
*/

import edu.hav.labs.model.Library;

import java.util.List;

public interface ILibraryService {
    Library getById(String id);
    Library create(Library student);
    Library update(Library student);
    Library delete(String id);
    List<Library> getAll();
}
