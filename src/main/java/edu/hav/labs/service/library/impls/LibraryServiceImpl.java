package edu.hav.labs.service.library.impls;

/*
  @author   Havaleshko Bohdana
  @project   labs
  @version  1.0.0
  @since 13.04.2021
*/

import edu.hav.labs.dao.library.impls.LibraryDAOImpl;
import edu.hav.labs.model.Library;
import edu.hav.labs.service.library.interfaces.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements ILibraryService {

    @Autowired
    LibraryDAOImpl dao;

    @Override
    public Library getById(String id) {
        return dao.getById(id);
    }

    @Override
    public Library create(Library library) {
        return dao.create(library);
    }

    @Override
    public Library update(Library library) {
        return dao.update(library);
    }

    @Override
    public Library delete(String id) {
        return dao.delete(id);
    }

    @Override
    public List<Library> getAll() {
        return dao.getAll();
    }
}
