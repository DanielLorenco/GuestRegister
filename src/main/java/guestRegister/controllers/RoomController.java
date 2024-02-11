package guestRegister.controllers;

import guestRegister.dto.RoomDTO;
import guestRegister.dto.mapper.RoomMapper;
import guestRegister.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class RoomController {

    private final RoomService roomService;

    private final RoomMapper roomMapper;

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
