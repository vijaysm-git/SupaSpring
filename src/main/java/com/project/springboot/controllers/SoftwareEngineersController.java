package com.project.springboot.controllers;


import com.project.springboot.model.SoftwareEngineer;
import org.springframework.web.bind.annotation.*;
import com.project.springboot.services.SoftwareEngineerService;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineersController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineersController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getAllSoftwareEngineers(){
       return softwareEngineerService.getSoftwareEngineers();
    }
    @GetMapping("{id}")
    public SoftwareEngineer getAllSoftwareEngineersById(
            @PathVariable Integer id
    ){
        return softwareEngineerService.getSoftwareEngineerById(id);
    }

    @PostMapping
    public void addNewSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer){
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }
    @DeleteMapping("{id}")
    public void deleteSoftwareEngineer(@PathVariable Integer id) {
        softwareEngineerService.deleteSoftwareEngineer(id);
    }
    @PutMapping("{id}")
    public void updateSoftwareEngineer(@PathVariable Integer id, @RequestBody SoftwareEngineer softwareEngineer){
        softwareEngineerService.updateSoftwareEngineerById(id,softwareEngineer);
    }
}
