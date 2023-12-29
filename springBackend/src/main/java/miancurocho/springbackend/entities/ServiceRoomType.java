package miancurocho.springbackend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity(name = "SERVICE_ROOM_TYPE")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@IdClass(ServiceRoomTypeId.class)
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

