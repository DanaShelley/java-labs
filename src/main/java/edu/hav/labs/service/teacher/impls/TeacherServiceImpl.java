package edu.hav.labs.service.teacher.impls;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  TeacherServiceImpl
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Teacher;
import edu.hav.labs.repository.teacher.TeacherRepository;
import edu.hav.labs.service.teacher.interfaces.ITeacherService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class TeacherServiceImpl implements ITeacherService {

    final
    TeacherRepository repository;

    public TeacherServiceImpl(TeacherRepository repository) {
        this.repository = repository;
    }

    @Override
    public Teacher getById(String id) {
        return repository.findById(id)
                         .orElse(null);
    }

    @Override
    public Teacher create(Teacher teacher) {
        return repository.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        return repository.save(teacher);
    }

    @Override
    public Teacher delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Teacher> getAll() {
        return repository.findAll();
    }
}
