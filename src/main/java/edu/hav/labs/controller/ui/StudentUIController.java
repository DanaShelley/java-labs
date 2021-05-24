package edu.hav.labs.controller.ui;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  StudentUIController
  @version  1.0.0 
  @since 25.04.2021
*/


import edu.hav.labs.form.StudentForm;
import edu.hav.labs.model.Membership;
import edu.hav.labs.model.Student;
import edu.hav.labs.service.membership.impls.MembershipServiceImpl;
import edu.hav.labs.service.student.impls.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/ui/students")
@Controller
public class StudentUIController {

    final
    StudentServiceImpl service;

    final
    MembershipServiceImpl membershipService;

    public StudentUIController(StudentServiceImpl service, MembershipServiceImpl membershipService) {
        this.service = service;
        this.membershipService = membershipService;
    }

    @RequestMapping("/get/all")
    public String showAll(Model model) {
        model.addAttribute("students", service.getAll());

        return "student/student-page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);

        return "redirect:/ui/students/get/all";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("studentForm", new StudentForm());
        model.addAttribute("memberships", new ArrayList<>(membershipService.getAll()));

        return "student/student-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("studentForm") StudentForm studentForm) {
        Student student = new Student();
        Membership membership = membershipService.getById(studentForm.getMembership());
        student.setMembership(membership);
        student.setUniversity(studentForm.getUniversity());
        student.setFaculty(studentForm.getFaculty());
        student.setStudentId(studentForm.getStudentId());

        service.create(student);

        return "redirect:/ui/students/get/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id) {
        model.addAttribute("studentForm", new StudentForm());
        model.addAttribute("memberships", new ArrayList<>(membershipService.getAll()));
        model.addAttribute("student", service.getById(id));

        return "student/student-update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("studentForm") StudentForm studentForm, @PathVariable String id) {
        Student student = new Student();
        student.setId(id);
        Membership membership = membershipService.getById(studentForm.getMembership());
        student.setMembership(membership);
        student.setUniversity(studentForm.getUniversity());
        student.setFaculty(studentForm.getFaculty());
        student.setStudentId(studentForm.getStudentId());

        service.create(student);

        return "redirect:/ui/students/get/all";
    }
}
