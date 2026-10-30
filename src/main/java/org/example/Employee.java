package org.example;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")

    private long employee_id;

    @Column(name = "employee_name")
    String employee_name;
    @Setter
    @Column(name = "salary")
    String salary;
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Departments departments;



    public Employee() {

    }

    public Employee(String employee_name, String salary) {
        this.employee_name = employee_name;
        this.salary = salary;
    }


    public void setEmployee_id() {
        this.employee_id=employee_id;

    }

    public void setEmployee_name() {
        this.employee_name = employee_name;
    }

    public void setSalary() {
        this.salary = salary;
    }

    public Long employee_id() {
        return employee_id;
    }

    public String employee_name() {
        return employee_name;
    }

    public String salary() {
        return salary;
    }
}


