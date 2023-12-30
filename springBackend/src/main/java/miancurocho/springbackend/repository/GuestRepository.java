package miancurocho.springbackend.repository;

import miancurocho.springbackend.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    Guest findByGuestId(Long guestId);

    @Query(
            value = "SELECT G.FIRST_NAME, G.MIDDLE_NAME, G.LAST_NAME\n" +
                    "FROM GUEST G JOIN BRN B ON G.BRN_ID = B.BRN_ID\n" +
                    "WHERE G.BRN_ID = ?1 AND GUEST_TYPE = 'P'",
            nativeQuery = true
    )
    List<Map<String, Object>> findPrimaryGuestOfBRN(String BRN);
}
