package edu.hav.labs.dao.library.impls;

/*
  @author   Havaleshko Bohdana
  @project   labs
  @version  1.0.0
  @since 13.04.2021
*/


import edu.hav.labs.dao.library.interfaces.ILibraryDAO;
import edu.hav.labs.data.FakeData;
import edu.hav.labs.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LibraryDAOImpl implements ILibraryDAO {

    @Autowired
    FakeData fakeData;

    @Override
    public Library getById(String id) {
        return this.getAll().stream()
                .filter(library -> library.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public Library create(Library library) {

        String id = String.valueOf(this.getAll().stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);
        library.setId(id);
        this.getAll().add(library);
        return library;
    }

    @Override
    public Library update(Library library) {
        this.delete(library.getId());
        this.getAll().add(library);
        return library;
    }

    @Override
    public Library delete(String id) {
        Library library = this.getById(id);
        this.getAll().remove(library);
        return library;
    }

    @Override
    public List<Library> getAll() {
        return fakeData.getLibraries();
    }

}
