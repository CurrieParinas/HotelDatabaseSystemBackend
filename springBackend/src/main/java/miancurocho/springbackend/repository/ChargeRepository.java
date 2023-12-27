package miancurocho.springbackend.repository;

import miancurocho.springbackend.entities.Charge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargeRepository extends JpaRepository<Charge,Long> {
    Charge findByChargeId(Long chargeId);
}
