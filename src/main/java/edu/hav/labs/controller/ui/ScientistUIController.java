package edu.hav.labs.controller.ui;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  ScientistUIController
  @version  1.0.0 
  @since 25.04.2021
*/

import edu.hav.labs.form.ScientistForm;
import edu.hav.labs.model.Membership;
import edu.hav.labs.model.Scientist;
import edu.hav.labs.service.membership.impls.MembershipServiceImpl;
import edu.hav.labs.service.scientist.impls.ScientistServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/ui/scientists")
@Controller
public class ScientistUIController {

    final
    ScientistServiceImpl service;

    final
    MembershipServiceImpl membershipService;

    public ScientistUIController(ScientistServiceImpl service, MembershipServiceImpl membershipService) {
        this.service = service;
        this.membershipService = membershipService;
    }

    @RequestMapping("/get/all")
    public String showAll(Model model) {
        model.addAttribute("scientists", service.getAll());

        return "scientist/scientist-page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);

        return "redirect:/ui/scientists/get/all";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("scientistForm", new ScientistForm());
        model.addAttribute("memberships", new ArrayList<>(membershipService.getAll()));

        return "scientist/scientist-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("scientistForm") ScientistForm scientistForm) {
        Scientist scientist = new Scientist();
        Membership membership = membershipService.getById(scientistForm.getMembership());
        scientist.setMembership(membership);
        scientist.setNameOfOrganization(scientistForm.getNameOfOrganization());
        scientist.setSpecialization(scientistForm.getSpecialization());

        service.create(scientist);

        return "redirect:/ui/scientists/get/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id) {
        model.addAttribute("scientistForm", new ScientistForm());
        model.addAttribute("memberships", new ArrayList<>(membershipService.getAll()));
        model.addAttribute("scientist", service.getById(id));

        return "scientist/scientist-update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("scientistForm") ScientistForm scientistForm, @PathVariable String id) {
        Scientist scientist = new Scientist();
        scientist.setId(id);
        Membership membership = membershipService.getById(scientistForm.getMembership());
        scientist.setMembership(membership);
        scientist.setNameOfOrganization(scientistForm.getNameOfOrganization());
        scientist.setSpecialization(scientistForm.getSpecialization());

        service.update(scientist);

        return "redirect:/ui/scientists/get/all";
    }
}
