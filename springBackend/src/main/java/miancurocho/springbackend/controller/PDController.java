package miancurocho.springbackend.controller;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.PD;
import miancurocho.springbackend.service.PDService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PDController {
    private final PDService pdService;
    @GetMapping(path="/allPDs")
    public List<PD> displayPDs(){return pdService.getAllPDs();}

    @GetMapping(path="/getPD/{PDId}")
    public PD getPD(@PathVariable Long PDId){return pdService.getPD(PDId);}

    @PostMapping(path= "/addPD")
    public @ResponseBody PD addPD(@RequestBody PD PDToAdd){
        return pdService.addPD(PDToAdd);
    }

    @PostMapping(path="/deletePDById/{PDId}")
    public void deletePDById(@PathVariable Long PDId){pdService.deletePDById(PDId);}

    @PostMapping(path="/updatePD")
    public @ResponseBody PD updatePD(@RequestBody PD PDToUpdate){
        return pdService.updatePD(PDToUpdate);
    }
}
