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

@Entity(name = "CHARGE")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Charge {
    @Id
    @JsonProperty("charge_id")
    @GeneratedValue(generator = "charge_seq")
    @SequenceGenerator(name="charge_seq", sequenceName = "CHARGE_SEQ",allocationSize = 1)
    private Long chargeId;
    @JsonProperty("brn_id")
    private String brnId;
    @JsonProperty("room_number")
    private Long roomNumber;
    @JsonProperty("cost")
    private Long cost;
}
