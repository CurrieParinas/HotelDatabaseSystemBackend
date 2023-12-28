package miancurocho.springbackend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "ACCOUNTS")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Accounts {
    @Id
    @JsonProperty("employee_id")
    private Long employeeId;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
}
