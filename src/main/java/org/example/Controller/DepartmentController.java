package org.example.Controller;

import org.example.Departments;
import org.example.Service.DepartmentsService;
import org.example.SpringData.DepartmentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController

@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private final DepartmentsService departmentsService;
    private DepartmentsRepo departmentsRepo;

    public DepartmentController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @PostMapping("/add")
    public Departments addDepartment(Departments departments) {
        return departmentsRepo.save(new Departments("Devops"));
    }

    @GetMapping("/findAll")
    public Iterable<Departments> getAllDepartments() {
        return departmentsService.getAllDepartments();
    }

    @GetMapping("/get/{id}")
    public Optional<Departments> getDepartmentById(@PathVariable Long id) {
        return Optional.of(departmentsService
                .getDepartmentById(id).get());
    }


    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentsService.deleteDepartment(id);
    }

}
