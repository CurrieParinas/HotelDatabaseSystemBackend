package miancurocho.springbackend.repository;

import miancurocho.springbackend.entities.Charge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChargeRepository extends JpaRepository<Charge,Long> {
    Charge findByChargeId(Long chargeId);

    @Query(
            value = "SELECT ROOM_NUMBER\n" +
                    "FROM CHARGE\n" +
                    "WHERE BRN_ID = ?1",
            nativeQuery = true
    )
    List<Long> findRoomsByBRN(String BRN);

    List<Charge> findByBrnId(String BRN);
}
