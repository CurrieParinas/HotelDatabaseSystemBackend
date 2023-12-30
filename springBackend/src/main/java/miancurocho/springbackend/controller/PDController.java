package miancurocho.springbackend.controller;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.PD;
import miancurocho.springbackend.service.PDService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/payment-detail")
public class PDController {
    private final PDService pdService;
    @GetMapping(path="/all")
    public List<PD> displayPDs(){return pdService.getAllPDs();}

    @GetMapping(path="/{PDId}")
    public PD getPD(@PathVariable Long PDId){return pdService.getPD(PDId);}

    @PostMapping(path= "/add")
    public @ResponseBody PD addPD(@RequestBody PD PDToAdd){
        return pdService.addPD(PDToAdd);
    }

    @PostMapping(path="/delete/{PDId}")
    public void deletePDById(@PathVariable Long PDId){pdService.deletePDById(PDId);}

    @PostMapping(path="/update")
    public @ResponseBody PD updatePD(@RequestBody PD PDToUpdate){
        return pdService.updatePD(PDToUpdate);
    }
}
