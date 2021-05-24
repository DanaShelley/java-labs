package edu.hav.labs.controller.ui;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  StaffLogUIController
  @version  1.0.0 
  @since 25.04.2021
*/

import edu.hav.labs.form.StaffLogForm;
import edu.hav.labs.model.ReadingRoom;
import edu.hav.labs.model.Staff;
import edu.hav.labs.model.StaffLog;
import edu.hav.labs.service.readingRoom.impls.ReadingRoomServiceImpl;
import edu.hav.labs.service.staff.impls.StaffServiceImpl;
import edu.hav.labs.service.staffLog.impls.StaffLogServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RequestMapping("/ui/staff-logs")
@Controller
public class StaffLogUIController {

    final
    StaffLogServiceImpl service;

    final
    StaffServiceImpl staffService;

    final
    ReadingRoomServiceImpl readingRoomService;

    public StaffLogUIController(StaffLogServiceImpl service, StaffServiceImpl staffService, ReadingRoomServiceImpl readingRoomService) {
        this.service = service;
        this.staffService = staffService;
        this.readingRoomService = readingRoomService;
    }

    @RequestMapping("/get/all")
    public String showAll(Model model) {
        model.addAttribute("staffLogs", service.getAll());

        return "staffLog/staffLog-page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);

        return "redirect:/ui/staff-log/get/all";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("staffLogForm", new StaffLogForm());
        model.addAttribute("staffs", new ArrayList<>(staffService.getAll()));
        model.addAttribute("readingRooms", new ArrayList<>(readingRoomService.getAll()));

        return "staffLog/staffLog-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("staffLogForm") StaffLogForm staffLogForm) {
        StaffLog staffLog = new StaffLog();
        Staff staff = staffService.getById(staffLogForm.getStaff());
        ReadingRoom readingRoom = readingRoomService.getById(staffLogForm.getReadingRoom());
        staffLog.setStaff(staff);
        System.out.println(staffLogForm.getEndDate());
        staffLog.setReadingRoom(readingRoom);
        if (!staffLogForm.getEndDate().equals("")) {
            staffLog.setEndDate(LocalDate.parse(staffLogForm.getEndDate()));
        } else {
            staffLog.setEndDate(null);
        }
        staffLog.setStartDate(LocalDate.parse(staffLogForm.getStartDate()));

        service.create(staffLog);

        return "redirect:/ui/staff-log/get/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id) {
        model.addAttribute("staffLogForm", new StaffLogForm());
        model.addAttribute("staffs", new ArrayList<>(staffService.getAll()));
        model.addAttribute("readingRooms", new ArrayList<>(readingRoomService.getAll()));
        model.addAttribute("staffLog", service.getById(id));

        return "staffLog/staffLog-update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("staffLog") StaffLogForm staffLogForm, @PathVariable String id) {
        StaffLog staffLog = new StaffLog();
        staffLog.setId(id);
        Staff staff = staffService.getById(staffLogForm.getStaff());
        ReadingRoom readingRoom = readingRoomService.getById(staffLogForm.getReadingRoom());
        staffLog.setStaff(staff);
        staffLog.setReadingRoom(readingRoom);
        staffLog.setStartDate(LocalDate.parse(staffLogForm.getStartDate()));
        if (!staffLogForm.getEndDate().equals("")) {
            staffLog.setEndDate(LocalDate.parse(staffLogForm.getEndDate()));
        } else {
            staffLog.setEndDate(null);
        }

        service.update(staffLog);

        return "redirect:/ui/staff-log/get/all";
    }
}
