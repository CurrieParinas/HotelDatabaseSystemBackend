package miancurocho.springbackend.repository;

import miancurocho.springbackend.entities.BRN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface BRNRepository extends JpaRepository<BRN,String> {
    BRN findByBrnId(String BRNId);

    @Query(
            value = "SELECT R.ROOM_NUMBER, B.BRN_ID\n" +
                    "FROM ROOM R JOIN CHARGE C ON R.ROOM_NUMBER = C.ROOM_NUMBER\n" +
                    "            JOIN BRN B ON C.BRN_ID = B.BRN_ID\n" +
                    "WHERE STATUS = 'BOOKED' OR STATUS = 'CHECKED-IN'",
            nativeQuery = true
    )
    List<Map<String, Object>> findBookedOrCheckedInRooms();
}
