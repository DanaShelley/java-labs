package edu.hav.labs.service.edition.impls;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  EditionServiceImpl
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Edition;
import edu.hav.labs.repository.edition.EditionRepository;
import edu.hav.labs.service.edition.interfaces.IEditionService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class EditionServiceImpl implements IEditionService {

    final
    EditionRepository repository;

    public EditionServiceImpl(EditionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Edition getById(String id) {
        return repository.findById(id)
                         .orElse(null);
    }

    @Override
    public Edition create(Edition edition) {
        return repository.save(edition);
    }

    @Override
    public Edition update(Edition edition) {
        return repository.save(edition);
    }

    @Override
    public Edition delete(String id) {
        repository.deleteById(id);
        return null;

    }

    @Override
    public List<Edition> getAll() {
        return repository.findAll();
    }
}
