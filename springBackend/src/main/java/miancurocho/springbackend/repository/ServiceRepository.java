package miancurocho.springbackend.repository;

import miancurocho.springbackend.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ServiceRepository extends JpaRepository<Service,Long> {
    Service findByServiceId(Long serviceId);

    @Query(
            value = "SELECT SERVICE_NAME, PRICE, SERVICE_DATE\n" +
                    "FROM SERVICE    JOIN SERVICE_LINE SL ON SERVICE.SERVICE_ID = SL.SERVICE_ID\n" +
                    "                JOIN CHARGE C ON SL.CHARGE_ID = C.CHARGE_ID\n" +
                    "                JOIN ROOM R ON C.ROOM_NUMBER = R.ROOM_NUMBER\n" +
                    "                JOIN BRN B ON C.BRN_ID = B.BRN_ID\n" +
                    "                JOIN SERVICE_ROOM_TYPE SRT on SERVICE.SERVICE_ID = SRT.SERVICE_ID\n" +
                    "WHERE C.ROOM_NUMBER = ?1 AND C.BRN_ID = ?2 AND EMPLOYEE_TYPE = ?3",
            nativeQuery = true
    )
    List<Map<String, Object>> findAvailedServicesOfRoomAndBRN(Long roomNumber, String BRN, String employeeType);
}
