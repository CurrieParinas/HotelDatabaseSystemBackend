package miancurocho.springbackend.controller;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.BRN;
import miancurocho.springbackend.service.BRNService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BRNController {
    private final BRNService brnService;
    @GetMapping(path="/allBRNs")
    public List<BRN> displayBRNs(){return brnService.getAllBRNs();}

    @GetMapping(path="/getBRN/{brnId}")
    public BRN getBRN(@PathVariable String brnId){return brnService.getBRN(brnId);}

    @PostMapping(path= "/addBRN")
    public @ResponseBody BRN addBRN(@RequestBody BRN brnToAdd){
        return brnService.addBRN(brnToAdd);
    }

    @PostMapping(path="/deleteBRNById/{brnId}")
    public void deleteBRNById(@PathVariable String brnId){brnService.deleteBRNById(brnId);}

    @PostMapping(path="/updateBRN")
    public @ResponseBody BRN updateBRN(@RequestBody BRN brnToUpdate){
        return brnService.updateBRN(brnToUpdate);
    }
}
