package miancurocho.springbackend.service;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.PD;
import miancurocho.springbackend.repository.PDRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PDService {
    private final PDRepository pdRepository;

    public List<PD> getAllPDs(){return pdRepository.findAll();}

    public PD getPD(Long paymentDetailsId){return pdRepository.findByPaymentDetailsId(paymentDetailsId);}

    public PD addPD(PD pdToAdd){return pdRepository.save(pdToAdd);}
    public void deletePDById(Long pdId){pdRepository.deleteById(pdId);}

    public PD updatePD(PD pdToUpdate){
        Optional<PD> optionalPaymentDetails = pdRepository.findById(pdToUpdate.getPaymentDetailsId());

        if(optionalPaymentDetails.isPresent()){
            PD existingPD = optionalPaymentDetails.get();

            if(pdToUpdate.getModeOfPayment() != null){
                existingPD.setModeOfPayment(pdToUpdate.getModeOfPayment());
            }
            if(pdToUpdate.getCardNumber() != null){
                existingPD.setCardNumber(pdToUpdate.getCardNumber());
            }
            if(pdToUpdate.getCvv() != null){
                existingPD.setCvv(pdToUpdate.getCvv());
            }
            if(pdToUpdate.getExpirationDate() != null){
                existingPD.setExpirationDate(pdToUpdate.getExpirationDate());
            }
            return pdRepository.save(existingPD);
        }
        return null;
    }
}
