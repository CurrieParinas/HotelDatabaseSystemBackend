package miancurocho.springbackend.repository;

import miancurocho.springbackend.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface RoomRepository extends JpaRepository<Room,Long> {
    Room findByRoomNumber(Long roomNumber);

    @Query(
            value = "SELECT R.ROOM_NUMBER, ROOM_NAME, DESCRIPTION, PRICE, MAX_GUESTS, BEDS, AREA\n" +
                    "FROM ROOM R LEFT JOIN ROOM_TYPE RT on R.ROOM_TYPE = RT.ROOM_TYPE\n" +
                    "            LEFT JOIN CHARGE C ON R.ROOM_NUMBER = C.ROOM_NUMBER\n" +
                    "            LEFT JOIN BRN B ON C.BRN_ID = B.BRN_ID\n" +
                    "WHERE R.ROOM_NUMBER NOT IN (SELECT R.ROOM_NUMBER\n" +
                    "                            FROM ROOM R LEFT JOIN CHARGE C ON R.ROOM_NUMBER = C.ROOM_NUMBER\n" +
                    "                                        LEFT JOIN BRN B ON C.BRN_ID = B.BRN_ID\n" +
                    "                            WHERE B.BRN_ID NOT IN (SELECT BRN_ID FROM BRN WHERE STATUS = 'CHECKED-OUT')\n" +
                    "                            GROUP BY R.ROOM_NUMBER)\n" +
                    "GROUP BY R.ROOM_NUMBER, ROOM_NAME, DESCRIPTION, PRICE, MAX_GUESTS, BEDS, AREA",
            nativeQuery = true
    )
    List<Map<String, Object>> findAllAvailableRooms();
}
