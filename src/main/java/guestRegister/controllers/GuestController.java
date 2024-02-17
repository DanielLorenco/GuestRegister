package guestRegister.controllers;

import guestRegister.constant.StayType;
import guestRegister.dto.GuestDTO;
import guestRegister.dto.mapper.GuestMapper;
import guestRegister.entity.filter.GuestFilter;
import guestRegister.service.GuestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class GuestController {

    private final GuestService guestService;

    private final GuestMapper guestMapper;

    @PostMapping({"/guests/", "/guests"})
    public GuestDTO addGuest(@RequestBody GuestDTO guestDTO, @RequestParam String roomNumber, @RequestParam boolean yesterdayArrival) {
        return guestService.addGuest(guestDTO, roomNumber, yesterdayArrival);
    }

    @GetMapping(value = {"/LONG_TERM", "/LONG_TERM/"})
    public List<GuestDTO> getLongTerm(@RequestParam(required = false, defaultValue = Integer.MAX_VALUE + "") int limit) {
        return guestService.getGuestsByStayType(StayType.LONG_TERM, limit);
    }

    @GetMapping(value = {"/SHORT_TERM", "/SHORT_TERM/"})
    public List<GuestDTO> getShortTerm(@RequestParam(required = false, defaultValue = Integer.MAX_VALUE + "") int limit) {
        return guestService.getGuestsByStayType(StayType.SHORT_TERM, limit);
    }

    @GetMapping({"/guests/", "/guests"})
    public List<GuestDTO> getAllGuests(GuestFilter guestFilter) {
        return guestService.getAllGuests(guestFilter);
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