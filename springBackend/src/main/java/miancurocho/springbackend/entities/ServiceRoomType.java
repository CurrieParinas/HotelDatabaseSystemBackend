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

@Entity(name = "SERVICE_ROOM_TYPE")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ServiceRoomType {
    @Id
    @JsonProperty("room_type")
    private Long roomType;
    @Id
    @JsonProperty("service_id")
    private Long serviceId;
    @JsonProperty("price")
    private Long price;
}
