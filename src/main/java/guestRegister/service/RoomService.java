package guestRegister.service;


import guestRegister.dto.RoomDTO;
import guestRegister.dto.mapper.RoomMapper;
import guestRegister.entity.RoomEntity;
import guestRegister.entity.repository.RoomRepository;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class RoomService {

    private RoomRepository roomRepository;

    private RoomMapper roomMapper;

    public RoomDTO addRoom(RoomDTO roomDTO) {
        RoomEntity room = roomMapper.toEntity(roomDTO);
        RoomEntity saved = roomRepository.save(room);
        return roomMapper.toDTO(saved);
    }

    public List<RoomDTO> getAllRooms() {
        List<RoomDTO> result = new ArrayList<>();
        for (RoomEntity room : roomRepository.findAll()) {
            result.add(roomMapper.toDTO(room));
        }
        return result;
    }

    public RoomDTO getRoomById(Long id) {
        RoomEntity room = roomRepository.getReferenceById(id);
        return roomMapper.toDTO(room);
    }

    public RoomDTO deleteRoom(Long id) {
        RoomDTO deletedRoom = getRoomById(id);
        roomRepository.deleteById(id);
        return deletedRoom;
    }
}
