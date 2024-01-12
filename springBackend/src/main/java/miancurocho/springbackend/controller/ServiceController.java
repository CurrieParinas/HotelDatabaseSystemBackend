package miancurocho.springbackend.controller;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.Service;
import miancurocho.springbackend.service.ServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/service")
public class ServiceController {
    private final ServiceService serviceService;
    @GetMapping(path="/all")
    public List<Service> displayServices(){return serviceService.getAllServices();}

    @GetMapping(path="/{serviceId}")
    public Service getService(@PathVariable Long serviceId){return serviceService.getService(serviceId);}

    @PostMapping(path= "/add")
    public @ResponseBody Service addService(@RequestBody Service serviceToAdd){
        return serviceService.addService(serviceToAdd);
    }

    @PostMapping(path="/delete/{serviceId}")
    public void deleteServiceById(@PathVariable Long serviceId){serviceService.deleteServiceById(serviceId);}

    @PostMapping(path="/update")
    public @ResponseBody Service updateService(@RequestBody Service serviceToUpdate){
        return serviceService.updateService(serviceToUpdate);
    }

    @GetMapping(path="/availedServicesOfRoomAndBRN")
    public List<Map<String, Object>> displayAvailedServicesOfRoomAndBRN(@RequestParam Long roomNumber, @RequestParam String BRN, @RequestParam String employeeType) {
        return serviceService.getAvailedServicesOfRoomAndBRN(roomNumber, BRN, employeeType);
    }

    @GetMapping(path="/servicesByServiceType/{serviceType}")
    public List<Service> displayAllServicesByServiceType(@PathVariable String serviceType) {
        return serviceService.getAllServicesByServiceType(serviceType);
    }
}
