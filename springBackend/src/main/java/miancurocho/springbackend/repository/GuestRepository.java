package miancurocho.springbackend.repository;

import miancurocho.springbackend.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    Guest findByGuestId(Long guestId);
}
