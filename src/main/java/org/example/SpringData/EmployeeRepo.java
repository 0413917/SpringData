package org.example.SpringData;

import org.example.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@Component
public interface EmployeeRepo extends JpaRepository<Employee, Long> {


    @Query(value = "Select * from employees where employee_name like :employee_name And salary<=:salary", nativeQuery = true)
    Iterable<Employee> findNameAndSalary(@Param("employee_name") String employee_name, @Param("salary") String salary);


    Optional<Employee> findBySalaryGreaterThan(String salary);


    List<Employee> findByDepartmentsId(long id);


    @Query("SELECT e FROM Employee e " +
            "WHERE e.employee_name = :name " +
            "AND e.salary <= :salary")
    List<Employee> findEmployees(
            @Param("employee_name") String name,
            @Param("salary") double salary);

    @Modifying
    @Query(value = "UPDATE Employee emp  SET emp.employee_name =:name , emp.salary =:salary  WHERE emp.employee_id=:id", nativeQuery = false)
     int alter(@Param("emp")Employee employee) ;


  List<Employee>  findBySalaryContainingAndDepartmentsNameContaining
          (@Param("salary") String salary,@Param("name")   String name);

    //@Modifying         to update in database
//    @Query(value="")
//
//    Iterable<Employee>



}
