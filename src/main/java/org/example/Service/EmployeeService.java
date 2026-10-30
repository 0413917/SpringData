package org.example.Service;

import org.example.Employee;
import org.example.SpringData.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Optional<Employee> findById(long id) {
        return employeeRepo.findById(id);
    }

    public Optional<Employee> findBySalaryGreaterThan(String salary) {
        return employeeRepo.findBySalaryGreaterThan(salary);
    }


//    public List<Employee> findByDepartmentsId(long id){
//        return employeeRepo.findByDepartmentsId(id);
//    }


    public List<Employee> findEmployees(String employee_name, double salary) {
        return employeeRepo.findEmployees(employee_name, salary);
    }

//    Optional<Employee> findByDepartmentId(long id){
//        return employeeRepo.findByDepartmentId(id);
//    };


}
