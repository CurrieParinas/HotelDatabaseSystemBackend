package miancurocho.springbackend.service;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.ServiceLine;
import miancurocho.springbackend.repository.ServiceLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceLineService {
    private final ServiceLineRepository serviceLineRepository;

    public List<ServiceLine> getAllServiceLines(){return serviceLineRepository.findAll();}

    public ServiceLine getServiceLine(Long serviceLineId){return serviceLineRepository.findByServiceLineId(serviceLineId);}

    public ServiceLine addServiceLine(ServiceLine serviceLineToAdd){return serviceLineRepository.save(serviceLineToAdd);}
    public void deleteServiceLineById(Long serviceLineId){serviceLineRepository.deleteById(serviceLineId);}

    public ServiceLine updateServiceLine(ServiceLine serviceLineToUpdate){
        Optional<ServiceLine> optionalExistingServiceLine = serviceLineRepository.findById(serviceLineToUpdate.getServiceLineId());

        if(optionalExistingServiceLine.isPresent()){
            ServiceLine existingServiceLine = optionalExistingServiceLine.get();

            if(serviceLineToUpdate.getChargeId() != null){
                existingServiceLine.setChargeId(serviceLineToUpdate.getChargeId());
            }
            if(serviceLineToUpdate.getServiceId() != null){
                existingServiceLine.setChargeId(serviceLineToUpdate.getServiceId());
            }
            if(serviceLineToUpdate.getEmployeeId() != null){
                existingServiceLine.setEmployeeId(serviceLineToUpdate.getEmployeeId());
            }
            if(serviceLineToUpdate.getServiceDate() != null){
                existingServiceLine.setServiceDate(serviceLineToUpdate.getServiceDate());
            }

            return serviceLineRepository.save(existingServiceLine);
        }
        return null;
    }
}
