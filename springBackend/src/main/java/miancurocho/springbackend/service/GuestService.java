package miancurocho.springbackend.service;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.Guest;
import miancurocho.springbackend.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GuestService {
    private final GuestRepository guestRepository;

    public List<Guest> getAllGuests(){return guestRepository.findAll();}

    public Guest getGuest(Long guestId){return guestRepository.findByGuestId(guestId);}

    public Guest addGuest(Guest guestToAdd) {
        // Get the birthday from the guest
        Date birthday = guestToAdd.getBirthday();

        // Convert Date to LocalDate
        Instant instant = Instant.ofEpochMilli(birthday.getTime());
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();

        // Calculate age based on the birthday
        int age = Period.between(localDate, LocalDate.now()).getYears();

        // Set the calculated age to the guest
        guestToAdd.setAge(age);

        // Save the guest to the repository
        return guestRepository.save(guestToAdd);
    }
    public void deleteGuestById(Long guestId){guestRepository.deleteById(guestId);}
    
    public Guest updateGuest(Guest guestToUpdate){
        Optional<Guest> optionalExistingGuest = guestRepository.findById(guestToUpdate.getGuestId());

        if(optionalExistingGuest.isPresent()){
            Guest existingGuest = optionalExistingGuest.get();

            if(guestToUpdate.getBrnId() != null){
                existingGuest.setBrnId(guestToUpdate.getBrnId());
            }
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
            if(guestToUpdate.getGuestType() != null){
                existingGuest.setGuestType(guestToUpdate.getGuestType());
            }

            return guestRepository.save(existingGuest);
        }
        return null;
    }
    public List<Guest> addMultipleGuests(List<Guest> guests) {
        for(int i = 0; i < guests.size(); i++) {
            if (i == 0) {
                guests.get(i).setGuestType('P');
            } else {
                guests.get(i).setGuestType('S');
            }
        }
        return guestRepository.saveAll(guests);
    }

    public List<Map<String, Object>> getPrimaryGuestOfBRN(String BRN) {
        return guestRepository.findPrimaryGuestOfBRN(BRN);
    }
}

