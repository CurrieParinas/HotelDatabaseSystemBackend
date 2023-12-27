package miancurocho.springbackend.repository;

import miancurocho.springbackend.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByEmployeeId(Long employeeId);
}
