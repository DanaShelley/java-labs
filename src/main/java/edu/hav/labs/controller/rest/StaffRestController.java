package edu.hav.labs.controller.rest;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  StaffRestController
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Staff;
import edu.hav.labs.service.staff.impls.StaffServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/staffs")
@Tag(name = "Staff", description = "Staff API")
public class StaffRestController {

    final
    StaffServiceImpl service;

    public StaffRestController(StaffServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Get all staffs")
    @GetMapping("/get/all")
    public List<Staff> getStaffs(){
        return service.getAll();
    }

    @Operation(summary = "Get staff by id")
    @GetMapping("/get/{id}")
    public Staff getById(@PathVariable("id") String id ){
        return service.getById(id);
    }

    @Operation(summary = "Delete staff by id")
    @DeleteMapping("/delete/{id}")
    public Staff deleteById(@PathVariable("id") String id ){
        return service.delete(id);
    }

    @Operation(summary = "Add new staff")
    @PostMapping("/create/")
    public Staff create(@RequestBody Staff staff){
        return service.create(staff);
    }

    @Operation(summary = "Edit staff by id")
    @PutMapping("/update/")
    public Staff update(@RequestBody Staff staff){
        return service.update(staff);
    }

}
