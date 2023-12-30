package miancurocho.springbackend.controller;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.Guest;
import miancurocho.springbackend.service.GuestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/guest")
public class GuestController {
    private final GuestService guestService;
    @GetMapping(path="/all")
    public List<Guest> displayGuests(){return guestService.getAllGuests();}

    @GetMapping(path="/{guestId}")
    public Guest getGuest(@PathVariable Long guestId){return guestService.getGuest(guestId);}

    @PostMapping(path= "/add")
    public @ResponseBody Guest addGuest(@RequestBody Guest guestToAdd){
        return guestService.addGuest(guestToAdd);
    }

    @PostMapping(path="/delete/{guestId}")
    public void deleteGuestById(@PathVariable Long guestId){guestService.deleteGuestById(guestId);}

    @PostMapping(path="/update")
    public @ResponseBody Guest updateGuest(@RequestBody Guest guestToUpdate){
        return guestService.updateGuest(guestToUpdate);
    }

    @PostMapping("/addMultiple")
    public List<Guest> addMultipleGuests(@RequestBody List<Guest> guests) {
        return guestService.addMultipleGuests(guests);
    }

    @GetMapping(path = "/primaryGuestOfBRN/{BRN}")
    public List<Map<String, Object>> getPrimaryGuestOfBRN(@PathVariable String BRN){return guestService.getPrimaryGuestOfBRN(BRN);}
}
