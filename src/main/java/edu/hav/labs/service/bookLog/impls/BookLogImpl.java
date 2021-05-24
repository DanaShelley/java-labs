package edu.hav.labs.service.bookLog.impls;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  BookLogImpl
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.BookLog;
import edu.hav.labs.repository.bookLog.BookLogRepository;
import edu.hav.labs.service.bookLog.interfaces.IBookLogService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class BookLogImpl implements IBookLogService {

    final
    BookLogRepository repository;


    public BookLogImpl(BookLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public BookLog getById(String id) {
        return repository.findById(id)
                         .orElse(null);
    }

    @Override
    public BookLog create(BookLog bookLog) {
        return repository.save(bookLog);
    }

    @Override
    public BookLog update(BookLog bookLog) {
        return repository.save(bookLog);
    }

    @Override
    public BookLog delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<BookLog> getAll() {
        return repository.findAll();
    }
}
