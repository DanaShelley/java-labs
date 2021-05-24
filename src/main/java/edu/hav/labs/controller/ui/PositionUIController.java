package edu.hav.labs.controller.ui;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  PositionUIController
  @version  1.0.0 
  @since 25.04.2021
*/

import edu.hav.labs.form.PositionForm;
import edu.hav.labs.model.Position;
import edu.hav.labs.service.position.impls.PositionServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("ui/positions")
@Controller
public class PositionUIController {

    final
    PositionServiceImpl service;

    public PositionUIController(PositionServiceImpl service) {
        this.service = service;
    }

    @RequestMapping("/get/all")
    public String showAll(Model model) {
        model.addAttribute("positions", service.getAll());

        return "position/position-page";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);

        return "redirect:/ui/positions/get/all";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("positionForm", new PositionForm());

        return "position/position-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("positionForm") PositionForm positionForm) {
        Position position = new Position();
        position.setPosition(positionForm.getPosition());
        position.setSalary(Integer.parseInt(positionForm.getSalary()));

        service.create(position);
        return "redirect:/ui/positions/get/all";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable String id) {
        model.addAttribute("position", service.getById(id));
        model.addAttribute("positionForm", new PositionForm());
        model.addAttribute("salary", String.valueOf(service.getById(id).getSalary())) ;


        return "position/position-update";
    }

    @PostMapping("/update/{id}")
    public String update(Model model,

                         @ModelAttribute("libraryForm") PositionForm positionForm, @PathVariable String id) {

        Position position = new Position();
        position.setId(id);
        position.setPosition(positionForm.getPosition());
        position.setSalary(Integer.parseInt(positionForm.getSalary()));

        service.update(position);

        return "redirect:/ui/positions/get/all";
    }
}
