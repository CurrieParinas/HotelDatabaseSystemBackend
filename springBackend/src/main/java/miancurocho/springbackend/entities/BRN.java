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

@Entity(name = "BRN")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BRN {
    @Id
    @JsonProperty("brn_id")
    private String brnId;
    @JsonProperty("employee_id")
    private Long employeeId;
    @JsonProperty("booking_date")
    private Date bookingDate;
    @JsonProperty("check_in_date")
    private Date checkInDate;
    @JsonProperty("check_out_date")
    private Date checkOutDate;
    @JsonProperty("status")
    private String status;
    @JsonProperty("total_cost")
    private Long totalCost;
}
