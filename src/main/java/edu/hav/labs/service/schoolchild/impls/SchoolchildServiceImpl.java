package edu.hav.labs.service.schoolchild.impls;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  SchoolchildServiceImpl
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Schoolchild;
import edu.hav.labs.repository.schoolchild.SchoolchildRepository;
import edu.hav.labs.service.schoolchild.interfaces.ISchoolchildService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class SchoolchildServiceImpl implements ISchoolchildService {

    final
    SchoolchildRepository repository;

    public SchoolchildServiceImpl(SchoolchildRepository repository) {
        this.repository = repository;
    }

    @Override
    public Schoolchild getById(String id) {
        return repository.findById(id)
                         .orElse(null);
    }

    @Override
    public Schoolchild create(Schoolchild schoolchild) {
        return repository.save(schoolchild);
    }

    @Override
    public Schoolchild update(Schoolchild schoolchild) {
        return repository.save(schoolchild);
    }

    @Override
    public Schoolchild delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Schoolchild> getAll() {
        return repository.findAll();
    }
}
