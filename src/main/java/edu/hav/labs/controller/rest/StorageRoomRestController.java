package edu.hav.labs.controller.rest;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  StorageRoomRestController
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.StorageRoom;
import edu.hav.labs.service.storageRoom.impls.StorageRoomServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/storage-rooms")
@Tag(name = "Storage room", description = "Storage room API")
public class StorageRoomRestController {

    final
    StorageRoomServiceImpl service;

    public StorageRoomRestController(StorageRoomServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Get all storage rooms")
    @GetMapping("/get/all")
    public List<StorageRoom> getStorageRooms(){
        return service.getAll();
    }

    @Operation(summary = "Get storage room by id")
    @GetMapping("/get/{id}")
    public StorageRoom getById(@PathVariable("id") String id ){
        return service.getById(id);
    }

    @Operation(summary = "Delete storage room by id")
    @DeleteMapping("/delete/{id}")
    public StorageRoom deleteById(@PathVariable("id") String id ){
        return service.delete(id);
    }

    @Operation(summary = "Add new storage room")
    @PostMapping("/create/")
    public StorageRoom create(@RequestBody StorageRoom storageRoom){
        return service.create(storageRoom);
    }

    @Operation(summary = "Edit storage room by id")
    @PutMapping("/update/")
    public StorageRoom update(@RequestBody StorageRoom storageRoom){
        return service.update(storageRoom);
    }

}
