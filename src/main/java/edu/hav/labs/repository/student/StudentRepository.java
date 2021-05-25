package edu.hav.labs.repository.student;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  StudentRepository
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findAllByUniversity(String university);
    List<Student> findAllByFaculty(String faculty);
}
