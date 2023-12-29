package guestRegister.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

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


    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getIdPassportNumber() {
        return idPassportNumber;
    }

    public void setIdPassportNumber(String idPassportNumber) {
        this.idPassportNumber = idPassportNumber;
    }

    public String getVisaNumber() {
        return visaNumber;
    }

    public void setVisaNumber(String visaNumber) {
        this.visaNumber = visaNumber;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
}
