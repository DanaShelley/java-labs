package edu.hav.labs.service.schoolchild.interfaces;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  ISchoolchildService
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Schoolchild;

import java.util.List;

public interface ISchoolchildService {
    Schoolchild getById(String id);
    Schoolchild create(Schoolchild schoolchild);
    Schoolchild update(Schoolchild schoolchild);
    Schoolchild delete(String id);
    List<Schoolchild> getAll();
}
