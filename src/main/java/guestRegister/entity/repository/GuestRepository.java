package guestRegister.entity.repository;

import guestRegister.constant.StayType;
import guestRegister.entity.GuestEntity;
import guestRegister.entity.filter.GuestFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GuestRepository extends PagingAndSortingRepository<GuestEntity, Long>,JpaRepository<GuestEntity, Long> {

    Page<GuestEntity> getAllByStayType(StayType stayType, Pageable page);

    @Query(value = "SELECT g FROM GuestEntity g WHERE" +
            "       (:#{#filter.getSurname()} IS NULL OR LOWER(g.surname) LIKE LOWER(CONCAT('%', :#{#filter.getSurname()}, '%'))) " +
            "AND    (:#{#filter.getCountryCode()} IS NULL OR g.countryCode = :#{#filter.getCountryCode()}) " +
            "AND    (:#{#filter.getRoomNumber()} IS NULL OR g.roomNumber = :#{#filter.getRoomNumber()}) " +
            "AND    (:#{#filter.getFromArrivalDate()} is null OR  g.arrival >= :#{#filter.getFromArrivalDate()})" +
            "AND    (:#{#filter.getToDepartureDate()} is null OR  g.departure <= :#{#filter.getToDepartureDate()})"
    )
    List<GuestEntity> getFilteredGuests(@Param("filter") GuestFilter filter, Pageable pageable);
}
