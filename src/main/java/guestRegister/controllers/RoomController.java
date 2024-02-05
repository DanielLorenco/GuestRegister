package guestRegister.controllers;

import guestRegister.dto.RoomDTO;
import guestRegister.dto.mapper.RoomMapper;
import guestRegister.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomController {

    private final RoomService roomService;

    private final RoomMapper roomMapper;

    public RoomController(RoomService roomService, RoomMapper roomMapper) {
        this.roomService = roomService;
        this.roomMapper = roomMapper;
    }

    @PostMapping({"/rooms", "/rooms/"})
    public RoomDTO addRoom(@RequestBody RoomDTO roomDTO) {
    return  roomService.addRoom(roomDTO);
}

    @GetMapping({"/rooms", "/rooms/"})
    public List<RoomDTO> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping({"/rooms/{id}", "/rooms/{id}/"})
    public RoomDTO getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }
}
