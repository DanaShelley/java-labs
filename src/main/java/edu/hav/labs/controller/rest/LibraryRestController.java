package edu.hav.labs.controller.rest;

import edu.hav.labs.model.Library;
import edu.hav.labs.service.library.impls.LibraryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/libraries")
public class LibraryRestController {

    @Autowired
    LibraryServiceImpl service;

    @RequestMapping("/get/all")
    public List<Library> getStudents(){
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Library getById(@PathVariable("id") String id ){
        return service.getById(id);
    }

    @GetMapping("/delete/{id}")
    public Library deleteById(@PathVariable("id") String id ){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public Library create(@RequestBody Library library){
        return service.create(library);
    }

    @PostMapping("/update/")
    public Library update(@RequestBody Library library){
        return service.update(library);
    }
}
