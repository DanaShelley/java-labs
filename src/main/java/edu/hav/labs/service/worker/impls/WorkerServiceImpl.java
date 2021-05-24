package edu.hav.labs.service.worker.impls;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  WorkerServiceImpl
  @version  1.0.0 
  @since 20.04.2021
*/


import edu.hav.labs.model.Worker;
import edu.hav.labs.repository.worker.WorkerRepository;
import edu.hav.labs.service.worker.interfaces.IWorkerService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class WorkerServiceImpl implements IWorkerService {

    final
    WorkerRepository repository;

    public WorkerServiceImpl(WorkerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Worker getById(String id) {
        return repository.findById(id)
                         .orElse(null);
    }

    @Override
    public Worker create(Worker worker) {
        return repository.save(worker);
    }

    @Override
    public Worker update(Worker worker) {
        return repository.save(worker);
    }

    @Override
    public Worker delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Worker> getAll() {
        return repository.findAll();
    }
}
