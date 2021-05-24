package edu.hav.labs.controller.rest;
/*
  @author   Bohdana Havaleshko
  @project   
  @class  WritingRestController
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Writing;
import edu.hav.labs.service.writing.impls.WritingServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/writings")
@Tag(name = "Writing", description = "Writing API")
public class WritingRestController {

    final
    WritingServiceImpl service;

    public WritingRestController(WritingServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Get all writings")
    @GetMapping("/get/all")
    public List<Writing> getWritings(){
        return service.getAll();
    }

    @Operation(summary = "Get writing by id")
    @GetMapping("/get/{id}")
    public Writing getById(@PathVariable("id") String id ){
        return service.getById(id);
    }

    @Operation(summary = "Delete writing by id")
    @DeleteMapping("/delete/{id}")
    public Writing deleteById(@PathVariable("id") String id ){
        return service.delete(id);
    }

    @Operation(summary = "Add new writing")
    @PostMapping("/create/")
    public Writing create(@RequestBody Writing writing){
        return service.create(writing);
    }

    @Operation(summary = "Edit writing by id")
    @PutMapping("/update/")
    public Writing update(@RequestBody Writing writing){
        return service.update(writing);
    }
}
