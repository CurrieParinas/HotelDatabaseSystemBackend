package miancurocho.springbackend.service;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.Service;
import miancurocho.springbackend.repository.ServiceRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public List<Service> getAllServices(){return serviceRepository.findAll();}

    public Service getService(Long serviceId){return serviceRepository.findByServiceId(serviceId);}

    public Service addService(Service serviceToAdd){return serviceRepository.save(serviceToAdd);}
    public void deleteServiceById(Long serviceId){serviceRepository.deleteById(serviceId);}

    public Service updateService(Service serviceToUpdate){
        Optional<Service> optionalExistingService = serviceRepository.findById(serviceToUpdate.getServiceId());

        if(optionalExistingService.isPresent()){
            Service existingService = optionalExistingService.get();

            if(serviceToUpdate.getServiceName() != null){
                existingService.setServiceName(serviceToUpdate.getServiceName());
            }
            if(serviceToUpdate.getServiceType() != null){
                existingService.setServiceType(serviceToUpdate.getServiceType());
            }
            if(serviceToUpdate.getEmployeeType() != null){
                existingService.setEmployeeType(serviceToUpdate.getEmployeeType());
            }

            return serviceRepository.save(existingService);
        }
        return null;
    }

    public List<Map<String, Object>> getAvailedServicesOfRoomAndBRN(Long roomNumber, String BRN, String employeeType) {
        return serviceRepository.findAvailedServicesOfRoomAndBRN(roomNumber, BRN, employeeType);
    }

    public List<Service> getAllServicesByServiceType(String serviceType) {
        return serviceRepository.findByServiceType(serviceType);
    }
}
