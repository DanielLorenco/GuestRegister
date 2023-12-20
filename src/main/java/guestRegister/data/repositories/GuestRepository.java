package guestRegister.data.repositories;

import guestRegister.data.entities.GuestEntity;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<GuestEntity, Long> {

}
