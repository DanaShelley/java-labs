package edu.hav.labs.service.bookHeldByMembership.impls;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  BookHeldByMembershipImpl
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.BookHeldByMembership;
import edu.hav.labs.repository.bookHeldByMembership.BookHeldByMembershipRepository;
import edu.hav.labs.service.bookHeldByMembership.interfaces.IBookHeldByMembershipService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class BookHeldByMembershipImpl implements IBookHeldByMembershipService {

    final
    BookHeldByMembershipRepository repository;


    public BookHeldByMembershipImpl(BookHeldByMembershipRepository repository) {
        this.repository = repository;
    }

    @Override
    public BookHeldByMembership getById(String id) {
        return repository.findById(id)
                         .orElse(null);
    }

    @Override
    public BookHeldByMembership create(BookHeldByMembership bookHeldByMembership) {
        return repository.save(bookHeldByMembership);
    }

    @Override
    public BookHeldByMembership update(BookHeldByMembership bookHeldByMembership) {
        return repository.save(bookHeldByMembership);
    }

    @Override
    public BookHeldByMembership delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<BookHeldByMembership> getAll() {
        return repository.findAll();
    }

}
