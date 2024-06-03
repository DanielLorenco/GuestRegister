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

    @Query(value = "SELECT g FROM guest g WHERE" +
            " (:#{#filter.surname} IS NULL OR LOWER(g.surname) LIKE LOWER(CONCAT('%', :#{#filter.surname}, '%'))) " +
            "AND (:#{#filter.countryCode} IS NULL OR :#{#filter.countryCode} = '' OR g.countryCode = :#{#filter.countryCode}) " +
            "AND (:#{#filter.roomNumber} IS NULL OR :#{#filter.roomNumber} = '' OR g.roomNumber = :#{#filter.roomNumber}) " +
            "AND (:#{#filter.arrivalDate} IS NULL OR g.arrivalDate >= :#{#filter.arrivalDate}) " +
            "AND (:#{#filter.departureDate} IS NULL OR g.departureDate <= :#{#filter.departureDate} OR g.departureDate IS NULL)"
    )
    List<GuestEntity> getFilteredGuests(@Param("filter") GuestFilter filter, Pageable pageable);
}
