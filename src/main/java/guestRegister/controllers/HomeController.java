package guestRegister.controllers;


import guestRegister.models.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @Autowired
    private GuestService guestService;

    @GetMapping("/")
    public String renderIndex() {
        return "pages/home/index";

    }


}