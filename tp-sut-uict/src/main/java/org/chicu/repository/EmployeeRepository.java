package org.chicu.repository;

import org.chicu.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // assume this is a complex query
    @Query(value = "SELECT * FROM T_EMPLOYEES WHERE USERNAME = 'USER-1'", nativeQuery = true)
    Employee findTopPerformerEmployee();

}
