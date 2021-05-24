package edu.hav.labs.controller.rest;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  WorkerRestController
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Worker;
import edu.hav.labs.service.worker.impls.WorkerServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/workers")
@Tag(name = "Worker", description = "Worker API")
public class WorkerRestController {

    final
    WorkerServiceImpl service;

    public WorkerRestController(WorkerServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Get all workers")
    @GetMapping("/get/all")
    public List<Worker> getWorkers(){
        return service.getAll();
    }

    @Operation(summary = "Get worker by id")
    @GetMapping("/get/{id}")
    public Worker getById(@PathVariable("id") String id ){
        return service.getById(id);
    }

    @Operation(summary = "Delete worker by id")
    @DeleteMapping("/delete/{id}")
    public Worker deleteById(@PathVariable("id") String id ){
        return service.delete(id);
    }

    @Operation(summary = "Add new worker")
    @PostMapping("/create/")
    public Worker create(@RequestBody Worker worker){
        return service.create(worker);
    }

    @Operation(summary = "Edit worker by id")
    @PutMapping("/update/")
    public Worker update(@RequestBody Worker worker){
        return service.update(worker);
    }

}
