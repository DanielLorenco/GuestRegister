package guestRegister.dto.mapper;

import guestRegister.dto.GuestDTO;
import guestRegister.entity.GuestEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GuestMapper {

    GuestEntity toEntity(GuestDTO source);

    GuestDTO toDTO(GuestEntity source);

    void updateGuestDTO(GuestDTO source, @MappingTarget GuestDTO target);

    void updateGuestEntity(GuestDTO source, @MappingTarget GuestEntity target);


}
