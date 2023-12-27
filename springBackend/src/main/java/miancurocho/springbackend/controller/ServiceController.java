package miancurocho.springbackend.controller;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.Service;
import miancurocho.springbackend.service.ServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ServiceController {
    private final ServiceService serviceService;
    @GetMapping(path="/allServices")
    public List<Service> displayServices(){return serviceService.getAllServices();}

    @GetMapping(path="/getService/{serviceId}")
    public Service getService(@PathVariable Long serviceId){return serviceService.getService(serviceId);}

    @PostMapping(path= "/addService")
    public @ResponseBody Service addService(@RequestBody Service serviceToAdd){
        return serviceService.addService(serviceToAdd);
    }

    @PostMapping(path="/deleteServiceById/{serviceId}")
    public void deleteServiceById(@PathVariable Long serviceId){serviceService.deleteServiceById(serviceId);}

    @PostMapping(path="/updateService")
    public @ResponseBody Service updateService(@RequestBody Service serviceToUpdate){
        return serviceService.updateService(serviceToUpdate);
    }
}
