package miancurocho.springbackend.controller;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.Charge;
import miancurocho.springbackend.service.ChargeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/charge")
public class ChargeController {
    private final ChargeService chargeService;
    @GetMapping(path="/all")
    public List<Charge> displayCharges(){return chargeService.getAllCharges();}

    @GetMapping(path="/{chargeId}")
    public Charge getCharge(@PathVariable Long chargeId){return chargeService.getCharge(chargeId);}

    @PostMapping(path= "/add")
    public @ResponseBody Charge addCharge(@RequestBody Charge chargeToAdd){
        return chargeService.addCharge(chargeToAdd);
    }

    @PostMapping(path="/delete/{chargeId}")
    public void deleteChargeById(@PathVariable Long chargeId){chargeService.deleteChargeById(chargeId);}

    @PostMapping(path="/update")
    public @ResponseBody Charge updateCharge(@RequestBody Charge chargeToUpdate){
        return chargeService.updateCharge(chargeToUpdate);
    }

    @GetMapping(path = "/roomsOfBRN/{BRN}")
    public List<Long> displayRoomsOfBRN(@PathVariable String BRN) {
        return chargeService.getRoomsOfBRN(BRN);
    }

    @GetMapping(path = "/chargesOfBRN/{BRN}")
    public List<Charge> displayChargesOfBRN(@PathVariable String BRN) {
        return chargeService.getChargesOfBRN(BRN);
    }
}
