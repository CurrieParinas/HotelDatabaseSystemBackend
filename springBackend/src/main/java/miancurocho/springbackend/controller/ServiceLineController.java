package miancurocho.springbackend.controller;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.ServiceLine;
import miancurocho.springbackend.service.ServiceLineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ServiceLineController {
    private final ServiceLineService serviceLineService;
    @GetMapping(path="/allServiceLines")
    public List<ServiceLine> displayServiceLines(){return serviceLineService.getAllServiceLines();}

    @GetMapping(path="/getServiceLine/{serviceLineId}")
    public ServiceLine getServiceLine(@PathVariable Long serviceLineId){return serviceLineService.getServiceLine(serviceLineId);}

    @PostMapping(path= "/addServiceLine")
    public @ResponseBody ServiceLine addServiceLine(@RequestBody ServiceLine serviceLineToAdd){
        return serviceLineService.addServiceLine(serviceLineToAdd);
    }

    @PostMapping(path="/deleteServiceLineById/{serviceLineId}")
    public void deleteServiceLineById(@PathVariable Long serviceLineId){serviceLineService.deleteServiceLineById(serviceLineId);}

    @PostMapping(path="/updateServiceLine")
    public @ResponseBody ServiceLine updateServiceLine(@RequestBody ServiceLine serviceLineToUpdate){
        return serviceLineService.updateServiceLine(serviceLineToUpdate);
    }
}