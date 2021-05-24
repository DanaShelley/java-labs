package edu.hav.labs.service.storageRoom.interfaces;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  IStorageRoomService
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.StorageRoom;

import java.util.List;

public interface IStorageRoomService {
    StorageRoom getById(String id);
    StorageRoom create(StorageRoom storageRoom);
    StorageRoom update(StorageRoom storageRoom);
    StorageRoom delete(String id);
    List<StorageRoom> getAll();
}
