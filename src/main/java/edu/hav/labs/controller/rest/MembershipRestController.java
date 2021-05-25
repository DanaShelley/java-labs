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
import org.bson.Document;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Documented;
import java.time.LocalDate;
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


    @GetMapping("/get/all-serviced-by-staff/{id}/{date1}/{date2}")
    public List<Document> findEditionNameThatMembershipTakesBetweenDates(@PathVariable("id") String id, @PathVariable("date1") String date1, @PathVariable("date2") String date2){
        LocalDate parseDate1 = LocalDate.parse(date1);
        LocalDate parseDate2 = LocalDate.parse(date2);
        service.getMembershipsServiceByStaff(id, parseDate1, parseDate2);

        return service.getMembershipsServiceByStaff(id, parseDate1, parseDate2);
    }

    @GetMapping("/get/all-who-overdue-deadline")
    public List<Membership> getMembershipsWhoOverdueDeadLine() {
        return service.getMembershipsWhoOverdueDeadLine();
    }
}
