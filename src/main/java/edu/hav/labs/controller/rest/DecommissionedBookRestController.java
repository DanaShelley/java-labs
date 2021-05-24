package edu.hav.labs.controller.rest;

import edu.hav.labs.model.DecommissionedBook;
import edu.hav.labs.service.decommissionedBook.impls.DecommissionedBookImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  DecommissionedBookRestController
  @version  1.0.0 
  @since 20.04.2021
*/

@RestController
@RequestMapping("api/decommissioned-books")
@Tag(name = "Decommissioned book", description = "Decommissioned book API")
public class DecommissionedBookRestController {

    final
    DecommissionedBookImpl service;

    public DecommissionedBookRestController(DecommissionedBookImpl service) {
        this.service = service;
    }

    @Operation(summary = "Get all decommissioned books")
    @GetMapping("/get/all")
    public List<DecommissionedBook> getDecommissionedBook(){
        return service.getAll();
    }

    @Operation(summary = "Get decommissioned book by id")
    @GetMapping("/get/{id}")
    public DecommissionedBook getById(@PathVariable("id") String id ){
        return service.getById(id);
    }

    @Operation(summary = "Delete decommissioned book by id")
    @DeleteMapping("/delete/{id}")
    public DecommissionedBook deleteById(@PathVariable("id") String id ){
        return service.delete(id);
    }

    @Operation(summary = "Add new decommissioned book")
    @PostMapping("/create/")
    public DecommissionedBook create(@RequestBody DecommissionedBook decommissionedBook){
        return service.create(decommissionedBook);
    }

    @Operation(summary = "Edit decommissioned book by id")
    @PutMapping("/update/")
    public DecommissionedBook update(@RequestBody DecommissionedBook decommissionedBook){
        return service.update(decommissionedBook);
    }

}
