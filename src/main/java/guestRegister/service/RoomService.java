package guestRegister.service;


import guestRegister.dto.RoomDTO;
import guestRegister.dto.mapper.RoomMapper;
import guestRegister.entity.RoomEntity;
import guestRegister.entity.repository.GuestRepository;
import guestRegister.entity.repository.RoomRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RoomService {

    private RoomRepository roomRepository;

    private GuestRepository guestRepository;

    private RoomMapper roomMapper;

    public RoomDTO addRoom(RoomDTO roomDTO) {
        RoomEntity room = roomMapper.toEntity(roomDTO);
        RoomEntity saved = roomRepository.save(room);
        return roomMapper.toDTO(saved);
    }
}
