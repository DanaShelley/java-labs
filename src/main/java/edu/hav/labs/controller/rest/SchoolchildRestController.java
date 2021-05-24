package edu.hav.labs.controller.rest;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  SchoolchildRestController
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Schoolchild;
import edu.hav.labs.service.schoolchild.impls.SchoolchildServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/schoolchildren")
@Tag(name = "Schoolchild", description = "Schoolchild API")
public class SchoolchildRestController {

    final
    SchoolchildServiceImpl service;

    public SchoolchildRestController(SchoolchildServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Get all schoolchildren")
    @GetMapping("/get/all")
    public List<Schoolchild> getSchoolchildren(){
        return service.getAll();
    }

    @Operation(summary = "Get schoolchild by id")
    @GetMapping("/get/{id}")
    public Schoolchild getById(@PathVariable("id") String id ){
        return service.getById(id);
    }

    @Operation(summary = "Delete schoolchild by id")
    @DeleteMapping("/delete/{id}")
    public Schoolchild deleteById(@PathVariable("id") String id ){
        return service.delete(id);
    }

    @Operation(summary = "Add new schoolchild")
    @PostMapping("/create/")
    public Schoolchild create(@RequestBody Schoolchild schoolchild){
        return service.create(schoolchild);
    }

    @Operation(summary = "Edit schoolchild by id")
    @PutMapping("/update/")
    public Schoolchild update(@RequestBody Schoolchild schoolchild){
        return service.update(schoolchild);
    }

}
