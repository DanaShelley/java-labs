package edu.hav.labs.service.position.impls;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  PositionServiceImpl
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Position;
import edu.hav.labs.repository.position.PositionRepository;
import edu.hav.labs.service.position.interfaces.IPositionService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class PositionServiceImpl implements IPositionService {

    final
    PositionRepository repository;

    public PositionServiceImpl(PositionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Position getById(String id) {
        return repository.findById(id)
                         .orElse(null);
    }

    @Override
    public Position create(Position position) {
        String id = String.valueOf(this.getAll()
                                       .stream()
                                       .mapToInt(el -> Integer.parseInt(el.getId()))
                                       .max()
                                       .orElse(0) + 1);
        position.setId(id);
        return repository.save(position);
    }

    @Override
    public Position update(Position position) {
        return repository.save(position);
    }

    @Override
    public Position delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Position> getAll() {
        return repository.findAll();
    }
}
