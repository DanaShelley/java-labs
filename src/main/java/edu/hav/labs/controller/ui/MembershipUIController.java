package edu.hav.labs.controller.ui;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  MembershipUIController
  @version  1.0.0 
  @since 25.04.2021
*/

import edu.hav.labs.form.MembershipForm;
import edu.hav.labs.model.Library;
import edu.hav.labs.model.Membership;
import edu.hav.labs.service.library.impls.LibraryServiceImpl;
import edu.hav.labs.service.membership.impls.MembershipServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RequestMapping("/ui/memberships")
@Controller
public class MembershipUIController {

    final
    MembershipServiceImpl service;

    final
    LibraryServiceImpl libraryService;

    public MembershipUIController(MembershipServiceImpl service, LibraryServiceImpl libraryService) {
        this.service = service;
        this.libraryService = libraryService;
    }

    @RequestMapping("/get/all")
    public String showAll(Model model) {
        model.addAttribute("memberships", service.getAll());

        return "membership/membership-page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);

        return "redirect:/ui/memberships/get/all";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("membershipForm", new MembershipForm());
        model.addAttribute("libraries", new ArrayList<>(libraryService.getAll()));

        return "membership/membership-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("membershipForm") MembershipForm membershipForm) {
        Membership membership = new Membership();
        membership.setName(membershipForm.getName());
        membership.setPhone(membershipForm.getPhone());
        membership.setDateOfRegistration(LocalDate.parse(membershipForm.getDateOfRegistration()));
        membership.setIsValidUntil(membership.getDateOfRegistration().plusYears(10));
        Library library = libraryService.getById(membershipForm.getLibrary());
        membership.setLibrary(library);
        service.create(membership);

        return "redirect:/ui/memberships/get/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id) {
        model.addAttribute("libraries", new ArrayList<>(libraryService.getAll()));
        model.addAttribute("membershipForm", new MembershipForm());
        model.addAttribute("membership", service.getById(id));

        return "membership/membership-update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("membershipForm") MembershipForm membershipForm, @PathVariable String id) {
        Membership membership = new Membership();
        membership.setId(id);
        membership.setName(membershipForm.getName());
        membership.setPhone(membershipForm.getPhone());
        Library library = libraryService.getById(membershipForm.getLibrary());
        membership.setLibrary(library);
        membership.setDateOfRegistration(LocalDate.parse(membershipForm.getDateOfRegistration()));
        membership.setIsValidUntil(LocalDate.parse(membershipForm.getIsValidUntil()));
        service.update(membership);

        return "redirect:/ui/memberships/get/all";
    }
}
