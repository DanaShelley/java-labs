package edu.hav.labs.controller.rest;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  TeacherRestController
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Teacher;
import edu.hav.labs.service.teacher.impls.TeacherServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/teachers")
@Tag(name = "Teacher", description = "Teacher API")
public class TeacherRestController {

    final
    TeacherServiceImpl service;

    public TeacherRestController(TeacherServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Get all teachers")
    @GetMapping("/get/all")
    public List<Teacher> getTeachers(){
        return service.getAll();
    }

    @Operation(summary = "Get teacher by id")
    @GetMapping("/get/{id}")
    public Teacher getById(@PathVariable("id") String id ){
        return service.getById(id);
    }

    @Operation(summary = "Delete librateacherry by id")
    @DeleteMapping("/delete/{id}")
    public Teacher deleteById(@PathVariable("id") String id ){
        return service.delete(id);
    }

    @Operation(summary = "Add new teacher")
    @PostMapping("/create/")
    public Teacher create(@RequestBody Teacher teacher){
        return service.create(teacher);
    }

    @Operation(summary = "Edit teacher by id")
    @PutMapping("/update/")
    public Teacher update(@RequestBody Teacher teacher){
        return service.update(teacher);
    }

}
