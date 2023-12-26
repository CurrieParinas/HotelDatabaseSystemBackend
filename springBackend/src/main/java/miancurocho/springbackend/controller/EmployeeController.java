package miancurocho.springbackend.controller;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.Employee;
import miancurocho.springbackend.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping(path="/allEmployees")
    public List<Employee> displayEmployees(){return employeeService.getAllEmployees();}

    @GetMapping(path="/getEmployee/{employeeId}")
    public Employee getEmployee(@PathVariable Long employeeId){return employeeService.getEmployee(employeeId);}


}
