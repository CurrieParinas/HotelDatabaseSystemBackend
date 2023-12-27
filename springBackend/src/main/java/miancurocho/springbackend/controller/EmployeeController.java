package miancurocho.springbackend.controller;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.Employee;
import miancurocho.springbackend.service.EmployeeService;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping(path="/allEmployees")
    public List<Employee> displayEmployees(){return employeeService.getAllEmployees();}

    @GetMapping(path="/getEmployee/{employeeId}")
    public Employee getEmployee(@PathVariable Long employeeId){return employeeService.getEmployee(employeeId);}

    @PostMapping(path= "/addEmployee")
    public @ResponseBody Employee addEmployee(@RequestBody Employee employeeToAdd){
        return employeeService.addEmployee(employeeToAdd);
    }

    @PostMapping(path="/deleteEmployeeById/{employeeId}")
    public void deleteEmployeeById(@PathVariable Long employeeId){employeeService.deleteEmployeeById(employeeId);}

    @PostMapping(path="/updateEmployee")
    public @ResponseBody Employee updateEmployee(@RequestBody Employee employeeToUpdate){
        return employeeService.updateEmployee(employeeToUpdate);
    }
}
