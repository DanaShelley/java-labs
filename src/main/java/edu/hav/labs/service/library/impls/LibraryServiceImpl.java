package edu.hav.labs.service.library.impls;

import edu.hav.labs.data.FakeData;
import edu.hav.labs.model.Library;
import edu.hav.labs.repository.library.LibraryRepository;
import edu.hav.labs.service.library.interfaces.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class LibraryServiceImpl implements ILibraryService {

/*
    @Autowired
    LibraryDAOImpl dao;
*/

    @Autowired
    LibraryRepository repository;

    @Autowired
    FakeData data;

    @PostConstruct
    void init() {
        List<Library> libraries = data.getLibraries();
        repository.saveAll(libraries);
    }
    

    @Override
    public Library getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Library create(Library library) {
        String id = String.valueOf(this.getAll().stream()
                .mapToInt(el->Integer.parseInt(el.getId())).max().orElse(0) + 1);
        library.setId(id);
        this.getAll().add(library);
        return repository.save(library);
    }

    @Override
    public Library update(Library library) {
        return repository.save(library);
    }

    @Override
    public Library delete(String id) {
        repository.deleteById(id);
        return null;

    }

    @Override
    public List<Library> getAll() {
        return repository.findAll();
    }
}
