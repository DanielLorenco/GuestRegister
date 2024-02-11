package guestRegister.entity;

import guestRegister.constant.StayType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "guest")
@Getter
@Setter
public class GuestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long guestId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, length = 3)
    private String countryCode;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column
    private String streetName;

    @Column
    private String houseNumber;

    @Column(nullable = false)
    private String cityName;

    @Column
    private Integer zipCode;

    @Column(nullable = false)
    private String idPassportNumber;

    @Column
    private String visaNumber;

    @Column(nullable = false)
    private LocalDate arrivalDate;

    @Column(nullable = false)
    private LocalDate departureDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StayType stayType;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity room;

    @Column
    private String roomNumber;
}