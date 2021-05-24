package edu.hav.labs.service.edition.interfaces;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  IEditionService
  @version  1.0.0 
  @since 20.04.2021
*/


import edu.hav.labs.model.Edition;

import java.util.List;

public interface IEditionService {
    Edition getById(String id);
    Edition create(Edition edition);
    Edition update(Edition edition);
    Edition delete(String id);
    List<Edition> getAll();

}
