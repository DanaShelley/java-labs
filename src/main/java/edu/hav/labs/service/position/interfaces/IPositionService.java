package edu.hav.labs.service.position.interfaces;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  IPositionService
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Position;

import java.util.List;

public interface IPositionService {
    Position getById(String id);
    Position create(Position position);
    Position update(Position position);
    Position delete(String id);
    List<Position> getAll();
}
