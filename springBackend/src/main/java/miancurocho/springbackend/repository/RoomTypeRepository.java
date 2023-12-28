package miancurocho.springbackend.repository;

import miancurocho.springbackend.entities.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomType,Long> {
    RoomType findByRoomType(Long roomType);
}
