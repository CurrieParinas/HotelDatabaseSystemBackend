package miancurocho.springbackend.repository;

import miancurocho.springbackend.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Long> {
    Service findByServiceId(Long serviceId);
}
