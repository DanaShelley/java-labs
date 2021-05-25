package edu.hav.labs.controller.rest;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  StudentRestController
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Student;
import edu.hav.labs.service.student.impls.StudentServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
@Tag(name = "Student", description = "Student API")
public class StudentRestController {

    final
    StudentServiceImpl service;

    public StudentRestController(StudentServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Get all students")
    @GetMapping("/get/all")
    public List<Student> getStudents(){
        return service.getAll();
    }

    @Operation(summary = "Get student by id")
    @GetMapping("/get/{id}")
    public Student getById(@PathVariable("id") String id ){
        return service.getById(id);
    }

    @Operation(summary = "Delete student by id")
    @DeleteMapping("/delete/{id}")
    public Student deleteById(@PathVariable("id") String id ){
        return service.delete(id);
    }

    @Operation(summary = "Add new student")
    @PostMapping("/create/")
    public Student create(@RequestBody Student student){
        return service.create(student);
    }

    @Operation(summary = "Edit student by id")
    @PutMapping("/update/")
    public Student update(@RequestBody Student student){
        return service.update(student);
    }

    @GetMapping("/get/by-university/{university}")
    public List<Student> getStudentsByUniversity(@PathVariable("university") String university ){
        return service.getStudentsByUniversity(university);
    }

    @GetMapping("/get/by-faculty/{faculty}")
    public List<Student> getStudentsByFaculty(@PathVariable("faculty") String faculty ){
        return service.getStudentsByFaculty(faculty);
    }
}
