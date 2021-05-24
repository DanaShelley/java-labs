package edu.hav.labs.service.readingRoom.impls;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  ReadingRoomServiceImpl
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.ReadingRoom;
import edu.hav.labs.repository.readingRoom.ReadingRoomRepository;
import edu.hav.labs.service.readingRoom.interfaces.IReadingRoomService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class ReadingRoomServiceImpl implements IReadingRoomService {

    final
    ReadingRoomRepository repository;


    public ReadingRoomServiceImpl(ReadingRoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public ReadingRoom getById(String id) {
        return repository.findById(id)
                         .orElse(null);
    }

    @Override
    public ReadingRoom create(ReadingRoom readingRoom) {
        return repository.save(readingRoom);
    }

    @Override
    public ReadingRoom update(ReadingRoom readingRoom) {
        return repository.save(readingRoom);
    }

    @Override
    public ReadingRoom delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<ReadingRoom> getAll() {
        return repository.findAll();
    }
}
