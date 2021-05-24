package edu.hav.labs.repository.teacher;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  Teacher
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String> {
}
