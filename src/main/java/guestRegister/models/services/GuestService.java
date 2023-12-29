package guestRegister.models.services;

import guestRegister.models.dto.GuestDTO;

import java.util.List;

public interface GuestService {

    void create(GuestDTO guest);

    List<GuestDTO> getAll();

    GuestDTO getById(Long guestId);

    void edit(GuestDTO article);

    GuestDTO removeGuest(Long guestId);
}
