package edu.hav.labs.controller.rest;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  BookHeldByMembershipRestController
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.BookHeldByMembership;
import edu.hav.labs.service.bookHeldByMembership.impls.BookHeldByMembershipImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book-held-by-memberships")
@Tag(name = "Book held by membership", description = "Book held by membership API")
public class BookHeldByMembershipRestController {

    final
    BookHeldByMembershipImpl service;

    public BookHeldByMembershipRestController(BookHeldByMembershipImpl service) {
        this.service = service;
    }

    @Operation(summary = "Get all books held by membership")
    @GetMapping("/get/all")
    public List<BookHeldByMembership> getBookHeldByMemberships(){
        return service.getAll();
    }

    @Operation(summary = "Get book held by membership by id")
    @GetMapping("/get/{id}")
    public BookHeldByMembership getById(@PathVariable("id") String id ){
        return service.getById(id);
    }

    @Operation(summary = "Delete book held by membership by id")
    @DeleteMapping("/delete/{id}")
    public BookHeldByMembership deleteById(@PathVariable("id") String id ){
        return service.delete(id);
    }

    @Operation(summary = "Add new book held by membership")
    @PostMapping("/create/")
    public BookHeldByMembership create(@RequestBody BookHeldByMembership bookHeldByMembership){
        return service.create(bookHeldByMembership);
    }

    @Operation(summary = "Edit book held by membership by id")
    @PutMapping("/update/")
    public BookHeldByMembership update(@RequestBody BookHeldByMembership bookHeldByMembership){
        return service.update(bookHeldByMembership);
    }

    @GetMapping("/get/by-edition-id/{id}")
    public List<BookHeldByMembership> findAllByBook_Edition_Id(@PathVariable("id") String id ){
        return service.findAllByBook_Edition_Id(id);
    }

}
