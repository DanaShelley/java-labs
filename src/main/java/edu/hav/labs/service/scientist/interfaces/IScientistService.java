package edu.hav.labs.service.scientist.interfaces;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  IScientistService
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Scientist;

import java.util.List;

public interface IScientistService {
    Scientist getById(String id);
    Scientist create(Scientist scientist);
    Scientist update(Scientist scientist);
    Scientist delete(String id);
    List<Scientist> getAll();
}
