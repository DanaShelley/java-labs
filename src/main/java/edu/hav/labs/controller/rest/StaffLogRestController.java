package edu.hav.labs.controller.rest;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  StaffLogRestController
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.StaffLog;
import edu.hav.labs.service.staffLog.impls.StaffLogServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/staff-logs")
@Tag(name = "Staff log", description = "Staff log API")
public class StaffLogRestController {

    final
    StaffLogServiceImpl service;

    public StaffLogRestController(StaffLogServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Get all staff logs")
    @GetMapping("/get/all")
    public List<StaffLog> getStaffLogs(){
        return service.getAll();
    }

    @Operation(summary = "Get staff log by id")
    @GetMapping("/get/{id}")
    public StaffLog getById(@PathVariable("id") String id ){
        return service.getById(id);
    }

    @Operation(summary = "Delete staff log by id")
    @DeleteMapping("/delete/{id}")
    public StaffLog deleteById(@PathVariable("id") String id ){
        return service.delete(id);
    }

    @Operation(summary = "Add new staff log")
    @PostMapping("/create/")
    public StaffLog create(@RequestBody StaffLog staffLog){
        return service.create(staffLog);
    }

    @Operation(summary = "Edit staff log by id")
    @PutMapping("/update/")
    public StaffLog update(@RequestBody StaffLog staffLog){
        return service.update(staffLog);
    }

}
