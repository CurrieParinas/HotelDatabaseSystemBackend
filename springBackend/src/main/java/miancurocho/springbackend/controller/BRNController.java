package miancurocho.springbackend.controller;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.BRN;
import miancurocho.springbackend.service.BRNService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/brn")
public class BRNController {
    private final BRNService brnService;
    @GetMapping(path="/all")
    public List<BRN> displayBRNs(){return brnService.getAllBRNs();}

    @GetMapping(path="/{brnId}")
    public BRN getBRN(@PathVariable String brnId){return brnService.getBRN(brnId);}

    @PostMapping(path= "/add")
    public @ResponseBody BRN addBRN(@RequestBody BRN brnToAdd){
        return brnService.addBRN(brnToAdd);
    }

    @PostMapping(path="/delete/{brnId}")
    public void deleteBRNById(@PathVariable String brnId){brnService.deleteBRNById(brnId);}

    @PostMapping(path="/update")
    public @ResponseBody BRN updateBRN(@RequestBody BRN brnToUpdate){
        return brnService.updateBRN(brnToUpdate);
    }

    @GetMapping(path = "/allActiveBRN")
    public List<String> displayAllActiveBRN() {
        return brnService.getAllActiveBRN();
    }
}
