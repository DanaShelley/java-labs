package edu.hav.labs.controller.rest;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  ReadingRoomController
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.ReadingRoom;
import edu.hav.labs.service.readingRoom.impls.ReadingRoomServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reading-rooms")
@Tag(name = "Reading room", description = "Reading room API")
public class ReadingRoomRestController {

    final
    ReadingRoomServiceImpl service;

    public ReadingRoomRestController(ReadingRoomServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Get all reading rooms")
    @GetMapping("/get/all")
    public List<ReadingRoom> getReadingRoots(){
        return service.getAll();
    }

    @Operation(summary = "Get reading room by id")
    @GetMapping("/get/{id}")
    public ReadingRoom getById(@PathVariable("id") String id ){
        return service.getById(id);
    }

    @Operation(summary = "Delete reading room by id")
    @DeleteMapping("/delete/{id}")
    public ReadingRoom deleteById(@PathVariable("id") String id ){
        return service.delete(id);
    }

    @Operation(summary = "Add new reading room")
    @PostMapping("/create/")
    public ReadingRoom create(@RequestBody ReadingRoom readingRoom){
        return service.create(readingRoom);
    }

    @Operation(summary = "Edit reading room by id")
    @PutMapping("/update/")
    public ReadingRoom update(@RequestBody ReadingRoom readingRoom){
        return service.update(readingRoom);
    }

}
