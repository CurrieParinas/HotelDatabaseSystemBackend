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

import java.util.Date;

@Entity(name = "GUEST")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Guest {
    @Id
    @JsonProperty("guest_id")
    @GeneratedValue(generator = "guest_seq")
    @SequenceGenerator(name="guest_seq", sequenceName = "GUEST_SEQ",allocationSize = 1)
    private Long guestId;
    @JsonProperty("brn_id")
    private String brnId;
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
    @JsonProperty("guest_type")
    private Character guestType;

    public Guest(String brnId, String firstName, String middleName, String lastName, Date birthday, String address, Long contactNumber, String emailAddress, Integer age) {
        this.brnId = brnId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
        this.age = age;
    }
}
