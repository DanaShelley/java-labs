package edu.hav.labs.controller.rest;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  BookLogRestController
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.BookLog;
import edu.hav.labs.service.bookLog.impls.BookLogImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book-logs")
@Tag(name = "Book Log", description = "Book log API")
public class BookLogRestController {

    final
    BookLogImpl service;

    public BookLogRestController(BookLogImpl service) {
        this.service = service;
    }


    @Operation(summary = "Get all book logs")
    @GetMapping("/get/all")
    public List<BookLog> getBookLogs(){
        return service.getAll();
    }

    @Operation(summary = "Get book log by id")
    @GetMapping("/get/{id}")
    public BookLog getById(@PathVariable("id") String id ){
        return service.getById(id);
    }

    @Operation(summary = "Delete book log by id")
    @DeleteMapping("/delete/{id}")
    public BookLog deleteById(@PathVariable("id") String id ){
        return service.delete(id);
    }

    @Operation(summary = "Add new book log")
    @PostMapping("/create/")
    public BookLog create(@RequestBody BookLog bookLog){
        return service.create(bookLog);
    }

    @Operation(summary = "Edit book log by id")
    @PutMapping("/update/")
    public BookLog update(@RequestBody BookLog bookLog){
        return service.update(bookLog);
    }

}
