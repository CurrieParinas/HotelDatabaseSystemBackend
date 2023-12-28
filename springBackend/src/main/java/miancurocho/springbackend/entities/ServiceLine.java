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

@Entity(name = "SERVICE_LINE")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ServiceLine {
    @Id
    @JsonProperty("service_line_id")
    @GeneratedValue(generator = "service_line_seq")
    @SequenceGenerator(name="service_line_seq", sequenceName = "SERVICE_LINE_SEQ",allocationSize = 1)
    private Long serviceLineId;
    @JsonProperty("charge_id")
    private Long chargeId;
    @JsonProperty("service_id")
    private Long serviceId;
    @JsonProperty("employee_id")
    private Long employeeId;
    @JsonProperty("service_date")
    private Date serviceDate;
}
