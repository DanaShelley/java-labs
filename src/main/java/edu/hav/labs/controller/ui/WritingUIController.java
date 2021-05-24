package edu.hav.labs.controller.ui;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  WritingUIController
  @version  1.0.0 
  @since 25.04.2021
*/

import edu.hav.labs.form.WritingForm;
import edu.hav.labs.model.Writing;
import edu.hav.labs.service.writing.impls.WritingServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RequestMapping("ui/writings")
@Controller
public class WritingUIController {

    final
    WritingServiceImpl service;

    public WritingUIController(WritingServiceImpl service) {
        this.service = service;
    }

    @RequestMapping("/get/all")
    public String showAll(Model model){
        model.addAttribute("writings", service.getAll());
        return "writing/writing-page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        service.delete(id);
        return "redirect:/ui/writings/get/all";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("writingForm", new WritingForm());

        return "writing/writing-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("writingForm") WritingForm writingForm){
        Writing writing = new Writing();
        writing.setName(writingForm.getName());

        String[] str = writingForm.getAuthors().split(",");

        writing.setAuthors(Arrays.asList(str));
        writing.setYearOfWriting(Integer.parseInt(writingForm.getYearOfWriting()));
        writing.setNumberOfPages(Integer.parseInt(writingForm.getNumberOfPages()));
        writing.setGenre(writingForm.getGenre());
        writing.setCategory(writingForm.getCategory());

        service.create(writing);
        return "redirect:/ui/writings/get/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id){

        model.addAttribute("writingForm", new WritingForm());
        model.addAttribute("writing", service.getById(id));
        model.addAttribute("authors", String.join(", ", service.getById(id).getAuthors()));
        model.addAttribute("yearOfWriting", String.valueOf(service.getById(id).getYearOfWriting())) ;
        model.addAttribute("numberOfPages", String.valueOf(service.getById(id).getNumberOfPages()));

        return "writing/writing-update";
    }

    //TODO: метод для коду, що повторюється
    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("writingForm") WritingForm writingForm, @PathVariable String id) {

        Writing writing = new Writing();
        writing.setId(id);
        writing.setName(writingForm.getName());

        String[] str = writingForm.getAuthors().split(",");

        writing.setAuthors(Arrays.asList(str));
        writing.setYearOfWriting(Integer.parseInt(writingForm.getYearOfWriting()));
        writing.setNumberOfPages(Integer.parseInt(writingForm.getNumberOfPages()));
        writing.setGenre(writingForm.getGenre());
        writing.setCategory(writingForm.getCategory());

        service.update(writing);

        return "redirect:/ui/writings/get/all";
    }
}
