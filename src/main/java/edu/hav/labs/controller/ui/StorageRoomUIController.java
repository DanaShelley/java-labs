package edu.hav.labs.controller.ui;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  StorageRoomUIController
  @version  1.0.0 
  @since 25.04.2021
*/

import edu.hav.labs.form.StorageRoomForm;
import edu.hav.labs.model.Library;
import edu.hav.labs.model.Staff;
import edu.hav.labs.model.StorageRoom;
import edu.hav.labs.service.library.impls.LibraryServiceImpl;
import edu.hav.labs.service.staff.impls.StaffServiceImpl;
import edu.hav.labs.service.storageRoom.impls.StorageRoomServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("ui/storage-rooms")
@Controller
public class StorageRoomUIController {

    final
    StorageRoomServiceImpl service;

    final
    LibraryServiceImpl libraryService;

    final
    StaffServiceImpl staffService;

    public StorageRoomUIController(StorageRoomServiceImpl service, LibraryServiceImpl libraryService, StaffServiceImpl staffService) {
        this.service = service;
        this.libraryService = libraryService;
        this.staffService = staffService;
    }

    @RequestMapping("/get/all")
    public String showAll(Model model) {
        model.addAttribute("storageRooms", service.getAll());

        return "storageRoom/storageRoom-page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "redirect:/ui/storage-rooms/get/all";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("storageRoomForm", new StorageRoomForm());
        model.addAttribute("libraries", new ArrayList<>(libraryService.getAll()));
        model.addAttribute("staffs", new ArrayList<>(staffService.getAll()));


        return "storageRoom/storageRoom-create";
    }

    @PostMapping("/create")
    public String create(Model model, @ModelAttribute("StorageRoomForm") StorageRoomForm storageRoomForm) {
        StorageRoom storageRoom = new StorageRoom();
        Library library = libraryService.getById(storageRoomForm.getLibrary());
        storageRoom.setLibrary(library);

        String[] str = storageRoomForm.getStaffs().split(",");

        List<Staff> staff = new ArrayList<>();

        for (String s : str) {
            staff.add(staffService.getById(s));
        }

        storageRoom.setStaffs(staff);
        storageRoom.setNumber(storageRoomForm.getNumber());


        service.create(storageRoom);
        return "redirect:/ui/storage-rooms/get/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id) {
        model.addAttribute("libraries", new ArrayList<>(libraryService.getAll()));
        model.addAttribute("staffs", new ArrayList<>(staffService.getAll()));
        model.addAttribute("storageRoomStaffs", service.getById(id).getStaffs());
        model.addAttribute("storageRoomForm", new StorageRoomForm());
        model.addAttribute("storageRoom", service.getById(id));

        return "storageRoom/storageRoom-update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("StorageRoomForm") StorageRoomForm storageRoomForm, @PathVariable String id) {
        StorageRoom storageRoom = new StorageRoom();
        storageRoom.setId(id);
        storageRoom.setNumber(storageRoomForm.getNumber());
        Library library = libraryService.getById(storageRoomForm.getLibrary());
        storageRoom.setLibrary(library);

        String[] str = storageRoomForm.getStaffs().split(",");

        List<Staff> staff = new ArrayList<>();

        for (String s : str) {
            staff.add(staffService.getById(s));
        }

        storageRoom.setStaffs(staff);


        service.update(storageRoom);

        return "redirect:/ui/storage-rooms/get/all";
    }
}
