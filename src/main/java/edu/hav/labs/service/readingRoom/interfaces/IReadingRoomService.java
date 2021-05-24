package edu.hav.labs.service.readingRoom.interfaces;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  IReadingRoomService
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.ReadingRoom;

import java.util.List;

public interface IReadingRoomService {
    ReadingRoom getById(String id);
    ReadingRoom create(ReadingRoom readingRoom);
    ReadingRoom update(ReadingRoom readingRoom);
    ReadingRoom delete(String id);
    List<ReadingRoom> getAll();
}
