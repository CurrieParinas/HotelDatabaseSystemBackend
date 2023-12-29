package miancurocho.springbackend.controller;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.ServiceLine;
import miancurocho.springbackend.service.ServiceLineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/service-line")
public class ServiceLineController {
    private final ServiceLineService serviceLineService;
    @GetMapping(path="/all")
    public List<ServiceLine> displayServiceLines(){return serviceLineService.getAllServiceLines();}

    @GetMapping(path="/{serviceLineId}")
    public ServiceLine getServiceLine(@PathVariable Long serviceLineId){return serviceLineService.getServiceLine(serviceLineId);}

    @PostMapping(path= "/add")
    public @ResponseBody ServiceLine addServiceLine(@RequestBody ServiceLine serviceLineToAdd){
        return serviceLineService.addServiceLine(serviceLineToAdd);
    }

    @PostMapping(path="/delete/{serviceLineId}")
    public void deleteServiceLineById(@PathVariable Long serviceLineId){serviceLineService.deleteServiceLineById(serviceLineId);}

    @PostMapping(path="/update")
    public @ResponseBody ServiceLine updateServiceLine(@RequestBody ServiceLine serviceLineToUpdate){
        return serviceLineService.updateServiceLine(serviceLineToUpdate);
    }
}