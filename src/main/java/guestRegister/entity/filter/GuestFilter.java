package guestRegister.entity.filter;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GuestFilter {

    private Long guestId = -1L;
    private String surname = "";
    private String countryCode = "";
    private String roomNumber = "";
    private LocalDate fromArrivalDate;
    private LocalDate toDepartureDate;
    private Integer limit = 50;

}
