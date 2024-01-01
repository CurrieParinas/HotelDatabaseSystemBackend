package miancurocho.springbackend.repository;

import miancurocho.springbackend.entities.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AccountsRepository extends JpaRepository<Accounts,Long> {
    Accounts findByEmployeeId(Long employeeId);
    @Query(
            value = "SELECT E.EMPLOYEE_ID, E.EMPLOYEE_TYPE\n" +
                    "FROM EMPLOYEE E JOIN ACCOUNTS A on E.EMPLOYEE_ID = A.EMPLOYEE_ID\n" +
                    "WHERE A.EMAIL = ?1 AND A.PASSWORD = ?2",
            nativeQuery = true
    )
    List<Map<String, Object>> findIdANDEmployeeTypeByEmailAndPassword(String email, String password);
}
