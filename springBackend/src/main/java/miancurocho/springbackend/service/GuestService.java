package miancurocho.springbackend.service;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.Guest;
import miancurocho.springbackend.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GuestService {
    private final GuestRepository guestRepository;

    public List<Guest> getAllGuests(){return guestRepository.findAll();}

    public Guest getGuest(Long guestId){return guestRepository.findByGuestId(guestId);}
    
    public Guest addGuest(Guest guestToAdd){return guestRepository.save(guestToAdd);}
    public void deleteGuestById(Long guestId){guestRepository.deleteById(guestId);}
    
    public Guest updateGuest(Guest guestToUpdate){
        Optional<Guest> optionalExistingGuest = guestRepository.findById(guestToUpdate.getGuestId());

        if(optionalExistingGuest.isPresent()){
            Guest existingGuest = optionalExistingGuest.get();

            if(guestToUpdate.getFirstName() != null){
                existingGuest.setFirstName(guestToUpdate.getFirstName());
            }
            if(guestToUpdate.getMiddleName() != null){
                existingGuest.setMiddleName(guestToUpdate.getMiddleName());
            }
            if(guestToUpdate.getLastName() != null){
                existingGuest.setLastName(guestToUpdate.getLastName());
            }
            if(guestToUpdate.getBirthday() != null){
                existingGuest.setBirthday(guestToUpdate.getBirthday());
            }
            if(guestToUpdate.getAddress() != null){
                existingGuest.setAddress(guestToUpdate.getAddress());
            }
            if(guestToUpdate.getContactNumber() != null){
                existingGuest.setContactNumber(guestToUpdate.getContactNumber());
            }
            if(guestToUpdate.getEmailAddress() != null){
                existingGuest.setEmailAddress(guestToUpdate.getEmailAddress());
            }
            if(guestToUpdate.getAge() != null){
                existingGuest.setAge(guestToUpdate.getAge());
            }

            return guestRepository.save(existingGuest);
        }
        return null;
    }  
}
