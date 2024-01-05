package guestRegister.controllers;

import guestRegister.constant.StayType;
import guestRegister.dto.GuestDTO;
import guestRegister.dto.mapper.GuestMapper;
import guestRegister.service.GuestService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GuestController {

    private final GuestService guestService;

    private final GuestMapper guestMapper;

    public GuestController(GuestService guestService, GuestMapper guestMapper) {
        this.guestService = guestService;
        this.guestMapper = guestMapper;
    }

    @PostMapping({"/guests/", "/guests"})
    public GuestDTO addGuest(@RequestBody GuestDTO guestDTO) {
        return guestService.addGuest(guestDTO);
    }

    @GetMapping(value = {"/longterm", "/longterm/"})
    public List<GuestDTO> getLongterm(@RequestParam int limit) {
        return guestService.getGuests(StayType.longterm, limit);
    }

    @GetMapping(value = {"/shortterm", "/shortterm/"})
    public List<GuestDTO> getShortterm(@RequestParam int limit) {
        return guestService.getGuests(StayType.shortterm, limit);
    }


    @GetMapping("/guests/{guestId}")
    public GuestDTO getGuestDetail(@PathVariable Long guestId) {
        return guestService.getGuestDetail(guestId);
    }

    @PutMapping({"/guests/{guestId}", "/guests/{guestId}/"})
    public GuestDTO editGuest(@PathVariable Long guestId, @RequestBody GuestDTO guestDTO) {
        return guestService.editGuest(guestId, guestDTO);
    }

    @DeleteMapping({"/guests/{guestId}", "/guests/{guestId}/"})
    public GuestDTO deleteGuest(@PathVariable Long guestId) {
        return guestService.removeGuest(guestId);
    }

}