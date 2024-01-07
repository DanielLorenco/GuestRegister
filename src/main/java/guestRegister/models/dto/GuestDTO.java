package guestRegister.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class GuestDTO {
     private Long guestId;

    @NotBlank(message = "Vyplňte jméno")
    @NotNull(message = "Vyplňte jméno")
    @Size(max = 1020, message = "Jméno je příliš dlouhé")
     private String name;

    @NotBlank(message = "Vyplňte příjmení")
    @NotNull(message = "Vyplňte příjmení")
    @Size(max = 1020, message = "Příjmení je příliš dlouhé")
     private String surname;
    @NotBlank(message = "Vyplňte kód státu")
    @NotNull(message = "Vyplňte kód státu")
    @Size(min = 3, max = 3)
     private String countryCode;
    @NotNull(message = "Vyplňte datum narození")
    @Past(message = "Datum narození musí být v minulosti")
     private LocalDate dateOfBirth;

     private String streetName;

     private String houseNumber;
    @NotBlank(message = "Vyplňte město")
    @NotNull(message = "Vyplňte město")
     private String cityName;

     private int zipCode;
    @NotBlank(message = "Vyplňte číslo ID nebo cestovního pasu")
    @NotNull(message = "Vyplňte číslo ID nebo cestovního pasu")
     private String idPassportNumber;

     private String visaNumber;

    @NotNull(message = "Vyplňte datum příjezdu")
     private LocalDate arrivalDate;

    @NotNull(message = "Vyplňte datum odjezdu")
     private LocalDate departureDate;


}
