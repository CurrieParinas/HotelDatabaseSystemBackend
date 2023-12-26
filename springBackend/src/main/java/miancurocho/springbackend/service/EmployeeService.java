package miancurocho.springbackend.service;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.Employee;
import miancurocho.springbackend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){return employeeRepository.findAll();}

    public Employee getEmployee(Long employeeId){return employeeRepository.findByEmployeeId(employeeId);}
}
