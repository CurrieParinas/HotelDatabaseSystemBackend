package miancurocho.springbackend.controller;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.Charge;
import miancurocho.springbackend.service.ChargeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChargeController {
    private final ChargeService chargeService;
    @GetMapping(path="/allCharges")
    public List<Charge> displayCharges(){return chargeService.getAllCharges();}

    @GetMapping(path="/getCharge/{chargeId}")
    public Charge getCharge(@PathVariable Long chargeId){return chargeService.getCharge(chargeId);}

    @PostMapping(path= "/addCharge")
    public @ResponseBody Charge addCharge(@RequestBody Charge chargeToAdd){
        return chargeService.addCharge(chargeToAdd);
    }

    @PostMapping(path="/deleteChargeById/{chargeId}")
    public void deleteChargeById(@PathVariable Long chargeId){chargeService.deleteChargeById(chargeId);}

    @PostMapping(path="/updateCharge")
    public @ResponseBody Charge updateCharge(@RequestBody Charge chargeToUpdate){
        return chargeService.updateCharge(chargeToUpdate);
    }
}
