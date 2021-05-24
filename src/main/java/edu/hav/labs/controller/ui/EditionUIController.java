package edu.hav.labs.controller.ui;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  EditionUIController
  @version  1.0.0 
  @since 25.04.2021
*/

import edu.hav.labs.form.EditionForm;
import edu.hav.labs.model.Edition;
import edu.hav.labs.model.Writing;
import edu.hav.labs.service.edition.impls.EditionServiceImpl;
import edu.hav.labs.service.writing.impls.WritingServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("ui/editions")
@Controller
public class EditionUIController {

    final
    EditionServiceImpl service;

    final
    WritingServiceImpl writingService;

    public EditionUIController(EditionServiceImpl service, WritingServiceImpl writingService) {
        this.service = service;
        this.writingService = writingService;
    }

    @RequestMapping("/get/all")
    public String showAll(Model model) {
        model.addAttribute("editions", service.getAll());

        return "edition/edition-page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "redirect:/ui/editions/get/all";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("editionForm", new EditionForm());
        model.addAttribute("writings", new ArrayList<>(writingService.getAll()));

        return "edition/edition-create";
    }

    @PostMapping("/create")
    public String create(Model model, @ModelAttribute("editionForm") EditionForm editionForm) {
        Edition edition = new Edition();
        edition.setName(editionForm.getName());
        edition.setYear(Integer.parseInt(editionForm.getYear()));
        edition.setNumberOfPages(Integer.parseInt(editionForm.getNumberOfPages()));
        edition.setGenre(editionForm.getGenre());
        edition.setCategory(editionForm.getCategory());
        edition.setStockNumber(editionForm.getStockNumber());

        String[] str = editionForm.getWritings().split(",");

        List<Writing> writings = new ArrayList<>();

        for (String s : str) {
            writings.add(writingService.getById(s));
        }

        edition.setWritings(writings);


        service.create(edition);
        return "redirect:/ui/editions/get/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id) {
        model.addAttribute("year", String.valueOf(service.getById(id).getYear()));
        model.addAttribute("edition",  service.getById(id));
        model.addAttribute("editionForm",  new EditionForm());
        model.addAttribute("editionWritings", service.getById(id).getWritings());
        model.addAttribute("writings", new ArrayList<>(writingService.getAll()));

        return "edition/edition-update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("editionForm") EditionForm editionForm, @PathVariable String id) {
        Edition edition = new Edition();
        edition.setId(id);

        edition.setName(editionForm.getName());
        edition.setGenre(editionForm.getGenre());
        edition.setCategory(editionForm.getCategory());
        edition.setYear(Integer.parseInt(editionForm.getYear()));
        edition.setNumberOfPages(Integer.parseInt(editionForm.getNumberOfPages()));
        edition.setStockNumber(editionForm.getStockNumber());

        String[] str = editionForm.getWritings().split(",");

        List<Writing> writings = new ArrayList<>();

        for (String s : str) {
            writings.add(writingService.getById(s));
        }

        edition.setWritings(writings);


        service.update(edition);


        return "redirect:/ui/editions/get/all";
    }

}
