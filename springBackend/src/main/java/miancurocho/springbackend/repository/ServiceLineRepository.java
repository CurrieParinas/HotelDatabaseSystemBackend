package miancurocho.springbackend.repository;

import miancurocho.springbackend.entities.ServiceLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceLineRepository extends JpaRepository<ServiceLine,Long> {
    ServiceLine findByServiceLineId(Long serviceLineId);
}
