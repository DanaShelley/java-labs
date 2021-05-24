package edu.hav.labs.service.decommissionedBook.impls;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  DecommissionedBookImpl
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.DecommissionedBook;
import edu.hav.labs.repository.decommissionedBook.DecommissionedBookRepository;
import edu.hav.labs.service.decommissionedBook.interfaces.IDecommissionedBook;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class DecommissionedBookImpl implements IDecommissionedBook {

    final
    DecommissionedBookRepository repository;

    public DecommissionedBookImpl(DecommissionedBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public DecommissionedBook getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public DecommissionedBook create(DecommissionedBook decommissionedBook) {
        return repository.save(decommissionedBook);
    }

    @Override
    public DecommissionedBook update(DecommissionedBook decommissionedBook) {
        return repository.save(decommissionedBook);
    }

    @Override
    public DecommissionedBook delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<DecommissionedBook> getAll() {
        return repository.findAll();
    }
}
