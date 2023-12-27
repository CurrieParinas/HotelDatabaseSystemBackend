package miancurocho.springbackend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity(name = "EMPLOYEE")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Employee {
    @Id
    @JsonProperty("employee_id")
    @GeneratedValue(generator = "employee_seq")
    @SequenceGenerator(name="employee_seq", sequenceName = "EMPLOYEE_SEQ",allocationSize = 1)
    private Long employeeId;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("middle_name")
    private String middleName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("birthday")
    private Date birthday;
    @JsonProperty("address")
    private String address;
    @JsonProperty("contact_number")
    private Long contactNumber;
    @JsonProperty("email_address")
    private String emailAddress;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("supervisor")
    private Long supervisor;
    @JsonProperty("employee_type")
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
