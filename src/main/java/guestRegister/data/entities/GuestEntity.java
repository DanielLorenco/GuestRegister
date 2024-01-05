package guestRegister.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity(name = "guests")
public class GuestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guestId;

    @Column(nullable = false, length = 1020)
    private String name;

    @Column(nullable = false, length = 1020)
    private String surname;

    @Column(nullable = false, length = 3)
    private String countryCode;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    private String streetName;

    private String houseNumber;

    @Column(nullable = false)
    private String cityName;

    private int zipCode;

    @Column(nullable = false)
    private String idPassportNumber;

    private String visaNumber;

    @Column(nullable = false)
    private LocalDate arrivalDate;

    @Column(nullable = false)
    private LocalDate departureDate;


}