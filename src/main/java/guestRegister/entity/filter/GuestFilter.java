package guestRegister.entity.filter;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GuestFilter {

    private String surname;
    private String countryCode;
    private String roomNumber;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private Integer limit;

}
