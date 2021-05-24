package edu.hav.labs.controller.ui;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  BookLogUIController
  @version  1.0.0 
  @since 25.04.2021
*/

import edu.hav.labs.form.BookLogForm;
import edu.hav.labs.model.Book;
import edu.hav.labs.model.BookLog;
import edu.hav.labs.model.Membership;
import edu.hav.labs.model.Staff;
import edu.hav.labs.service.book.impls.BookServiceImpl;
import edu.hav.labs.service.bookLog.impls.BookLogImpl;
import edu.hav.labs.service.membership.impls.MembershipServiceImpl;
import edu.hav.labs.service.staff.impls.StaffServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RequestMapping("/ui/book-logs")
@Controller
public class BookLogUIController {

    final
    BookLogImpl service;

    final
    BookServiceImpl bookService;

    final
    MembershipServiceImpl membershipService;

    final
    StaffServiceImpl staffService;

    public BookLogUIController(BookLogImpl service, BookServiceImpl bookService, MembershipServiceImpl membershipService, StaffServiceImpl staffService) {
        this.service = service;
        this.bookService = bookService;
        this.membershipService = membershipService;
        this.staffService = staffService;
    }

    @RequestMapping("/get/all")
    public String showAll(Model model) {
        model.addAttribute("bookLogs", service.getAll());

        return "bookLog/bookLog-page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);

        return "redirect:/ui/book-logs/get/all";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("bookLogForm", new BookLogForm());
        model.addAttribute("books", new ArrayList<>(bookService.getAll()));
        model.addAttribute("memberships", new ArrayList<>(membershipService.getAll()));
        model.addAttribute("staffs", new ArrayList<>(staffService.getAll()));

        return "bookLog/bookLog-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("bookLogForm") BookLogForm bookLogForm) {
        BookLog bookLog = new BookLog();
        Book book = bookService.getById(bookLogForm.getBook());
        bookLog.setBook(book);
        Membership membership = membershipService.getById(bookLogForm.getMembership());
        bookLog.setMembership(membership);
        Staff staff = staffService.getById(bookLogForm.getStaff());
        bookLog.setStaff(staff);

        bookLog.setDate(LocalDate.parse(bookLogForm.getDate()));

        service.create(bookLog);

        return "redirect:/ui/book-logs/get/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id) {
        model.addAttribute("bookLogForm", new BookLogForm());
        model.addAttribute("books", new ArrayList<>(bookService.getAll()));
        model.addAttribute("memberships", new ArrayList<>(membershipService.getAll()));
        model.addAttribute("staffs", new ArrayList<>(staffService.getAll()));
        model.addAttribute("bookLog", service.getById(id));

        return "bookLog/bookLog-update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("bookLogForm") BookLogForm bookLogForm, @PathVariable String id) {
        BookLog bookLog = new BookLog();
        bookLog.setId(id);
        Book book = bookService.getById(bookLogForm.getBook());
        bookLog.setBook(book);
        Membership membership = membershipService.getById(bookLogForm.getMembership());
        bookLog.setMembership(membership);
        Staff staff = staffService.getById(bookLogForm.getStaff());
        bookLog.setStaff(staff);

        bookLog.setDate(LocalDate.parse(bookLogForm.getDate()));

        service.update(bookLog);

        return "redirect:/ui/book-logs/get/all";
    }
}
