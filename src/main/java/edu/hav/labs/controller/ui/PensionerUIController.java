package edu.hav.labs.controller.ui;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  PensionerUIController
  @version  1.0.0 
  @since 25.04.2021
*/

import edu.hav.labs.form.PensionerForm;
import edu.hav.labs.model.Membership;
import edu.hav.labs.model.Pensioner;
import edu.hav.labs.service.membership.impls.MembershipServiceImpl;
import edu.hav.labs.service.pensioner.impls.PensionerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/ui/pensioners")
@Controller
public class PensionerUIController {

    final
    PensionerServiceImpl service;

    final
    MembershipServiceImpl membershipService;

    public PensionerUIController(PensionerServiceImpl service, MembershipServiceImpl membershipService) {
        this.service = service;
        this.membershipService = membershipService;
    }

    @RequestMapping("/get/all")
    public String showAll(Model model) {
        model.addAttribute("pensioners", service.getAll());

        return "pensioner/pensioner-page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);

        return "redirect:/ui/pensioners/get/all";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pensionerForm", new PensionerForm());
        model.addAttribute("memberships", new ArrayList<>(membershipService.getAll()));

        return "pensioner/pensioner-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("pensionerForm") PensionerForm pensionerForm) {
        Pensioner pensioner = new Pensioner();
        Membership membership = membershipService.getById(pensionerForm.getMembership());
        pensioner.setMembership(membership);
        pensioner.setPensionerId(pensionerForm.getPensionerId());
        pensioner.setAge(Integer.parseInt(pensionerForm.getAge()));

        service.create(pensioner);

        return "redirect:/ui/pensioners/get/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id) {
        model.addAttribute("pensionerForm", new PensionerForm());
        model.addAttribute("memberships", new ArrayList<>(membershipService.getAll()));
        model.addAttribute("pensioner", service.getById(id));

        return "pensioner/pensioner-update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("pensionerForm") PensionerForm pensionerForm, @PathVariable String id) {
        Pensioner pensioner = new Pensioner();
        pensioner.setId(id);
        Membership membership = membershipService.getById(pensionerForm.getMembership());
        pensioner.setMembership(membership);
        pensioner.setPensionerId(pensionerForm.getPensionerId());
        pensioner.setAge(Integer.parseInt(pensionerForm.getAge()));

        service.update(pensioner);

        return "redirect:/ui/pensioners/get/all";
    }
}
