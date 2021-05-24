package edu.hav.labs.controller.rest;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  PositionRestController
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Position;
import edu.hav.labs.service.position.impls.PositionServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/positions")
@Tag(name = "Position", description = "Position API")
public class PositionRestController {

    final
    PositionServiceImpl service;

    public PositionRestController(PositionServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Get all positions")
    @GetMapping("/get/all")
    public List<Position> getPositions(){
        return service.getAll();
    }

    @Operation(summary = "Get position by id")
    @GetMapping("/get/{id}")
    public Position getById(@PathVariable("id") String id ){
        return service.getById(id);
    }

    @Operation(summary = "Delete position by id")
    @DeleteMapping("/delete/{id}")
    public Position deleteById(@PathVariable("id") String id ){
        return service.delete(id);
    }

    @Operation(summary = "Add new position")
    @PostMapping("/create/")
    public Position create(@RequestBody Position position){
        return service.create(position);
    }

    @Operation(summary = "Edit position by id")
    @PutMapping("/update/")
    public Position update(@RequestBody Position position){
        return service.update(position);
    }

}
