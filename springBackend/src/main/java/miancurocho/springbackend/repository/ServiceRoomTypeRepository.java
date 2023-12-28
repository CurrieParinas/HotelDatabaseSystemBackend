package miancurocho.springbackend.repository;

import miancurocho.springbackend.entities.ServiceRoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRoomTypeRepository extends JpaRepository<ServiceRoomType,Long> {
    List<ServiceRoomType> findByRoomType(Long roomType);
    ServiceRoomType findByRoomTypeAndServiceId(Long roomType, Long serviceId);
}
