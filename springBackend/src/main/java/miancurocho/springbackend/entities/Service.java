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
    private Long serviceId;
    @JsonProperty("service_name")
    private String serviceName;
    @JsonProperty("service_type")
    private String serviceType;
    @JsonProperty("employee_type")
    private String employeeType;
}
