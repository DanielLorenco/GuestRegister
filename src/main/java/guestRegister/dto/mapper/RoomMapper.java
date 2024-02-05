package guestRegister.dto.mapper;

import guestRegister.dto.RoomDTO;
import guestRegister.entity.RoomEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {GuestMapper.class})
public interface RoomMapper {

    @Mapping(target = "accommodatedGuests", ignore = true)
    RoomEntity toEntity(RoomDTO source);

    RoomDTO toDTO(RoomEntity source);

    @Mapping(target = "accommodatedGuests", ignore = true)
    RoomEntity updateEntity(RoomDTO source, @MappingTarget RoomEntity target);
}
