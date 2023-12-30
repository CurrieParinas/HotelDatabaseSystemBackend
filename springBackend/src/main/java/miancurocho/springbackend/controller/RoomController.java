package miancurocho.springbackend.controller;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.Room;
import miancurocho.springbackend.service.RoomService;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/room")
public class RoomController {
    private final RoomService roomService;
    @GetMapping(path="/all")
    public List<Room> displayRooms(){return roomService.getAllRooms();}

    @GetMapping(path="/{roomNumber}")
    public Room getRoom(@PathVariable Long roomNumber){return roomService.getRoom(roomNumber);}

    @PostMapping(path= "/add")
    public @ResponseBody Room addRoom(@RequestBody Room roomToAdd){
        return roomService.addRoom(roomToAdd);
    }

    @PostMapping(path="/delete/{roomId}")
    public void deleteRoomById(@PathVariable Long roomId){roomService.deleteRoomById(roomId);}

    @PostMapping(path="/update")
    public @ResponseBody Room updateRoom(@RequestBody Room roomToUpdate){
        return roomService.updateRoom(roomToUpdate);
    }

    @GetMapping(path="/allAvailableRooms")
    public List<Map<String, Object>> displayAvailableRooms(){return roomService.getAvailableRooms();}
}
