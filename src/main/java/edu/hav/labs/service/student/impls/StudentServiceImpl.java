package edu.hav.labs.service.student.impls;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  StudentServiceImpl
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Student;
import edu.hav.labs.repository.student.StudentRepository;
import edu.hav.labs.service.student.interfaces.IStudentService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class StudentServiceImpl implements IStudentService {

    final
    StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student getById(String id) {
        return repository.findById(id)
                         .orElse(null);
    }

    @Override
    public Student create(Student student) {
        return repository.save(student);
    }

    @Override
    public Student update(Student student) {
        return repository.save(student);
    }

    @Override
    public Student delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }
}
