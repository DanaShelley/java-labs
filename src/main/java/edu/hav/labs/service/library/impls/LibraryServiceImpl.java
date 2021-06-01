package edu.hav.labs.service.library.impls;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  LibraryServiceImpl
  @version  1.0.0
  @since 20.04.2021
*/

import edu.hav.labs.model.Library;
import edu.hav.labs.repository.library.LibraryRepository;
import edu.hav.labs.service.library.interfaces.ILibraryService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class LibraryServiceImpl implements ILibraryService {

    final
    LibraryRepository repository;

    public LibraryServiceImpl(LibraryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Library getById(String id) {
        return repository.findById(id)
                         .orElse(null);
    }

    @Override
    public Library create(Library library) {
        String id = String.valueOf(this.getAll()
                                       .stream()
                                       .mapToInt(el -> Integer.parseInt(el.getId()))
                                       .max()
                                       .orElse(0) + 1);
        library.setId(id);
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
        return (List<Library>) repository.findAll();
    }
}
