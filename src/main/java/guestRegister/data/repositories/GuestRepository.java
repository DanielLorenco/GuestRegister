package guestRegister.data.repositories;

import guestRegister.data.entities.GuestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface GuestRepository extends CrudRepository<GuestEntity, Long>, ListCrudRepository<GuestEntity, Long> {

}
