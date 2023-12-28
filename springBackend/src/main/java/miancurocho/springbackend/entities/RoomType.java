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

@Entity(name = "ROOM_TYPE")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RoomType {
    @Id
    @JsonProperty("room_type")
    @GeneratedValue(generator = "room_type_seq")
    @SequenceGenerator(name="room_type_seq", sequenceName = "ROOM_TYPE_SEQ",allocationSize = 1)
    private Long roomType;
    @JsonProperty("room_name")
    private String roomName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("price")
    private Long price;
    @JsonProperty("max_guests")
    private Integer maxGuests;
    @JsonProperty("beds")
    private Integer beds;
    @JsonProperty("area")
    private Long area;
}
