package edu.hav.labs.controller.ui;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  SchoolchildUIController
  @version  1.0.0 
  @since 25.04.2021
*/

import edu.hav.labs.form.SchoolchildForm;
import edu.hav.labs.model.Membership;
import edu.hav.labs.model.Schoolchild;
import edu.hav.labs.service.membership.impls.MembershipServiceImpl;
import edu.hav.labs.service.schoolchild.impls.SchoolchildServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/ui/schoolchildren")
@Controller
public class SchoolchildUIController {

    final
    SchoolchildServiceImpl service;

    final
    MembershipServiceImpl membershipService;

    public SchoolchildUIController(SchoolchildServiceImpl service, MembershipServiceImpl membershipService) {
        this.service = service;
        this.membershipService = membershipService;
    }

    @RequestMapping("/get/all")
    public String showAll(Model model) {
        model.addAttribute("schoolchildren", service.getAll());

        return "schoolchild/schoolchild-page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);

        return "redirect:/ui/schoolchildren/get/all";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("schoolchildren", new SchoolchildForm());
        model.addAttribute("memberships", new ArrayList<>(membershipService.getAll()));

        return "schoolchild/schoolchild-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("schoolchild") SchoolchildForm schoolchildForm) {
        Schoolchild schoolchild = new Schoolchild();
        Membership membership = membershipService.getById(schoolchildForm.getMembership());
        schoolchild.setMembership(membership);
        schoolchild.setSchool(schoolchildForm.getSchool());
        schoolchild.setGrade(Integer.parseInt(schoolchildForm.getGrade()));
        schoolchild.setAge(Integer.parseInt(schoolchildForm.getAge()));


        service.create(schoolchild);

        return "redirect:/ui/schoolchildren/get/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id) {
        model.addAttribute("schoolchildForm", new SchoolchildForm());
        model.addAttribute("memberships", new ArrayList<>(membershipService.getAll()));
        model.addAttribute("schoolchild", service.getById(id));

        return "schoolchild/schoolchild-update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("schoolchildForm") SchoolchildForm schoolchildForm, @PathVariable String id) {
        Schoolchild schoolchild = new Schoolchild();
        schoolchild.setId(id);
        Membership membership = membershipService.getById(schoolchildForm.getMembership());
        schoolchild.setMembership(membership);
        schoolchild.setSchool(schoolchildForm.getSchool());
        schoolchild.setGrade(Integer.parseInt(schoolchildForm.getGrade()));
        schoolchild.setAge(Integer.parseInt(schoolchildForm.getAge()));


        service.create(schoolchild);

        return "redirect:/ui/schoolchildren/get/all";
    }
}
