package miancurocho.springbackend.service;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.Employee;
import miancurocho.springbackend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){return employeeRepository.findAll();}

    public Employee getEmployee(Long employeeId){return employeeRepository.findByEmployeeId(employeeId);}

    public Employee addEmployee(Employee employeeToAdd){ return employeeRepository.save(employeeToAdd);}

    public void deleteEmployeeById(Long employeeId){employeeRepository.deleteById(employeeId);}

    public Employee updateEmployee(Employee employeeToUpdate){
        Optional<Employee> optionalExistingEmployee = employeeRepository.findById(employeeToUpdate.getEmployeeId());

        if(optionalExistingEmployee.isPresent()){
            Employee existingEmployee = optionalExistingEmployee.get();

            if(employeeToUpdate.getFirstName() != null){
                existingEmployee.setFirstName(employeeToUpdate.getFirstName());
            }
            if(employeeToUpdate.getMiddleName() != null){
                existingEmployee.setMiddleName(employeeToUpdate.getMiddleName());
            }
            if(employeeToUpdate.getLastName() != null){
                existingEmployee.setLastName(employeeToUpdate.getLastName());
            }
            if(employeeToUpdate.getBirthday() != null){
                existingEmployee.setBirthday(employeeToUpdate.getBirthday());
            }
            if(employeeToUpdate.getAddress() != null){
                existingEmployee.setAddress(employeeToUpdate.getAddress());
            }
            if(employeeToUpdate.getContactNumber() != null){
                existingEmployee.setContactNumber(employeeToUpdate.getContactNumber());
            }
            if(employeeToUpdate.getEmailAddress() != null){
                existingEmployee.setEmailAddress(employeeToUpdate.getEmailAddress());
            }
            if(employeeToUpdate.getAge() != null){
                existingEmployee.setAge(employeeToUpdate.getAge());
            }
            if(employeeToUpdate.getSupervisor() != null){
                existingEmployee.setSupervisor(employeeToUpdate.getSupervisor());
            }
            if(employeeToUpdate.getEmployeeType() != null){
                existingEmployee.setEmployeeType(employeeToUpdate.getEmployeeType());
            }
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }
}
