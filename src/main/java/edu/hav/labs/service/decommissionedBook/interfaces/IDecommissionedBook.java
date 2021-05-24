package edu.hav.labs.service.decommissionedBook.interfaces;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  IDecommissionedBook
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.DecommissionedBook;

import java.util.List;

public interface IDecommissionedBook {
    DecommissionedBook getById(String id);
    DecommissionedBook create(DecommissionedBook decommissionedBook);
    DecommissionedBook update(DecommissionedBook decommissionedBook);
    DecommissionedBook delete(String id);
    List<DecommissionedBook> getAll();

}
