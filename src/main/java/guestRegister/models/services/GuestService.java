package guestRegister.models.services;

import guestRegister.data.entities.GuestEntity;
import guestRegister.data.repositories.GuestRepository;
import guestRegister.models.dto.GuestDTO;
import guestRegister.models.dto.mappers.GuestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;




@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private GuestMapper guestMapper;


    public void create(GuestDTO guest) {
        GuestEntity newGuest = guestMapper.toEntity(guest);
        guestRepository.save(newGuest);
    }


    public List<GuestDTO> getAll() {
        Iterable<GuestEntity> guestEntities = guestRepository.findAll();
        List<GuestDTO> guestDTOs = new ArrayList<>();

        for (GuestEntity guestEntity : guestEntities) {
            guestDTOs.add(guestMapper.toDTO(guestEntity));
        }
        return guestDTOs;
    }


    public GuestDTO getById(Long guestId) {
        GuestEntity fetchedGuest = getGuestOrThrow(guestId);
        return guestMapper.toDTO(fetchedGuest);
    }


    public void edit(GuestDTO guest) {
        GuestEntity fetchedGuest = getGuestOrThrow(guest.getGuestId());
        guestMapper.updateGuestEntity(guest, fetchedGuest);
        guestRepository.save(fetchedGuest);

    }

    private GuestEntity getGuestOrThrow(Long guestId) {
        return guestRepository
                .findById(guestId)
                .orElseThrow();
    }


    public GuestDTO removeGuest(Long guestId) {
        GuestEntity fetchedEntity = getGuestOrThrow(guestId);
        GuestDTO model = guestMapper.toDTO(fetchedEntity);
        guestRepository.delete(fetchedEntity);
        return model;
    }
}
