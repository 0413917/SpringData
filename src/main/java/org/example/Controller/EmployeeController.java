package org.example.Controller;

import org.apache.coyote.ajp.AjpProcessor;
import org.example.Employee;
import org.example.SpringData.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@Component
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private final EmployeeRepo employeeRepo;

    public EmployeeController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    @GetMapping("/find")
    public Optional<Employee> find(@RequestParam Long employee_id) {
        return Optional.of(employeeRepo.findById(employee_id).get());
    }

    @GetMapping("/findAll")

    public Iterable<Employee> findAll() {
        return employeeRepo.findAll();

    }

    @GetMapping("/insert")

    public Employee add(Employee employee) {
        return employeeRepo.save(new Employee("mahmoud", "500"));
    }

    @GetMapping("/{employee_name}/{salary}")
    public Iterable<Employee> find(@PathVariable String employee_name, @PathVariable String salary) {
        return employeeRepo.findNameAndSalary(employee_name, salary);
    }

    @PostMapping("/add")
    private Employee create(@RequestBody Employee employee) {
        return employeeRepo.save(employee);
    }


    @DeleteMapping("/delete")
    private void deleteById(@RequestParam long employee_id) {
        employeeRepo.deleteById(employee_id);
    }


    @DeleteMapping("/filter")
    private void delete(@RequestParam Long employee_id) {
        employeeRepo.deleteById(employee_id);

    }


    @PutMapping("/modify")
    public int modify(@RequestBody Employee employee) {
        return employeeRepo.alter(employee);
    }


    @GetMapping("/{departmentId}")
    public List<Employee> findByDepartmentsId(@PathVariable(name = "departmentId") long id) {
        return employeeRepo.findByDepartmentsId(id);
    }


    @GetMapping("/findEmployee/{employee_name}/{salary}")
    public List<Employee> findEmployees(@PathVariable String employee_name, @PathVariable double salary) {
        return employeeRepo.findEmployees(employee_name, salary);
    }

@GetMapping("/search")
List<Employee> findContainingNameAndDepartmentName
        (@RequestParam String salary, @RequestParam String name) {
return employeeRepo.findBySalaryContainingAndDepartmentsNameContaining(salary,name);    };



}
