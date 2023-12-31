package miancurocho.springbackend.service;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.BRN;
import miancurocho.springbackend.entities.BRN;
import miancurocho.springbackend.repository.BRNRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BRNService {
    private final BRNRepository brnRepository;

    public List<BRN> getAllBRNs(){return brnRepository.findAll();}

    public BRN getBRN(String brnId){return brnRepository.findByBrnId(brnId);}

    public BRN addBRN(BRN brnToAdd){return brnRepository.save(brnToAdd);}
    public void deleteBRNById(String brnId){brnRepository.deleteById(brnId);}

    public BRN updateBRN(BRN brnToUpdate){
        Optional<BRN> optionalExistingBRN = brnRepository.findById(brnToUpdate.getBrnId());

        if(optionalExistingBRN.isPresent()){
            BRN existingBRN = optionalExistingBRN.get();

            if(brnToUpdate.getEmployeeId() != null){
                existingBRN.setEmployeeId(brnToUpdate.getEmployeeId());
            }
            if(brnToUpdate.getBookingDate() != null){
                existingBRN.setBookingDate(brnToUpdate.getBookingDate());
            }
            if(brnToUpdate.getCheckInDate() != null){
                existingBRN.setCheckInDate(brnToUpdate.getCheckInDate());
            }
            if(brnToUpdate.getCheckOutDate() != null){
                existingBRN.setCheckOutDate(brnToUpdate.getCheckOutDate());
            }
            if(brnToUpdate.getStatus() != null){
                existingBRN.setStatus(brnToUpdate.getStatus());
            }
            if(brnToUpdate.getTotalCost() != null){
                existingBRN.setTotalCost(brnToUpdate.getTotalCost());
            }

            return brnRepository.save(existingBRN);
        }
        return null;
    }

    public List<String> getAllActiveBRN() {
        return brnRepository.findAllActiveBRN();
    }
}
