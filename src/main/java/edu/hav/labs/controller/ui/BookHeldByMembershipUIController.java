package edu.hav.labs.controller.ui;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  BookHeldByMembershipUIController
  @version  1.0.0 
  @since 25.04.2021
*/

import edu.hav.labs.form.BookHeldByMembershipForm;
import edu.hav.labs.model.Book;
import edu.hav.labs.model.BookHeldByMembership;
import edu.hav.labs.model.Membership;
import edu.hav.labs.model.Rule;
import edu.hav.labs.service.book.impls.BookServiceImpl;
import edu.hav.labs.service.bookHeldByMembership.impls.BookHeldByMembershipImpl;
import edu.hav.labs.service.membership.impls.MembershipServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RequestMapping("/ui/books-held-by-membership")
@Controller
public class BookHeldByMembershipUIController {

    final
    BookHeldByMembershipImpl service;

    final
    BookServiceImpl bookService;

    final
    MembershipServiceImpl membershipService;

    public BookHeldByMembershipUIController(BookHeldByMembershipImpl service, BookServiceImpl bookService, MembershipServiceImpl membershipService) {
        this.service = service;
        this.bookService = bookService;
        this.membershipService = membershipService;
    }

    @RequestMapping("/get/all")
    public String showAll(Model model) {
        model.addAttribute("booksHeldByMembership", service.getAll());

        return "bookHeldByMembership/bookHeldByMembership-page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);

        return "redirect:/ui/books-held-by-membership/get/all";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("bookHeldByMembershipForm", new BookHeldByMembershipForm());
        model.addAttribute("books", new ArrayList<>(bookService.getAll()));
        model.addAttribute("memberships", new ArrayList<>(membershipService.getAll()));

        return "bookHeldByMembership/bookHeldByMembership-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("bookHeldByMembershipForm") BookHeldByMembershipForm bookHeldByMembershipForm) {
        BookHeldByMembership bookHeldByMembership = new BookHeldByMembership();
        Book book = bookService.getById(bookHeldByMembershipForm.getBook());
        bookHeldByMembership.setBook(book);
        Membership membership = membershipService.getById(bookHeldByMembershipForm.getMembership());
        bookHeldByMembership.setMembership(membership);
        bookHeldByMembership.setDateOfLending(LocalDate.parse(bookHeldByMembershipForm.getDateOfLending()));

        if(book.getRule() == Rule.TERM7) {
            bookHeldByMembership.setDeliveryDate(bookHeldByMembership.getDateOfLending().plusDays(7));
        } else if (book.getRule() == Rule.TERM14) {
            bookHeldByMembership.setDeliveryDate(bookHeldByMembership.getDateOfLending().plusDays(14));
        } else if (book.getRule() == Rule.TERM30) {
            bookHeldByMembership.setDeliveryDate(bookHeldByMembership.getDateOfLending().plusDays(30));
        } else if (book.getRule() == Rule.READONLY) {
            bookHeldByMembership.setDeliveryDate(bookHeldByMembership.getDateOfLending());
        } else {
            bookHeldByMembership.setDeliveryDate(LocalDate.parse(bookHeldByMembershipForm.getDeliveryDate()));
        }

        service.create(bookHeldByMembership);

        return "redirect:/ui/books-held-by-membership/get/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id) {
        model.addAttribute("bookHeldByMembershipForm", new BookHeldByMembershipForm());
        model.addAttribute("books", new ArrayList<>(bookService.getAll()));
        model.addAttribute("memberships", new ArrayList<>(membershipService.getAll()));
        model.addAttribute("bookHeldByMembership", service.getById(id));


        return "bookHeldByMembership/bookHeldByMembership-update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("bookHeldByMembershipForm") BookHeldByMembershipForm bookHeldByMembershipForm, @PathVariable String id) {
        BookHeldByMembership bookHeldByMembership = new BookHeldByMembership();
        bookHeldByMembership.setId(id);
        Book book = bookService.getById(bookHeldByMembershipForm.getBook());
        bookHeldByMembership.setBook(book);
        Membership membership = membershipService.getById(bookHeldByMembershipForm.getMembership());
        bookHeldByMembership.setMembership(membership);
        bookHeldByMembership.setDateOfLending(LocalDate.parse(bookHeldByMembershipForm.getDateOfLending()));
        bookHeldByMembership.setDeliveryDate(LocalDate.parse(bookHeldByMembershipForm.getDeliveryDate()));

        service.update(bookHeldByMembership);

        return "redirect:/ui/books-held-by-membership/get/all";
    }


}
