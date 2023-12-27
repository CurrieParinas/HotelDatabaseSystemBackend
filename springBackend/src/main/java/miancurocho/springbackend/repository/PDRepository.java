package miancurocho.springbackend.repository;

import miancurocho.springbackend.entities.PD;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PDRepository extends JpaRepository<PD,Long> {
    PD findByPaymentDetailsId(Long paymentDetailsId);
}
