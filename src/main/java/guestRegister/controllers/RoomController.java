package guestRegister.controllers;

import guestRegister.dto.RoomDTO;
import guestRegister.dto.mapper.RoomMapper;
import guestRegister.service.RoomService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RoomController {

    private final RoomService roomService;

    private final RoomMapper roomMapper;

    public RoomController(RoomService roomService, RoomMapper roomMapper) {
        this.roomService = roomService;
        this.roomMapper = roomMapper;
    }

@PostMapping({"/room", "/room/"})
    public RoomDTO addRoom(@RequestBody RoomDTO roomDTO) {
    return  roomService.addRoom(roomDTO);
}


}
