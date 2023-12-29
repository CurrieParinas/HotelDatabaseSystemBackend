package miancurocho.springbackend.repository;

import miancurocho.springbackend.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface RoomRepository extends JpaRepository<Room,Long> {
    Room findByRoomNumber(Long roomNumber);

    @Query(
            value = "SELECT R.ROOM_NUMBER, ROOM_NAME, DESCRIPTION, PRICE, MAX_GUESTS, BEDS, AREA FROM ROOM R LEFT JOIN ROOM_TYPE RT on RT.ROOM_TYPE = R.ROOM_TYPE LEFT JOIN CHARGE C ON R.ROOM_NUMBER = C.ROOM_NUMBER LEFT JOIN BRN B ON C.BRN_ID = B.BRN_ID WHERE B.STATUS IS NULL OR B.STATUS = 'CHECKED-OUT' GROUP BY R.ROOM_NUMBER, ROOM_NAME, DESCRIPTION, PRICE, MAX_GUESTS, BEDS, AREA",
            nativeQuery = true
    )
    List<Map<String, Object>> findAllAvailableRooms();
}
