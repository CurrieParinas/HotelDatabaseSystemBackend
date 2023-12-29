package miancurocho.springbackend.controller;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.RoomType;
import miancurocho.springbackend.service.RoomTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/room-type")
public class RoomTypeController {
    private final RoomTypeService roomTypeService;
    @GetMapping(path="/all")
    public List<RoomType> displayRoomTypes(){return roomTypeService.getAllRoomTypes();}

    @GetMapping(path="/{roomType}")
    public RoomType getRoomType(@PathVariable Long roomType){return roomTypeService.getRoomType(roomType);}

    @PostMapping(path= "/add")
    public @ResponseBody RoomType addRoomType(@RequestBody RoomType roomTypeToAdd){
        return roomTypeService.addRoomType(roomTypeToAdd);
    }

    @PostMapping(path="/delete/{roomType}")
    public void deleteRoomTypeById(@PathVariable Long roomType){roomTypeService.deleteRoomTypeById(roomType);}

    @PostMapping(path="/update")
    public @ResponseBody RoomType updateRoomType(@RequestBody RoomType roomTypeToUpdate){
        return roomTypeService.updateRoomType(roomTypeToUpdate);
    }
}
