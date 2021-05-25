package edu.hav.labs.controller.rest;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  EditionRestController
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Edition;
import edu.hav.labs.service.edition.impls.EditionServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/editions")
@Tag(name = "Edition", description = "Edition API")
public class EditionRestController {

    final
    EditionServiceImpl service;

    public EditionRestController(EditionServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Get all editions")
    @GetMapping("/get/all")
    public List<Edition> getEditions(){
        return service.getAll();
    }

    @Operation(summary = "Get edition by id")
    @GetMapping("/get/{id}")
    public Edition getById(@PathVariable("id") String id ){
        return service.getById(id);
    }

    @Operation(summary = "Delete edition by id")
    @DeleteMapping("/delete/{id}")
    public Edition deleteById(@PathVariable("id") String id ){
        return service.delete(id);
    }

    @Operation(summary = "Add new edition")
    @PostMapping("/create/")
    public Edition create(@RequestBody Edition edition){
        return service.create(edition);
    }

    @Operation(summary = "Edit edition by id")
    @PutMapping("/update/")
    public Edition update(@RequestBody Edition edition){
        return service.update(edition);
    }

    @GetMapping("/get/by-membership-usage/{id}/{date1}/{date2}")
    public List<String> findEditionNameThatMembershipTakesBetweenDates(@PathVariable("id") String id, @PathVariable("date1") String date1, @PathVariable("date2") String date2 ){
        LocalDate parseDate1 = LocalDate.parse(date1);
        LocalDate parseDate2 = LocalDate.parse(date2);
        return service.findEditionNameThatMembershipTakesBetweenDates(id, parseDate1, parseDate2);
    }

    @GetMapping("/get/by-membership-usage/{membershipId}/by-library/{libraryId}/{date1}/{date2}")
    public List<Edition> findEditionThatMembershipTakesBetweenDatesFromLibrary(@PathVariable("membershipId") String membershipId, @PathVariable("libraryId") String libraryId,  @PathVariable("date1") String date1, @PathVariable("date2") String date2  ){
        LocalDate parseDate1 = LocalDate.parse(date1);
        LocalDate parseDate2 = LocalDate.parse(date2);
        return service.findEditionThatMembershipTakesBetweenDatesFromLibrary(membershipId, libraryId, parseDate1, parseDate2);
    }
}