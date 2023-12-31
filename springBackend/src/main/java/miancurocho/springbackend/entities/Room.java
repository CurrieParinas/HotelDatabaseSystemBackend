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
    private Long roomNumber;
    @JsonProperty("room_type")
    private Long roomType;
}
