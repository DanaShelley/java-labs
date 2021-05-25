package edu.hav.labs.controller.rest;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  StaffRestController
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Membership;
import edu.hav.labs.model.Staff;
import edu.hav.labs.repository.bookLog.BookLogRepository;
import edu.hav.labs.service.staff.impls.StaffServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.bson.Document;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/staffs")
@Tag(name = "Staff", description = "Staff API")
public class StaffRestController {

    final
    StaffServiceImpl service;

    final BookLogRepository bookLogRepository;

    public StaffRestController(StaffServiceImpl service, BookLogRepository bookLogRepository) {
        this.service = service;
        this.bookLogRepository = bookLogRepository;
    }

    @Operation(summary = "Get all staffs")
    @GetMapping("/get/all")
    public List<Staff> getStaffs() {
        return service.getAll();
    }

    @Operation(summary = "Get staff by id")
    @GetMapping("/get/{id}")
    public Staff getById(@PathVariable("id") String id) {
        return service.getById(id);
    }

    @Operation(summary = "Delete staff by id")
    @DeleteMapping("/delete/{id}")
    public Staff deleteById(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @Operation(summary = "Add new staff")
    @PostMapping("/create/")
    public Staff create(@RequestBody Staff staff) {
        return service.create(staff);
    }

    @Operation(summary = "Edit staff by id")
    @PutMapping("/update/")
    public Staff update(@RequestBody Staff staff) {
        return service.update(staff);
    }

    @GetMapping("/get/count-served-memberships-by-staff-id/{id}")
    public Document countServedMembershipsByStaffId(@PathVariable("id") String id) {
        return service.countServedMembershipsByStaffId(id);
    }

    @GetMapping("/get/count-served-memberships")
    public List<Document> countServedMembershipsByStaffId() {
        Map<Staff, Integer> map = service.countServedMemberships();
        List<Document> list = new ArrayList<>();

        map.forEach((staff, integer) -> {
            list.add(new Document().append("staff", staff).append("count", integer));
        });
        return list;
    }
}
