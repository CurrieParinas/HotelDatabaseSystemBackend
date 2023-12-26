package miancurocho.springbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "EMPLOYEE")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(generator = "employee_seq")
    @SequenceGenerator(name="employee_seq", sequenceName = "EMPLOYEE_SEQ",allocationSize = 1)
    private Long employeeId;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthday;
    private String address;
    private Long contactNumber;
    private String emailAddress;
    private Integer age;
    private Long supervisor;
    private String employeeType;

    public Employee( String firstName, String middleName, String lastName,
                    Date birthday, String address, Long contactNumber, String emailAddress,
                    Integer age, Long supervisor, String employeeType) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
        this.age = age;
        this.supervisor = supervisor;
        this.employeeType = employeeType;
    }
}
