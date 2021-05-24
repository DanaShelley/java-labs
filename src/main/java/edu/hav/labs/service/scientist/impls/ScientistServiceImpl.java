package edu.hav.labs.service.scientist.impls;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  ScientistServiceImpl
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Scientist;
import edu.hav.labs.repository.scientist.ScientistRepository;
import edu.hav.labs.service.scientist.interfaces.IScientistService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class ScientistServiceImpl implements IScientistService {

    final
    ScientistRepository repository;

    public ScientistServiceImpl(ScientistRepository repository) {
        this.repository = repository;
    }

    @Override
    public Scientist getById(String id) {
        return repository.findById(id)
                         .orElse(null);
    }

    @Override
    public Scientist create(Scientist scientist) {
        return repository.save(scientist);
    }

    @Override
    public Scientist update(Scientist scientist) {
        return repository.save(scientist);
    }

    @Override
    public Scientist delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Scientist> getAll() {
        return repository.findAll();
    }
}
