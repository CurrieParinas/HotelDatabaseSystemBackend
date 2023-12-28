package miancurocho.springbackend.service;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.ServiceRoomType;
import miancurocho.springbackend.repository.ServiceRoomTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceRoomTypeService {
    private final ServiceRoomTypeRepository serviceRoomTypeRepository;

    public List<ServiceRoomType> getAllServiceRoomTypes(){return serviceRoomTypeRepository.findAll();}

    public List<ServiceRoomType> getServicePerRoomType(Long roomType){return serviceRoomTypeRepository.findByRoomType(roomType);}

    public ServiceRoomType getServiceRoomType(Long roomType, Long serviceId){return serviceRoomTypeRepository.findByRoomTypeAndServiceId(roomType, serviceId);}

    public ServiceRoomType addServiceRoomType(ServiceRoomType serviceRoomTypeToAdd){return serviceRoomTypeRepository.save(serviceRoomTypeToAdd);}
}
