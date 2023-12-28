package miancurocho.springbackend.service;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.RoomType;
import miancurocho.springbackend.repository.RoomTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomTypeService {
    private final RoomTypeRepository roomTypeRepository;

    public List<RoomType> getAllRoomTypes(){return roomTypeRepository.findAll();}

    public RoomType getRoomType(Long roomType){return roomTypeRepository.findByRoomType(roomType);}

    public RoomType addRoomType(RoomType roomTypeToAdd){return roomTypeRepository.save(roomTypeToAdd);}
    public void deleteRoomTypeById(Long roomTypeId){roomTypeRepository.deleteById(roomTypeId);}

    public RoomType updateRoomType(RoomType roomTypeToUpdate){
        Optional<RoomType> optionalExistingRoomType = roomTypeRepository.findById(roomTypeToUpdate.getRoomType());

        if(optionalExistingRoomType.isPresent()){
            RoomType existingRoomType = optionalExistingRoomType.get();

            if(roomTypeToUpdate.getRoomName() != null){
                existingRoomType.setRoomName(roomTypeToUpdate.getRoomName());
            }
            if(roomTypeToUpdate.getDescription() != null){
                existingRoomType.setDescription(roomTypeToUpdate.getDescription());
            }
            if(roomTypeToUpdate.getPrice() != null){
                existingRoomType.setPrice(roomTypeToUpdate.getPrice());
            }
            if(roomTypeToUpdate.getMaxGuests() != null){
                existingRoomType.setMaxGuests(roomTypeToUpdate.getMaxGuests());
            }
            if(roomTypeToUpdate.getBeds() != null){
                existingRoomType.setBeds(roomTypeToUpdate.getBeds());
            }
            if(roomTypeToUpdate.getArea() != null){
                existingRoomType.setArea(roomTypeToUpdate.getArea());
            }
            return roomTypeRepository.save(existingRoomType);
        }
        return null;
    }
}
