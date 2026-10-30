package org.example.Service;

import org.example.Departments;
import org.example.SpringData.DepartmentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DepartmentsService {
    @Autowired
    private final DepartmentsRepo departmentsRepo;

    public DepartmentsService(DepartmentsRepo departmentsRepo) {
        this.departmentsRepo = departmentsRepo;
    }


    //    public Departments insert(){
//        return departmentsRepo.save("IT")
//    }
    // Add Department
    public Departments addDepartment(Departments department) {
        return departmentsRepo.save(department);
    }


    // Get All Departments
    public List<Departments> getAllDepartments() {
        return departmentsRepo.findAll();
    }


    // Get Department By ID
    public Optional<Departments> getDepartmentById(Long id) {
        return departmentsRepo
                .findById(id);
    }

    // Delete Department
    public void deleteDepartment(Long id) {
        departmentsRepo.deleteById(id);
    }
}