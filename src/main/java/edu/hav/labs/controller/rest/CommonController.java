package edu.hav.labs.controller.rest;

import edu.hav.labs.model.Student;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class CommonController {

    @RequestMapping(value = "/titulka/")
    public String ShowTitulka() {
        return "<h1>" + "id" + "</h1>";
    }

    @RequestMapping("/student")
    public Student getStudent(){
        Student student = new Student("kjdgh", "John", LocalDate.of(2000, 11,11));
        return student;
    }
}
