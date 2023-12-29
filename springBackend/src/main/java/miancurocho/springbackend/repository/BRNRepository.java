package miancurocho.springbackend.repository;

import miancurocho.springbackend.entities.BRN;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BRNRepository extends JpaRepository<BRN,String> {
    BRN findByBrnId(String BRNId);
}
