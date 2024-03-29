package guestRegister.entity.repository;

import guestRegister.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

    RoomEntity findByRoomNumber(String roomNumber);
}