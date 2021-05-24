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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequestMapping("ui/libraries")
@Controller
public class LibraryUiController {

    final
    LibraryServiceImpl service;

    public LibraryUiController(LibraryServiceImpl service) {
        this.service = service;
    }

    @RequestMapping("/get/all")
    public String showAll(Model model) {
        model.addAttribute("libraries", service.getAll());

        return "library/library-page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "redirect:/ui/libraries/get/all";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("libraryForm", new LibraryForm());

        return "library/library-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("libraryForm") LibraryForm libraryForm) {
        Library library = new Library();
        library.setName(libraryForm.getName());
        library.setAddress(libraryForm.getAddress());
        library.setNumberOfBooks(Integer.parseInt(libraryForm.getNumberOfBooks()));
        library.setNumberOfMembership(Integer.parseInt(libraryForm.getNumberOfMembership()));

        service.create(library);
        return "redirect:/ui/libraries/get/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id) {
        model.addAttribute("libraryForm", new LibraryForm());
        model.addAttribute("library", service.getById(id));
        model.addAttribute("numberOfMemberships", String.valueOf(service.getById(id).getNumberOfMembership()));
        model.addAttribute("numberOfBooks", String.valueOf(service.getById(id).getNumberOfBooks()));

        return "library/library-update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("libraryForm") LibraryForm libraryForm, @PathVariable String id) {
        Library library = new Library();
        library.setId(id);
        library.setName(libraryForm.getName());
        library.setAddress(libraryForm.getAddress());
        library.setNumberOfBooks(Integer.parseInt(libraryForm.getNumberOfBooks()));
        library.setNumberOfMembership(Integer.parseInt(libraryForm.getNumberOfMembership()));

        service.update(library);

        return "redirect:/ui/libraries/get/all";
    }
}
