package miancurocho.springbackend.repository;

import miancurocho.springbackend.entities.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomTypeRepository extends JpaRepository<RoomType,Long> {
    RoomType findByRoomType(Long roomType);

    @Query(
            value = "SELECT RT.PRICE\n" +
                    "FROM ROOM_TYPE RT JOIN ROOM R ON RT.ROOM_TYPE = R.ROOM_TYPE\n" +
                    "WHERE R.ROOM_NUMBER = ?1",
            nativeQuery = true
    )
    Long findPriceByRoomNumber(Long roomNum);
}
