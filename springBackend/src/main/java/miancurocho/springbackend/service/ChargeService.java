package miancurocho.springbackend.service;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.Charge;
import miancurocho.springbackend.repository.ChargeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChargeService {
    private final ChargeRepository chargeRepository;

    public List<Charge> getAllCharges(){return chargeRepository.findAll();}

    public Charge getCharge(Long chargeId){return chargeRepository.findByChargeId(chargeId);}

    public Charge addCharge(Charge chargeToAdd){return chargeRepository.save(chargeToAdd);}
    public void deleteChargeById(Long chargeId){chargeRepository.deleteById(chargeId);}

    public Charge updateCharge(Charge chargeToUpdate){
        Optional<Charge> optionalExistingCharge = chargeRepository.findById(chargeToUpdate.getChargeId());

        if(optionalExistingCharge.isPresent()){
            Charge existingCharge = optionalExistingCharge.get();

            if(chargeToUpdate.getBrnId() != null){
                existingCharge.setBrnId(chargeToUpdate.getBrnId());
            }
            if(chargeToUpdate.getRoomNumber() != null){
                existingCharge.setRoomNumber(chargeToUpdate.getRoomNumber());
            }
            if(chargeToUpdate.getChargeDate() != null){
                existingCharge.setChargeDate(chargeToUpdate.getChargeDate());
            }
            if(chargeToUpdate.getCost() != null){
                existingCharge.setCost(chargeToUpdate.getCost());
            }

            return chargeRepository.save(existingCharge);
        }
        return null;
    }
}
