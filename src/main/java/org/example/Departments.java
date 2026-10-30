package org.example;


import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Departments {

    //@OneToMany(mappedBy = "departments" ,fetch=FetchType.LAZY)
    ///private List<Employee> employees;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;


    public Departments() {

    }

    public Departments(String name) {
        this.name = name;
    }


    public long id() {
        return id;
    }

    public Departments setId(long id) {
        this.id = id;
        return this;
    }

    public String name() {
        return name;
    }

    public Departments setName(String name) {
        this.name = name;
        return this;
    }
}
