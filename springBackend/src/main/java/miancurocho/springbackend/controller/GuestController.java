package miancurocho.springbackend.controller;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.Guest;
import miancurocho.springbackend.service.GuestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GuestController {
    private final GuestService guestService;
    @GetMapping(path="/allGuests")
    public List<Guest> displayGuests(){return guestService.getAllGuests();}

    @GetMapping(path="/getGuest/{guestId}")
    public Guest getGuest(@PathVariable Long guestId){return guestService.getGuest(guestId);}

    @PostMapping(path= "/addGuest")
    public @ResponseBody Guest addGuest(@RequestBody Guest guestToAdd){
        return guestService.addGuest(guestToAdd);
    }

    @PostMapping(path="/deleteGuestById/{guestId}")
    public void deleteGuestById(@PathVariable Long guestId){guestService.deleteGuestById(guestId);}

    @PostMapping(path="/updateGuest")
    public @ResponseBody Guest updateGuest(@RequestBody Guest guestToUpdate){
        return guestService.updateGuest(guestToUpdate);
    }
}
