package guestRegister.service;

import guestRegister.constant.StayType;
import guestRegister.dto.GuestDTO;
import guestRegister.dto.mapper.GuestMapper;
import guestRegister.entity.GuestEntity;
import guestRegister.entity.RoomEntity;
import guestRegister.entity.filter.GuestFilter;
import guestRegister.entity.repository.GuestRepository;
import guestRegister.entity.repository.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class GuestService {

    private final GuestRepository guestRepository;

    private final GuestMapper guestMapper;

    private final RoomRepository roomRepository;

    /**
     * Allows user to add new guest while requesting room number and based on yesterdayArrival boolean sets the arrivalDate to today or yesterday
     * @param guestDTO DTO with attributes of new guest
     * @param roomNumber room Number of room entity where the new guest will be living in
     * @param yesterdayArrival option if the guest arrived today or yesterday
     * @return DTO of saved new guest
     */
    public GuestDTO addGuest(GuestDTO guestDTO, String roomNumber, boolean yesterdayArrival) {
        GuestEntity newGuest = guestMapper.toEntity(guestDTO);
        RoomEntity existingRoom = roomRepository.findByRoomNumber(roomNumber);
        if(existingRoom != null) {
            if (yesterdayArrival) {
                newGuest.setArrivalDate(LocalDate.now().minusDays(1));
            } else {newGuest.setArrivalDate(LocalDate.now());}
            newGuest.setRoom(existingRoom);
            newGuest.setRoomNumber(existingRoom.getRoomNumber());
            existingRoom.getAccommodatedGuests().add(newGuest);
            existingRoom.setOccupied(true);
            existingRoom.setTidy(false);
            roomRepository.save(existingRoom);
            GuestEntity savedEntity = guestRepository.save(newGuest);
            return guestMapper.toDTO(savedEntity);
        } else {
            throw new NullPointerException("Room with this room number does not exist");
        }
    }

    public List<GuestDTO> getGuestsByStayType(StayType stayType, int limit) {
        Page<GuestEntity> pageOfGuests = guestRepository.getAllByStayType(stayType, PageRequest.of(0, limit));
        List<GuestEntity> guestEntities = pageOfGuests.getContent();

        List<GuestDTO> result = new ArrayList<>();
        for (GuestEntity g : guestEntities) {
            result.add(guestMapper.toDTO(g));
        }
        return result;
    }

    public List<GuestDTO> getAllGuests(GuestFilter guestFilter) {
        return guestRepository.getFilteredGuests(guestFilter, PageRequest.of(0, guestFilter.getLimit()))
                .stream()
                .map(guestMapper::toDTO)
                .collect(Collectors.toList());
    }

    public GuestDTO getGuestDetail(Long guestId) {
        GuestEntity guest = guestRepository.getReferenceById(guestId);
        return guestMapper.toDTO(guest);
    }

    /**
     * Allows the user to edit the guest based on input of guest ID and the guests new attributes, keeps the attribute room, roomNumber and ID same
     * @param guestId ID of the updated guest
     * @param guestDTO DTO with guests new attributes
     * @return DTO of updated guest
     */
    public GuestDTO editGuest(Long guestId, GuestDTO guestDTO) {
        if (!guestRepository.existsById(guestId)) {
            throw new EntityNotFoundException("Person with id " + guestId + " was not found in the database.");
        }
        GuestEntity entity = guestRepository.getReferenceById(guestId);
        guestDTO.setGuestId(guestId);
        guestDTO.setRoomNumber(entity.getRoomNumber());
        guestDTO.setRoom(entity.getRoom());
        guestMapper.updateGuestEntity(guestDTO, entity);
        GuestEntity saved = guestRepository.save(entity);
        return guestMapper.toDTO(saved);
    }

    /**
     * Removes the guest from database based on input of guest ID and changes the room attribute occupied to false if the room is empty
     * @param guestId ID of the Guest
     * @return DTO of deleted guest
     */
    public GuestDTO removeGuest(Long guestId) {
        GuestEntity fetchedEntity = getGuestOrThrow(guestId);
        RoomEntity room = fetchedEntity.getRoom();
        GuestDTO guestDTO = guestMapper.toDTO(fetchedEntity);
        guestRepository.delete(fetchedEntity);
        if (room.getAccommodatedGuests().isEmpty()) {
            room.setOccupied(false);
            roomRepository.save(room);
        }
        return guestDTO;
    }

    private GuestEntity getGuestOrThrow(Long guestId) {
        return guestRepository
                .findById(guestId)
                .orElseThrow(() -> new EntityNotFoundException("Person with id " + guestId + " was not found in the database."));
    }












}
