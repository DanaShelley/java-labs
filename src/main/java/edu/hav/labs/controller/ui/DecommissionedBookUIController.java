package edu.hav.labs.controller.ui;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  DecommissionedBookUIController
  @version  1.0.0 
  @since 25.04.2021
*/

import edu.hav.labs.form.DecommissionedBookForm;
import edu.hav.labs.model.Book;
import edu.hav.labs.model.DecommissionedBook;
import edu.hav.labs.service.book.impls.BookServiceImpl;
import edu.hav.labs.service.decommissionedBook.impls.DecommissionedBookImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;


@RequestMapping("/ui/decommissioned-books")
@Controller
public class DecommissionedBookUIController {

    final
    DecommissionedBookImpl service;

    final
    BookServiceImpl bookService;

    public DecommissionedBookUIController(DecommissionedBookImpl service, BookServiceImpl bookService) {
        this.service = service;
        this.bookService = bookService;
    }

    @RequestMapping("/get/all")
    public String showAll(Model model) {
        model.addAttribute("decommissionedBooks", service.getAll());

        return "decommissionedBook/decommissionedBook-page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);

        return "redirect:/ui/decommissioned-books/get/all";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("decommissionedBookForm", new DecommissionedBookForm());
        model.addAttribute("books", new ArrayList<>(bookService.getAll()));

        return "decommissionedBook/decommissionedBook-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("decommissionedBookForm") DecommissionedBookForm decommissionedBookForm) {
        DecommissionedBook decommissionedBook = new DecommissionedBook();
        Book book = bookService.getById(decommissionedBookForm.getBook());
        decommissionedBook.setBook(book);
        decommissionedBook.setDateOfDecommission(LocalDate.parse(decommissionedBookForm.getDateOfDecommission()));
        decommissionedBook.setReason(decommissionedBookForm.getReason());

        service.create(decommissionedBook);

        return "redirect:/ui/decommissioned-books/get/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id) {
        model.addAttribute("books", new ArrayList<>(bookService.getAll()));
        model.addAttribute("decommissionedBookForm", new DecommissionedBookForm());
        model.addAttribute("decommissionedBook", service.getById(id));

        return "decommissionedBook/decommissionedBook-update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("decommissionedBookForm") DecommissionedBookForm decommissionedBookForm, @PathVariable String id) {
        DecommissionedBook decommissionedBook = new DecommissionedBook();
        decommissionedBook.setId(id);
        Book book = bookService.getById(decommissionedBookForm.getBook());
        decommissionedBook.setBook(book);
        decommissionedBook.setDateOfDecommission(LocalDate.parse(decommissionedBookForm.getDateOfDecommission()));
        decommissionedBook.setReason(decommissionedBookForm.getReason());

        service.create(decommissionedBook);

        return "redirect:/ui/decommissioned-books/get/all";
    }

}
