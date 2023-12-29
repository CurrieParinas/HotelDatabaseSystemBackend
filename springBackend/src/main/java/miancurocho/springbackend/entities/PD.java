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

@Entity(name = "PAYMENT_DETAILS")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PD {
    @Id
    @JsonProperty("payment_detail_id")
    @GeneratedValue(generator = "pd_seq")
    @SequenceGenerator(name="pd_seq", sequenceName = "PD_SEQ",allocationSize = 1)
    private Long paymentDetailsId;
    @JsonProperty("brn_id")
    private String brnId;
    @JsonProperty("mode_of_payment")
    private String modeOfPayment;
    @JsonProperty("card_number")
    private Long cardNumber;
    @JsonProperty("cvv")
    private Long cvv;
    @JsonProperty("expiration_date")
    private Date expirationDate;
}
