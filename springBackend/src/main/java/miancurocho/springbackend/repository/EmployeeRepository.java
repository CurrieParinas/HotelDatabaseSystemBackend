package miancurocho.springbackend.repository;

import miancurocho.springbackend.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByEmployeeId(Long employeeId);
    List<Employee> findEmployeesBySupervisor(Long supervisor);
}
