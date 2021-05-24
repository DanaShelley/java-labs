package edu.hav.labs.controller.rest;

import edu.hav.labs.model.Pensioner;
import edu.hav.labs.service.pensioner.impls.PensionerServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  PensionerRestController
  @version  1.0.0 
  @since 20.04.2021
*/

@RestController
@RequestMapping("api/pensioners")
@Tag(name = "Pensioner", description = "Pensioner API")
public class PensionerRestController {

    final
    PensionerServiceImpl service;

    public PensionerRestController(PensionerServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Get all pensioners")
    @GetMapping("/get/all")
    public List<Pensioner> getPensioners(){
        return service.getAll();
    }

    @Operation(summary = "Get pensioner by id")
    @GetMapping("/get/{id}")
    public Pensioner getById(@PathVariable("id") String id ){
        return service.getById(id);
    }

    @Operation(summary = "Delete pensioner by id")
    @DeleteMapping("/delete/{id}")
    public Pensioner deleteById(@PathVariable("id") String id ){
        return service.delete(id);
    }

    @Operation(summary = "Add new pensioner")
    @PostMapping("/create/")
    public Pensioner create(@RequestBody Pensioner pensioner){
        return service.create(pensioner);
    }

    @Operation(summary = "Edit pensioner by id")
    @PutMapping("/update/")
    public Pensioner update(@RequestBody Pensioner pensioner){
        return service.update(pensioner);
    }

}
