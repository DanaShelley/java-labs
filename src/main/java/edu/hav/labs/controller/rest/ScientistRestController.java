package edu.hav.labs.controller.rest;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  ScientistRestController
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Scientist;
import edu.hav.labs.service.scientist.impls.ScientistServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/scientists")
@Tag(name = "Scientist", description = "Scientist API")
public class ScientistRestController {

    final
    ScientistServiceImpl service;

    public ScientistRestController(ScientistServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Get all scientists")
    @GetMapping("/get/all")
    public List<Scientist> getScientists(){
        return service.getAll();
    }

    @Operation(summary = "Get scientist by id")
    @GetMapping("/get/{id}")
    public Scientist getById(@PathVariable("id") String id ){
        return service.getById(id);
    }

    @Operation(summary = "Delete scientist by id")
    @DeleteMapping("/delete/{id}")
    public Scientist deleteById(@PathVariable("id") String id ){
        return service.delete(id);
    }

    @Operation(summary = "Add new scientist")
    @PostMapping("/create/")
    public Scientist create(@RequestBody Scientist scientist){
        return service.create(scientist);
    }

    @Operation(summary = "Edit scientist by id")
    @PutMapping("/update/")
    public Scientist update(@RequestBody Scientist scientist){
        return service.update(scientist);
    }

}
