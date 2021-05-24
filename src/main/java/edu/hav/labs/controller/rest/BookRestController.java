package edu.hav.labs.controller.rest;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  BookRestController
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Book;
import edu.hav.labs.service.book.impls.BookServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
@Tag(name = "Book", description = "Book API")
public class BookRestController {

    final
    BookServiceImpl service;

    public BookRestController(BookServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Get all books")
    @GetMapping("/get/all")
    public List<Book> getBooks(){
        return service.getAll();
    }

    @Operation(summary = "Get book by id")
    @GetMapping("/get/{id}")
    public Book getById(@PathVariable("id") String id ){
        return service.getById(id);
    }

    @Operation(summary = "Delete book by id")
    @DeleteMapping("/delete/{id}")
    public Book deleteById(@PathVariable("id") String id ){
        return service.delete(id);
    }

    @Operation(summary = "Add new book")
    @PostMapping("/create/")
    public Book create(@RequestBody Book book){
        return service.create(book);
    }

    @Operation(summary = "Edit book by id")
    @PutMapping("/update/")
    public Book update(@RequestBody Book book){
        return service.update(book);
    }

}
