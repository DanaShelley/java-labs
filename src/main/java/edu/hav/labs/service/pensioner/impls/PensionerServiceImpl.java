package edu.hav.labs.service.pensioner.impls;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  PensionerServiceImpl
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Pensioner;
import edu.hav.labs.repository.pensioner.PensionerRepository;
import edu.hav.labs.service.pensioner.interfaces.IPensionerService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class PensionerServiceImpl implements IPensionerService {

    final
    PensionerRepository repository;

    public PensionerServiceImpl(PensionerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pensioner getById(String id) {
        return repository.findById(id)
                         .orElse(null);
    }

    @Override
    public Pensioner create(Pensioner pensioner) {
        return repository.save(pensioner);
    }

    @Override
    public Pensioner update(Pensioner pensioner) {
        return repository.save(pensioner);
    }

    @Override
    public Pensioner delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Pensioner> getAll() {
        return repository.findAll();
    }
}
