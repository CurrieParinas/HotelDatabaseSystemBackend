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

@Entity(name = "SERVICE")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Service {
    @Id
    @JsonProperty("service_id")
    @GeneratedValue(generator = "service_seq")
    @SequenceGenerator(name="service_seq", sequenceName = "SERVICE_SEQ",allocationSize = 1)
    private Long serviceId;
    @JsonProperty("service_name")
    private String serviceName;
    @JsonProperty("employee_type")
    private String employeeType;
}
