package guestRegister.models.services;

import guestRegister.data.entities.GuestEntity;
import guestRegister.data.repositories.GuestRepository;
import guestRegister.models.dto.GuestDTO;
import guestRegister.models.dto.mappers.GuestMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private GuestMapper guestMapper;

    @Override
    public void create(GuestDTO guest) {
        GuestEntity newGuest = guestMapper.toEntity(guest);
        guestRepository.save(newGuest);
    }

    @Override
    public List<GuestDTO> getAll() {
        return StreamSupport.stream(guestRepository.findAll().spliterator(), false)
                .map(i -> guestMapper.toDTO(i))
                .toList();
    }

    @Override
    public GuestDTO getById(long guestId) {
        GuestEntity fetchedGuest = getGuestOrThrow(guestId);
        return guestMapper.toDTO(fetchedGuest);
    }

    @Override
    public void edit(GuestDTO guest) {
        GuestEntity fetchedGuest = getGuestOrThrow(guest.getGuestId());
        guestMapper.updateGuestEntity(guest, fetchedGuest);
        guestRepository.save(fetchedGuest);

    }

    private GuestEntity getGuestOrThrow(long guestId) {
        return guestRepository
                .findById(guestId)
                .orElseThrow();
    }

    @Override
    public GuestDTO removeGuest(long guestId) {
        GuestEntity fetchedEntity = guestRepository.findById(guestId).orElseThrow(EntityNotFoundException::new);
        GuestDTO model = guestMapper.toDTO(fetchedEntity);
        guestRepository.delete(fetchedEntity);
        return model;
    }
}
