package edu.hav.labs.controller.ui;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  WorkerUIController
  @version  1.0.0 
  @since 25.04.2021
*/

import edu.hav.labs.form.TeacherForm;
import edu.hav.labs.form.WorkerForm;
import edu.hav.labs.model.Library;
import edu.hav.labs.model.Membership;
import edu.hav.labs.model.Worker;
import edu.hav.labs.service.library.impls.LibraryServiceImpl;
import edu.hav.labs.service.membership.impls.MembershipServiceImpl;
import edu.hav.labs.service.worker.impls.WorkerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/ui/workers")
@Controller
public class WorkerUIController {

    final
    WorkerServiceImpl service;

    final
    MembershipServiceImpl membershipService;

    final
    LibraryServiceImpl libraryService;

    public WorkerUIController(WorkerServiceImpl service, MembershipServiceImpl membershipService, LibraryServiceImpl libraryService) {
        this.service = service;
        this.membershipService = membershipService;
        this.libraryService = libraryService;
    }

    @RequestMapping("/get/all")
    public String showAll(Model model) {
        model.addAttribute("workers", service.getAll());

        return "worker/worker-page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);

        return "redirect:/ui/workers/get/all";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("workerForm", new WorkerForm());
        model.addAttribute("memberships", new ArrayList<>(membershipService.getAll()));
        model.addAttribute("libraries", new ArrayList<>(libraryService.getAll()));

        return "worker/worker-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("workerForm") WorkerForm workerForm) {
        Worker worker = new Worker();
        Membership membership = membershipService.getById(workerForm.getMembership());
        worker.setMembership(membership);
        Library library = libraryService.getById(workerForm.getLibrary());
        worker.setLibrary(library);
        worker.setWorkerId(workerForm.getWorkerId());

        service.create(worker);

        return "redirect:/ui/workers/get/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id) {
        model.addAttribute("workerForm", new TeacherForm());
        model.addAttribute("memberships", new ArrayList<>(membershipService.getAll()));
        model.addAttribute("libraries", new ArrayList<>(libraryService.getAll()));
        model.addAttribute("worker", service.getById(id));

        return "worker/worker-update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("workerForm") WorkerForm workerForm, @PathVariable String id) {
        Worker worker = new Worker();
        worker.setId(id);
        Membership membership = membershipService.getById(workerForm.getMembership());
        worker.setMembership(membership);
        Library library = libraryService.getById(workerForm.getLibrary());
        worker.setLibrary(library);
        worker.setWorkerId(workerForm.getWorkerId());

        service.update(worker);

        return "redirect:/ui/workers/get/all";
    }
}
