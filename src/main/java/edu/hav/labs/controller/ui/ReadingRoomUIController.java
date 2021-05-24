package edu.hav.labs.controller.ui;

import edu.hav.labs.form.ReadingRoomForm;
import edu.hav.labs.model.Library;
import edu.hav.labs.model.ReadingRoom;
import edu.hav.labs.model.Staff;
import edu.hav.labs.service.library.impls.LibraryServiceImpl;
import edu.hav.labs.service.readingRoom.impls.ReadingRoomServiceImpl;
import edu.hav.labs.service.staff.impls.StaffServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  ReadingRoomUIController
  @version  1.0.0 
  @since 25.04.2021
*/
@RequestMapping("ui/reading-rooms")
@Controller
public class ReadingRoomUIController {

    final
    ReadingRoomServiceImpl service;

    final
    LibraryServiceImpl libraryService;

    final
    StaffServiceImpl staffService;

    public ReadingRoomUIController(ReadingRoomServiceImpl service, LibraryServiceImpl libraryService, StaffServiceImpl staffService) {
        this.service = service;
        this.libraryService = libraryService;
        this.staffService = staffService;
    }

    @RequestMapping("/get/all")
    public String showAll(Model model) {
        model.addAttribute("readingRooms", service.getAll());

        return "readingRoom/readingRoom-page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "redirect:/ui/reading-rooms/get/all";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("readingRoomForm", new ReadingRoomForm());
        model.addAttribute("libraries", new ArrayList<>(libraryService.getAll()));
        model.addAttribute("staffs", new ArrayList<>(staffService.getAll()));


        return "readingRoom/readingRoom-create";
    }

    @PostMapping("/create")
    public String create(Model model, @ModelAttribute("ReadingRoomForm") ReadingRoomForm readingRoomForm) {
        ReadingRoom readingRoom = new ReadingRoom();
        Library library = libraryService.getById(readingRoomForm.getLibrary());
        readingRoom.setLibrary(library);

        String[] str = readingRoomForm.getStaffs().split(",");

        List<Staff> staff = new ArrayList<>();

        for (String s : str) {
            staff.add(staffService.getById(s));
        }

        readingRoom.setStaffs(staff);
        readingRoom.setNumber(readingRoomForm.getNumber());


        service.create(readingRoom);
        return "redirect:/ui/reading-rooms/get/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id) {
        model.addAttribute("libraries", new ArrayList<>(libraryService.getAll()));
        model.addAttribute("staffs", new ArrayList<>(staffService.getAll()));
        model.addAttribute("readingRoomStaffs", service.getById(id).getStaffs());
        model.addAttribute("readingRoomForm", new ReadingRoomForm());
        model.addAttribute("readingRoom", service.getById(id));

        return "readingRoom/readingRoom-update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("ReadingRoomForm") ReadingRoomForm readingRoomForm, @PathVariable String id) {
        ReadingRoom readingRoom = new ReadingRoom();
        readingRoom.setId(id);
        readingRoom.setNumber(readingRoomForm.getNumber());
        Library library = libraryService.getById(readingRoomForm.getLibrary());
        readingRoom.setLibrary(library);

        String[] str = readingRoomForm.getStaffs().split(",");

        List<Staff> staff = new ArrayList<>();

        for (String s : str) {
            staff.add(staffService.getById(s));
        }

        readingRoom.setStaffs(staff);


        service.update(readingRoom);

        return "redirect:/ui/reading-rooms/get/all";
    }
}
