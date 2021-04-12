package edu.hav.labs.dao.library.interfaces;

import edu.hav.labs.model.Library;

import java.util.List;

public interface ILibraryDAO {
    Library getById(String id);
    Library create(Library student);
    Library update(Library student);
    Library delete(String id);
    List<Library> getAll();
}
