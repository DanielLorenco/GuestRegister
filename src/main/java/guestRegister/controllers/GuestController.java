package guestRegister.controllers;


import guestRegister.models.dto.GuestDTO;
import guestRegister.models.dto.mappers.GuestMapper;
import guestRegister.models.services.GuestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @Autowired
    private GuestMapper guestMapper;

    @GetMapping("index")
    public String renderIndex(Model model) {
        List<GuestDTO> guests = guestService.getAll();
        model.addAttribute("guests", guests);

        return "pages/guests/index";
    }

    @GetMapping("create")
    public String renderCreateForm(@ModelAttribute GuestDTO guest) {
        return "pages/guests/create";
    }

    @PostMapping("create")
    public String createGuest(@Valid @ModelAttribute GuestDTO guest, BindingResult result) {
        if (result.hasErrors())
            return renderCreateForm(guest);

        guestService.create(guest);
        System.out.println(guest.getName() + " " + guest.getSurname());

        return "redirect:index";
    }

    @GetMapping("{guestId}")
    public String renderDetail(@PathVariable Long guestId, Model model) {
        GuestDTO guest = guestService.getById(guestId);
        model.addAttribute("guest", guest);

        return "pages/guests/detail";
    }

    @GetMapping("edit/{guestId}")
    public String renderEditForm(
            @PathVariable Long guestId,
            GuestDTO guest
    ) {
        GuestDTO fetchedGuest = guestService.getById(guestId);
        guestMapper.updateGuestDTO(fetchedGuest, guest);
        return "pages/guests/edit";
    }

    @PostMapping("edit/{guestId}")
    public String editGuest(
            @PathVariable Long guestId,
            @Valid GuestDTO guest,
            BindingResult result
    ) {
        if (result.hasErrors())
            return renderEditForm(guestId, guest);
        guest.setGuestId(guestId);
        guestService.edit(guest);
        return "redirect:/guests/index";
    }

    @PostMapping({"/{guestId}", "/{guestId}/"})
    public String removeGuest(@PathVariable Long guestId, RedirectAttributes redirectAttributes) {
        guestService.removeGuest(guestId);
        redirectAttributes.addFlashAttribute("deleted", true);
        return "redirect:/guests/index";
    }

}