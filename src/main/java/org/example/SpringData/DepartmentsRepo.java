package org.example.SpringData;

import org.example.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepo extends JpaRepository<Departments, Long> {


    // Optional<Departments>  findByName(String name );

}
