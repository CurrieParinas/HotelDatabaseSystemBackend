package miancurocho.springbackend.repository;

import miancurocho.springbackend.entities.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts,Long> {
    Accounts findByEmployeeId(Long employeeId);
}
