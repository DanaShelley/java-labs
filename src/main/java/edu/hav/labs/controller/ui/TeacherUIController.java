package edu.hav.labs.controller.ui;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  TeacherUIController
  @version  1.0.0 
  @since 25.04.2021
*/

import edu.hav.labs.form.TeacherForm;
import edu.hav.labs.model.Membership;
import edu.hav.labs.model.Teacher;
import edu.hav.labs.service.membership.impls.MembershipServiceImpl;
import edu.hav.labs.service.teacher.impls.TeacherServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/ui/teachers")
@Controller
public class TeacherUIController {

    final
    TeacherServiceImpl service;

    final
    MembershipServiceImpl membershipService;

    public TeacherUIController(TeacherServiceImpl service, MembershipServiceImpl membershipService) {
        this.service = service;
        this.membershipService = membershipService;
    }

    @RequestMapping("/get/all")
    public String showAll(Model model) {
        model.addAttribute("teachers", service.getAll());

        return "teacher/teacher-page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);

        return "redirect:/ui/teachers/get/all";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("teacherForm", new TeacherForm());
        model.addAttribute("memberships", new ArrayList<>(membershipService.getAll()));

        return "teacher/teacher-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("teacherForm") TeacherForm teacherForm) {
        Teacher teacher = new Teacher();
        Membership membership = membershipService.getById(teacherForm.getMembership());
        teacher.setMembership(membership);
        teacher.setLessons(teacherForm.getLessons());
        teacher.setSchool(teacherForm.getSchool());

        service.create(teacher);

        return "redirect:/ui/teachers/get/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id) {
        model.addAttribute("teacherForm", new TeacherForm());
        model.addAttribute("memberships", new ArrayList<>(membershipService.getAll()));
        model.addAttribute("teacher", service.getById(id));

        return "teacher/teacher-update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("teacherForm") TeacherForm teacherForm, @PathVariable String id) {
        Teacher teacher = new Teacher();
        teacher.setId(id);
        Membership membership = membershipService.getById(teacherForm.getMembership());
        teacher.setMembership(membership);
        teacher.setLessons(teacherForm.getLessons());
        teacher.setSchool(teacherForm.getSchool());

        service.update(teacher);

        return "redirect:/ui/teachers/get/all";
    }
}
