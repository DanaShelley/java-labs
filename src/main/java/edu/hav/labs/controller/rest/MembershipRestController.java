package edu.hav.labs.controller.rest;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  MembershipRestController
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Membership;
import edu.hav.labs.service.membership.impls.MembershipServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/memberships")
@Tag(name = "Membership", description = "Membership API")
public class MembershipRestController {

    final
    MembershipServiceImpl service;

    public MembershipRestController(MembershipServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Get all memberships")
    @GetMapping("/get/all")
    public List<Membership> getMemberships(){
        return service.getAll();
    }

    @Operation(summary = "Get membership by id")
    @GetMapping("/get/{id}")
    public Membership getById(@PathVariable("id") String id ){
        return service.getById(id);
    }

    @Operation(summary = "Delete membership by id")
    @DeleteMapping("/delete/{id}")
    public Membership deleteById(@PathVariable("id") String id ){
        return service.delete(id);
    }

    @Operation(summary = "Add new membership")
    @PostMapping("/create/")
    public Membership create(@RequestBody Membership membership){
        return service.create(membership);
    }

    @Operation(summary = "Edit membership by id")
    @PutMapping("/update/")
    public Membership update(@RequestBody Membership membership){
        return service.update(membership);
    }
}
