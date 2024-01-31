package guestRegister.controllers;

import guestRegister.dto.RoomDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RoomController {

@PostMapping({"/room", "/room/"})
    public RoomDTO addRoom(@RequestBody RoomDTO roomDTO) {
    System.out.println("TO DO...");
    return  new RoomDTO();
}
}
