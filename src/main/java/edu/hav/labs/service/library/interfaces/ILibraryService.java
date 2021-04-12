package edu.hav.labs.service.library.interfaces;

import edu.hav.labs.model.Library;

import java.util.List;

public interface ILibraryService {
    Library getById(String id);
    Library create(Library student);
    Library update(Library student);
    Library delete(String id);
    List<Library> getAll();
}
