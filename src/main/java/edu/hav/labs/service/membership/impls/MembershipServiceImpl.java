package edu.hav.labs.service.membership.impls;

import edu.hav.labs.model.Membership;
import edu.hav.labs.repository.membership.MembershipRepository;
import edu.hav.labs.service.membership.interfaces.IMembershipService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  MembershipServiceImpl
  @version  1.0.0 
  @since 20.04.2021
*/

@Service
@Component
public class MembershipServiceImpl implements IMembershipService {

    final
    MembershipRepository repository;

    public MembershipServiceImpl(MembershipRepository repository) {
        this.repository = repository;
    }

    @Override
    public Membership getById(String id) {
        return repository.findById(id)
                         .orElse(null);
    }

    @Override
    public Membership create(Membership membership) {
        return repository.save(membership);
    }

    @Override
    public Membership update(Membership membership) {
        return repository.save(membership);
    }

    @Override
    public Membership delete(String id) {
        repository.deleteById(id);
        return null;

    }

    @Override
    public List<Membership> getAll() {
        return repository.findAll();
    }
}
