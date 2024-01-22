import guestRegister.dto.GuestDTO
import guestRegister.entity.GuestEntity
import guestRegister.service.GuestService
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Subject
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.beans.factory.annotation.Autowired
import guestRegister.entity.repository.GuestRepository
import guestRegister.constant.StayType;
import java.time.LocalDate
import java.time.format.DateTimeFormatter;

@SpringBootTest
class GuestServiceTestClass extends Specification {

    @Autowired
    GuestService guestService

    @Autowired
    GuestRepository guestRepository

    @Subject
    GuestDTO addGuestResult

    def setup() {
    println("DEBUG: Autowired GuestService: $guestService")
    }

    def "Adding a new guest should return the correct DTO"() {
        given:
        GuestDTO guestDTO = createSampleGuestDTO()
        println("DEBUG: createSampleGuestDTO result: $guestDTO")

        when:
        addGuestResult = guestService.addGuest(guestDTO)

        then:
        1 * guestRepository.save(_ as GuestEntity) >> { GuestEntity guestEntity ->

            guestEntity.name == guestDTO.name
            guestEntity.surname == guestDTO.surname
            guestEntity.countryCode == guestDTO.countryCode
            guestEntity.dateOfBirth == guestDTO.dateOfBirth
            guestEntity.streetName == guestDTO.streetName
            guestEntity.houseNumber == guestDTO.houseNumber
            guestEntity.cityName == guestDTO.cityName
            guestEntity.zipCode == guestDTO.zipCode
            guestEntity.idPassportNumber == guestDTO.idPassportNumber
            guestEntity.visaNumber == guestDTO.visaNumber
            guestEntity.arrivalDate == guestDTO.arrivalDate
            guestEntity.departureDate == guestDTO.departureDate
            guestEntity.stayType == guestDTO.stayType
        }

        and:

        addGuestResult.name == guestDTO.name
        addGuestResult.surname == guestDTO.surname
        addGuestResult.countryCode == guestDTO.countryCode
        addGuestResult.dateOfBirth == guestDTO.dateOfBirth
        addGuestResult.streetName == guestDTO.streetName
        addGuestResult.houseNumber == guestDTO.houseNumber
        addGuestResult.cityName == guestDTO.cityName
        addGuestResult.zipCode == guestDTO.zipCode
        addGuestResult.idPassportNumber == guestDTO.idPassportNumber
        addGuestResult.visaNumber == guestDTO.visaNumber
        addGuestResult.arrivalDate == guestDTO.arrivalDate
        addGuestResult.departureDate == guestDTO.departureDate
        addGuestResult.stayType == guestDTO.stayType
    }

    public static GuestDTO createSampleGuestDTO() {
        def dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")

        return new GuestDTO(
                name: "John",
                surname: "Doe",
                countryCode: "CZE",
                dateOfBirth: LocalDate.of(1992, 2, 16),
                streetName: "Sample Street",
                houseNumber: "123",
                cityName: "Sample City",
                zipCode: 12345,
                idPassportNumber: "ABC123",
                visaNumber: "XYZ456",
                arrivalDate: LocalDate.of(2024, 1, 25),
                departureDate: LocalDate.of(2024, 6, 30),
                stayType: StayType.longterm
        )

    }
}
