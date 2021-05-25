package edu.hav.labs.service.edition.impls;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  EditionServiceImpl
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Edition;
import edu.hav.labs.repository.bookLog.BookLogRepository;
import edu.hav.labs.repository.edition.EditionRepository;
import edu.hav.labs.service.edition.interfaces.IEditionService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class EditionServiceImpl implements IEditionService {

    final
    EditionRepository repository;

    final BookLogRepository bookLogRepository;

    public EditionServiceImpl(EditionRepository repository, BookLogRepository bookLogRepository) {
        this.repository = repository;
        this.bookLogRepository = bookLogRepository;
    }

    @Override
    public Edition getById(String id) {
        return repository.findById(id)
                         .orElse(null);
    }

    @Override
    public Edition create(Edition edition) {
        return repository.save(edition);
    }

    @Override
    public Edition update(Edition edition) {
        return repository.save(edition);
    }

    @Override
    public Edition delete(String id) {
        repository.deleteById(id);
        return null;

    }

    @Override
    public List<Edition> getAll() {
        return repository.findAll();
    }

    @Override
    public List<String> findEditionNameThatMembershipTakesBetweenDates(String id, LocalDate date1, LocalDate date2) {
        List<String> list = new ArrayList<>();
        bookLogRepository.findAllByMembership_IdAndDateBetweenOrDateEqualsOrDateEquals(id, date1, date2, date1, date2)
                         .forEach(bookLog -> {
                             list.add(bookLog.getBook().getEdition().getName());
                         });
        return list;
    }

    @Override
    public List<Edition> findEditionThatMembershipTakesBetweenDatesFromLibrary(String membershipId, String libraryId, LocalDate date1, LocalDate date2) {
        List<Edition> list = new ArrayList<>();
        bookLogRepository.findAllByMembership_IdAndBook_StorageRoom_Library_IdAndDateBetweenOrDateEqualsOrDateEquals(membershipId, libraryId, date1, date2, date1, date2)
                         .forEach(bookLog -> {
                             list.add(bookLog.getBook().getEdition());
                         });
        return list;
    }
}
