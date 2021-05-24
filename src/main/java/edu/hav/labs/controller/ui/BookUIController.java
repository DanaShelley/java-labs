package edu.hav.labs.controller.ui;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  BookUIController
  @version  1.0.0 
  @since 25.04.2021
*/

import edu.hav.labs.form.BookForm;
import edu.hav.labs.model.*;
import edu.hav.labs.service.book.impls.BookServiceImpl;
import edu.hav.labs.service.edition.impls.EditionServiceImpl;
import edu.hav.labs.service.membership.impls.MembershipServiceImpl;
import edu.hav.labs.service.storageRoom.impls.StorageRoomServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("ui/books")
@Controller
public class BookUIController {

    final
    BookServiceImpl service;

    final
    EditionServiceImpl editionService;

    final
    MembershipServiceImpl membershipService;

    final
    StorageRoomServiceImpl storageRoomService;

    public BookUIController(BookServiceImpl service, EditionServiceImpl editionService, MembershipServiceImpl membershipService, StorageRoomServiceImpl storageRoomService) {
        this.service = service;
        this.editionService = editionService;
        this.membershipService = membershipService;
        this.storageRoomService = storageRoomService;
    }

    @RequestMapping("/get/all")
    public String showAll(Model model) {
        model.addAttribute("books", service.getAll());

        return "book/book-page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "redirect:/ui/books/get/all";
    }

    @GetMapping("/create")
    public String create(Model model) {

        List<String> enumList = Arrays.stream(Rule.class.getEnumConstants()).map(Rule::getRule).collect(Collectors.toList());
        model.addAttribute("bookForm", new BookForm());
        model.addAttribute("editions", new ArrayList<>(editionService.getAll()));
        model.addAttribute("memberships", new ArrayList<>(membershipService.getAll()));
        model.addAttribute("storageRooms", new ArrayList<>(storageRoomService.getAll()));
        model.addAttribute("rules", enumList);


        return "book/book-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("bookForm") BookForm bookForm) {
        Book book = new Book();
        Edition edition = editionService.getById(bookForm.getEdition());
        book.setEdition(edition);
        Membership membership = membershipService.getById(bookForm.getMembership());
        book.setMembership(membership);
        Rule[] rules = Rule.class.getEnumConstants();

        for (Rule rule : rules) {
            if (rule.getRule().equals(bookForm.getRule())) {
                book.setRule(rule);
            }
        }

        StorageRoom storageRoom = storageRoomService.getById(bookForm.getStorageRoom());
        book.setStorageRoom(storageRoom);
        book.setStellageNumber(Integer.parseInt(bookForm.getStellageNumber()));
        book.setShelveNumber(Integer.parseInt(bookForm.getShelveNumber()));
        book.setDateOdReceipt(LocalDate.parse(bookForm.getDateOfReceipt()));
        if (bookForm.getIsDecommissioned().equals("on")) {
            book.setDecommissioned(true);
        }

        service.create(book);

        return "redirect:/ui/books/get/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id) {
        List<String> enumList = Arrays.stream(Rule.class.getEnumConstants()).map(Rule::getRule).collect(Collectors.toList());
        model.addAttribute("bookForm", new BookForm());
        model.addAttribute("editions", new ArrayList<>(editionService.getAll()));
        model.addAttribute("memberships", new ArrayList<>(membershipService.getAll()));
        model.addAttribute("storageRooms", new ArrayList<>(storageRoomService.getAll()));
        model.addAttribute("rules", enumList);
        model.addAttribute("book", service.getById(id));

        return "book/book-update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("bookForm")BookForm bookForm, @PathVariable String id) {
        Book book = new Book();
        book.setId(id);
        Edition edition = editionService.getById(bookForm.getEdition());
        book.setEdition(edition);
        Membership membership = membershipService.getById(bookForm.getMembership());
        book.setMembership(membership);
        Rule[] rules = Rule.class.getEnumConstants();

        for (Rule rule : rules) {
            if (rule.getRule().equals(bookForm.getRule())) {
                book.setRule(rule);
            }
        }

        StorageRoom storageRoom = storageRoomService.getById(bookForm.getStorageRoom());
        book.setStorageRoom(storageRoom);
        book.setStellageNumber(Integer.parseInt(bookForm.getStellageNumber()));
        book.setShelveNumber(Integer.parseInt(bookForm.getShelveNumber()));
        book.setDateOdReceipt(LocalDate.parse(bookForm.getDateOfReceipt()));
        if (bookForm.getIsDecommissioned().equals("on")) {
            book.setDecommissioned(true);
        }

        service.create(book);

        return "redirect:/ui/books/get/all";

    }
}
