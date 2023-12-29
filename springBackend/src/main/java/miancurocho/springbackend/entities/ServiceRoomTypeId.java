package miancurocho.springbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ServiceRoomTypeId implements Serializable {
    private Long roomType;
    private Long serviceId;
}
