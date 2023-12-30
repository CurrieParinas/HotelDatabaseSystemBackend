package miancurocho.springbackend.controller;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.Employee;
import miancurocho.springbackend.service.EmployeeService;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping(path="/all")
    public List<Employee> displayEmployees(){return employeeService.getAllEmployees();}

    @GetMapping(path="/{employeeId}")
    public Employee getEmployee(@PathVariable Long employeeId){return employeeService.getEmployee(employeeId);}

    @PostMapping(path= "/add")
    public @ResponseBody Employee addEmployee(@RequestBody Employee employeeToAdd){
        return employeeService.addEmployee(employeeToAdd);
    }

    @PostMapping(path="/delete/{employeeId}")
    public void deleteEmployeeById(@PathVariable Long employeeId){employeeService.deleteEmployeeById(employeeId);}

    @PostMapping(path="/update")
    public @ResponseBody Employee updateEmployee(@RequestBody Employee employeeToUpdate){
        return employeeService.updateEmployee(employeeToUpdate);
    }
}
