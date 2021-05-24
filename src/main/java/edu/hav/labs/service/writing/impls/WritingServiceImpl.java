package edu.hav.labs.service.writing.impls;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  WritingServiceImpl
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Writing;
import edu.hav.labs.repository.writing.WritingRepository;
import edu.hav.labs.service.writing.interfaces.IWritingService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class WritingServiceImpl implements IWritingService {

    final
    WritingRepository repository;

    public WritingServiceImpl(WritingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Writing getById(String id) {
        return repository.findById(id)
                         .orElse(null);
    }

    @Override
    public Writing create(Writing writing) {
        return repository.save(writing);
    }

    @Override
    public Writing update(Writing writing) {
        return repository.save(writing);
    }

    @Override
    public Writing delete(String id) {
        repository.deleteById(id);
        return null;

    }

    @Override
    public List<Writing> getAll() {
        return repository.findAll();
    }
}
