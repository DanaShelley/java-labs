package edu.hav.labs.service.worker.interfaces;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  IWorkerService
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Worker;

import java.util.List;

public interface IWorkerService {
    Worker getById(String id);
    Worker create(Worker worker);
    Worker update(Worker worker);
    Worker delete(String id);
    List<Worker> getAll();
}
