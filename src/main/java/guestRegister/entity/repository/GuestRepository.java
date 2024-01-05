package guestRegister.entity.repository;

import guestRegister.constant.StayType;
import guestRegister.entity.GuestEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<GuestEntity, Long> {

    Page<GuestEntity> getAllByStayType(StayType stayType, Pageable page);


}
