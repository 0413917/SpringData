package org.example;

import org.example.SpringData.DepartmentsRepo;
import org.example.SpringData.EmployeeRepo;
import org.example.SpringData.UserRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Startup implements CommandLineRunner {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private DepartmentsRepo departmentsRepo;

    @Override
    public void run(String @NotNull ... args) throws Exception {
        if (departmentsRepo.findAll().isEmpty() && employeeRepo.findAll().isEmpty()) {

            employeeRepo.save(new Employee("Rooney", "1000"));
            departmentsRepo.save(new Departments("AI"));

            Departments departments = new Departments();
            departments.setName("It");
            departmentsRepo.save(departments);
        }

if (userRepo.findAll().isEmpty()){

    User user1 = new User();
    user1.setUser_name("ano344@");
    user1.setPassword("345939");
    userRepo.save(user1);
}
    }
}
