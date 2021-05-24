package edu.hav.labs.controller.rest;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  LibraryRestController
  @version  1.0.0 
  @since 20.04.2021
*/


import edu.hav.labs.model.Library;
import edu.hav.labs.service.library.impls.LibraryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/libraries")
@Tag(name = "Library", description = "Library API")
public class LibraryRestController {

    final
    LibraryServiceImpl service;

    public LibraryRestController(LibraryServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Get all libraries")
    @GetMapping("/get/all")
    public List<Library> getLibraries(){
        return service.getAll();
    }

    @Operation(summary = "Get library by id")
    @GetMapping("/get/{id}")
    public Library getById(@PathVariable("id") @Parameter(name = "id", description = "ID of library to get", required = true) String id ){
        return service.getById(id);
    }

    @Operation(summary = "Delete library by id")
    @DeleteMapping("/delete/{id}")
    public Library deleteById(@PathVariable("id") @Parameter(name = "id", description = "ID of library to delete", required = true) String id ){
        return service.delete(id);
    }

    @Operation(summary = "Add new library")
    @PostMapping("/create/")
    public Library create(@RequestBody Library library){
        return service.create(library);
    }

    @Operation(summary = "Edit library")
    @PutMapping("/update/")
    public Library update(@RequestBody Library library){
        return service.update(library);
    }

}