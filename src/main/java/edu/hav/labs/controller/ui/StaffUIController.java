package edu.hav.labs.controller.ui;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  StaffUIController
  @version  1.0.0 
  @since 25.04.2021
*/

import edu.hav.labs.form.StaffForm;
import edu.hav.labs.model.Library;
import edu.hav.labs.model.Position;
import edu.hav.labs.model.Staff;
import edu.hav.labs.service.library.impls.LibraryServiceImpl;
import edu.hav.labs.service.position.impls.PositionServiceImpl;
import edu.hav.labs.service.staff.impls.StaffServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RequestMapping("/ui/staffs")
@Controller
public class StaffUIController {

    final
    StaffServiceImpl service;

    final
    LibraryServiceImpl libraryService;

    final
    PositionServiceImpl positionService;

    public StaffUIController(StaffServiceImpl service, LibraryServiceImpl libraryService, PositionServiceImpl positionService) {
        this.service = service;
        this.libraryService = libraryService;
        this.positionService = positionService;
    }

    @RequestMapping("/get/all")
    public String showAll(Model model) {
        model.addAttribute("staffs", service.getAll());

        return "staff/staff-page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);

        return "redirect:/ui/staffs/get/all";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("staffForm", new StaffForm());
        model.addAttribute("libraries", new ArrayList<>(libraryService.getAll()));
        model.addAttribute("positions", new ArrayList<>(positionService.getAll()));

        return "staff/staff-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("studentForm") StaffForm staffForm) {
        Staff staff = new Staff();
        staff.setName(staffForm.getName());
        staff.setPhone(staffForm.getPhone());
        staff.setEmploymentDate(LocalDate.parse(staffForm.getEmploymentDate()));
        Library library = libraryService.getById(staffForm.getLibrary());
        Position position = positionService.getById(staffForm.getPosition());
        staff.setLibrary(library);
        staff.setPosition(position);
        service.create(staff);
        return "redirect:/ui/staffs/get/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id) {
        model.addAttribute("staff", service.getById(id));
        model.addAttribute("staffForm", new StaffForm());
        model.addAttribute("libraries", new ArrayList<>(libraryService.getAll()));
        model.addAttribute("positions", new ArrayList<>(positionService.getAll()));

        return "staff/staff-update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("membershipForm") StaffForm staffForm, @PathVariable String id) {
        Staff staff = new Staff();
        staff.setId(id);
        staff.setName(staffForm.getName());
        staff.setPhone(staffForm.getPhone());
        Library library = libraryService.getById(staffForm.getLibrary());
        Position position = positionService.getById(staffForm.getPosition());
        staff.setLibrary(library);
        staff.setPosition(position);
        staff.setEmploymentDate(LocalDate.parse(staffForm.getEmploymentDate()));

        service.update(staff);

        return "redirect:/ui/staffs/get/all";
    }
}
