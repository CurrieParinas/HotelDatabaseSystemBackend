package miancurocho.springbackend.repository;

import miancurocho.springbackend.entities.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountsRepository extends JpaRepository<Accounts,Long> {
    Accounts findByEmployeeId(Long employeeId);
    Optional<Accounts> findByEmailAndPassword(String email, String password);
}
