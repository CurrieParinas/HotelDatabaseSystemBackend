package miancurocho.springbackend.repository;

import miancurocho.springbackend.entities.BRN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface BRNRepository extends JpaRepository<BRN,String> {
    BRN findByBrnId(String BRNId);

    @Query(
            value = "SELECT BRN_ID\n" +
                    "FROM BRN\n" +
                    "WHERE STATUS != 'CHECKED-OUT'",
            nativeQuery = true
    )
    List<String> findAllActiveBRN();
}
