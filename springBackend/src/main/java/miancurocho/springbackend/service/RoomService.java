package miancurocho.springbackend.service;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.Room;
import miancurocho.springbackend.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public List<Room> getAllRooms(){return roomRepository.findAll();}

    public Room getRoom(Long roomNumber){return roomRepository.findByRoomNumber(roomNumber);}

    public Room addRoom(Room roomToAdd){return roomRepository.save(roomToAdd);}
    public void deleteRoomById(Long roomId){roomRepository.deleteById(roomId);}

    public Room updateRoom(Room roomToUpdate){
        Optional<Room> optionalExistingRoom = roomRepository.findById(roomToUpdate.getRoomNumber());

        if(optionalExistingRoom.isPresent()){
            Room existingRoom = optionalExistingRoom.get();

            if(roomToUpdate.getRoomType() != null){
                existingRoom.setRoomType(roomToUpdate.getRoomType());
            }
            if(roomToUpdate.getDescription() != null){
                existingRoom.setDescription(roomToUpdate.getDescription());
            }
            if(roomToUpdate.getPrice() != null){
                existingRoom.setPrice(roomToUpdate.getPrice());
            }
            if(roomToUpdate.getMaxGuests() != null){
                existingRoom.setMaxGuests(roomToUpdate.getMaxGuests());
            }
            if(roomToUpdate.getBeds() != null){
                existingRoom.setBeds(roomToUpdate.getBeds());
            }
            if(roomToUpdate.getArea() != null){
                existingRoom.setArea(roomToUpdate.getArea());
            }
            return roomRepository.save(existingRoom);
        }
        return null;
    }
}
