package guestRegister.service;

import guestRegister.constant.StayType;
import guestRegister.dto.GuestDTO;
import guestRegister.dto.mapper.GuestMapper;
import guestRegister.entity.GuestEntity;
import guestRegister.entity.repository.GuestRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class GuestService {


    private final GuestRepository guestRepository;

    private final GuestMapper guestMapper;

    public GuestService(GuestRepository guestRepository, GuestMapper guestMapper) {
        this.guestRepository = guestRepository;
        this.guestMapper = guestMapper;
    }


    public GuestDTO addGuest(GuestDTO guestDTO) {
        GuestEntity newGuest = guestMapper.toEntity(guestDTO);
        GuestEntity savedEntity = guestRepository.save(newGuest);
        return guestMapper.toDTO(savedEntity);
    }

    public List<GuestDTO> getGuests(StayType stayType, int limit) {
        Page<GuestEntity> pageOfGuests = guestRepository.getAllByStayType(stayType, PageRequest.of(0, limit));
        List<GuestEntity> guestEntities = pageOfGuests.getContent();

        List<GuestDTO> result = new ArrayList<>();
        for (GuestEntity g : guestEntities) {
            result.add(guestMapper.toDTO(g));
        }
        return result;
    }

    public GuestDTO getGuestDetail(Long guestId) {
        GuestEntity guest = guestRepository.getReferenceById(guestId);
        return guestMapper.toDTO(guest);
    }

    public GuestDTO editGuest(Long guestId, GuestDTO guestDTO) {
        if (!guestRepository.existsById(guestId)) {
            throw new EntityNotFoundException("Person with id " + guestId + " was not found in the database.");
        }
        GuestEntity entity = guestMapper.toEntity(guestDTO);
        entity.setGuestId(guestId);
        GuestEntity saved = guestRepository.save(entity);
        return guestMapper.toDTO(saved);
    }

    public GuestDTO removeGuest(Long guestId) {
        GuestEntity fetchedEntity = getGuestOrThrow(guestId);
        GuestDTO model = guestMapper.toDTO(fetchedEntity);
        guestRepository.delete(fetchedEntity);
        return model;
    }

    private GuestEntity getGuestOrThrow(Long guestId) {
        return guestRepository
                .findById(guestId)
                .orElseThrow(() -> new EntityNotFoundException("Person with id " + guestId + " was not found in the database."));
    }












}
