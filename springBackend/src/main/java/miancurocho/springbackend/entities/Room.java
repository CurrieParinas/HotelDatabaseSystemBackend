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

@Entity(name = "ROOM")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Room {
    @Id
    @JsonProperty("room_number")
    @GeneratedValue(generator = "room_seq")
    @SequenceGenerator(name="room_seq", sequenceName = "ROOM_SEQ",allocationSize = 1)
    private Long roomNumber;
    @JsonProperty("room_type")
    private String roomType;
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
