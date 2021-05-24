package edu.hav.labs.service.storageRoom.impls;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  StorageRoomServiceImpl
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.StorageRoom;
import edu.hav.labs.repository.storageRoom.StorageRoomRepository;
import edu.hav.labs.service.storageRoom.interfaces.IStorageRoomService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class StorageRoomServiceImpl implements IStorageRoomService {

    final
    StorageRoomRepository repository;

    public StorageRoomServiceImpl(StorageRoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public StorageRoom getById(String id) {
        return repository.findById(id)
                         .orElse(null);
    }

    @Override
    public StorageRoom create(StorageRoom storageRoom) {
        return repository.save(storageRoom);
    }

    @Override
    public StorageRoom update(StorageRoom storageRoom) {
        return repository.save(storageRoom);
    }

    @Override
    public StorageRoom delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<StorageRoom> getAll() {
        return repository.findAll();
    }
}
