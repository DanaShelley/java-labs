package edu.hav.labs.controller.rest;

import edu.hav.labs.model.Library;
import edu.hav.labs.service.library.impls.LibraryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Library Controller API", description = "Detailed description")
@RestController
@RequestMapping("api/libraries")
public class LibraryRestController {

    @Autowired
    LibraryServiceImpl service;

    @RequestMapping("/get/all")
    public List<Library> getStudents() {
        return service.getAll();
    }

    @Operation(summary = "Get library by id", description = "in UUID format")
    @GetMapping("/get/{id}")
    public Library getById(@PathVariable("id")
                               @Parameter(name = "Library id", description = "Warning! It is in UUID format")
                                       String id) {
        return service.getById(id);
    }

    @GetMapping("/delete/{id}")
    public Library deleteById(@PathVariable("id") String id) {
        return service.delete(id);
    }


    @Operation(summary = "Library creation", description = "id to be created is UUID type")
    @PostMapping("/create/")
    public Library create(@RequestBody Library library) {
        return service.create(library);
    }

    @PostMapping("/update/")
    public Library update(@RequestBody Library library) {
        return service.update(library);
    }
}
