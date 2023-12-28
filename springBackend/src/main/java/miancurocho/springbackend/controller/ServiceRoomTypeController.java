package miancurocho.springbackend.controller;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.ServiceRoomType;
import miancurocho.springbackend.service.ServiceRoomTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ServiceRoomTypeController {
    private final ServiceRoomTypeService serviceRoomTypeService;
    @GetMapping(path="/allServiceRoomTypes")
    public List<ServiceRoomType> displayServiceRoomTypes(){return serviceRoomTypeService.getAllServiceRoomTypes();}

    @GetMapping(path="/getServicePerRoomType/{roomType}")
    public List<ServiceRoomType> getServicePerRoomType(@PathVariable Long roomType){return serviceRoomTypeService.getServicePerRoomType(roomType);}

    @GetMapping(path="/getServiceRoomType/{roomType}/{serviceId}")
    public ServiceRoomType getServiceRoomType(@PathVariable Long roomType, @PathVariable Long serviceId){return serviceRoomTypeService.getServiceRoomType(roomType, serviceId);}

    @PostMapping(path= "/addServiceRoomType")
    public @ResponseBody ServiceRoomType addServiceRoomType(@RequestBody ServiceRoomType serviceRoomTypeToAdd){
        return serviceRoomTypeService.addServiceRoomType(serviceRoomTypeToAdd);
    }
}
