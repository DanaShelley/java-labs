package edu.hav.labs.controller.ui;

/*
  @author   Havaleshko Bohdana
  @project   labs
  @version  1.0.0
  @since 13.04.2021
*/


import edu.hav.labs.form.LibraryForm;
import edu.hav.labs.model.Library;
import edu.hav.labs.service.library.impls.LibraryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("ui/libraries")
@Controller
public class LibraryUiController {

    @Autowired
    LibraryServiceImpl service;

    @RequestMapping("/get/all")
    public String showAll(Model model) {
        List<Library> libraries = service.getAll();
        model.addAttribute("libraries", libraries);

        return "libraries-page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id) {
        service.delete(id);
        return "redirect:/ui/libraries/get/all";
    }

    @GetMapping("/create")
    public String create(Model model) {
        LibraryForm libraryForm = new LibraryForm();
        libraryForm.setName(" ");
        model.addAttribute("libraryForm", libraryForm);

        return "library-create";
    }

    @PostMapping("/create")
    public String create(Model model,
                         @ModelAttribute("libraryForm") LibraryForm libraryForm) {
        Library library = new Library();
        library.setName(libraryForm.getName());
        library.setAddress(libraryForm.getAddress());
        library.setNumberOfBooks(libraryForm.getNumberOfBooks());
        library.setNumberOfMembership(libraryForm.getNumberOfMembership());

        service.create(library);
        return "redirect:/ui/libraries/get/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id) {
        LibraryForm libraryForm = new LibraryForm();
        libraryForm.setName(service.getById(id).getName());
        libraryForm.setAddress(service.getById(id).getAddress());
        libraryForm.setNumberOfBooks(service.getById(id).getNumberOfBooks());
        libraryForm.setNumberOfMembership(service.getById(id).getNumberOfMembership());
        model.addAttribute("libraryForm", libraryForm);

        return "library-update";
    }

    @PostMapping("/update/{id}")
    public String update(Model model,
                         @ModelAttribute("libraryForm") LibraryForm libraryForm, @PathVariable String id) {

        Library library = new Library();
        library.setId(id);
        library.setName(libraryForm.getName());
        library.setAddress(libraryForm.getAddress());
        library.setNumberOfBooks(libraryForm.getNumberOfBooks());
        library.setNumberOfMembership(libraryForm.getNumberOfMembership());

        service.update(library);
        return "redirect:/ui/libraries/get/all";
    }
}
