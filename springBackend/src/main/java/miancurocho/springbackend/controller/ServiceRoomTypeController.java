package miancurocho.springbackend.controller;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.ServiceRoomType;
import miancurocho.springbackend.service.ServiceRoomTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/service-room-type")
public class ServiceRoomTypeController {
    private final ServiceRoomTypeService serviceRoomTypeService;
    @GetMapping(path="/all")
    public List<ServiceRoomType> displayServiceRoomTypes(){return serviceRoomTypeService.getAllServiceRoomTypes();}

    @GetMapping(path="/{roomType}")
    public List<ServiceRoomType> getServicePerRoomType(@PathVariable Long roomType){return serviceRoomTypeService.getServicePerRoomType(roomType);}

    @GetMapping(path="/{roomType}/{serviceId}")
    public ServiceRoomType getServiceRoomType(@PathVariable Long roomType, @PathVariable Long serviceId){return serviceRoomTypeService.getServiceRoomType(roomType, serviceId);}

    @PostMapping(path= "/add")
    public @ResponseBody ServiceRoomType addServiceRoomType(@RequestBody ServiceRoomType serviceRoomTypeToAdd){
        return serviceRoomTypeService.addServiceRoomType(serviceRoomTypeToAdd);
    }
}
